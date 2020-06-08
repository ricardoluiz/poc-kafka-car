package br.com.volks.cars.car.controllers;

import br.com.volks.cars.car.dto.CarDTO;
import br.com.volks.cars.car.dto.CarInsertDTO;
import br.com.volks.cars.car.services.CarService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1")
public class CarController {

    private final CarService carService;

    @ApiOperation(value = "Inserir um carro")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Carro inserido com sucesso!"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção.")
    })
    @PostMapping
    public ResponseEntity<CarDTO> save(@RequestBody CarInsertDTO dto) {
        CarDTO car = carService.save(dto);
        return new ResponseEntity<>(car, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Listar todos os carros")
    @GetMapping
    public ResponseEntity<List<CarDTO>> getAll() {
        List<CarDTO> list = new ArrayList<>();
        list = carService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @ApiOperation(value = "Dados do carro")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<CarDTO>> getById(@PathVariable Long id) {
        Optional<CarDTO> optional;
        try {
            optional = carService.findById(id);
            return new ResponseEntity<Optional<CarDTO>>(optional, HttpStatus.OK);
        } catch (NoSuchElementException exception) {
            return new ResponseEntity<Optional<CarDTO>>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Carro excluído."),
            @ApiResponse(code = 405, message = "Não foi permitido realizar a exclusão.")
    })
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        try {
            carService.delete(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<Void>(HttpStatus.METHOD_NOT_ALLOWED);
        }
    }
}
