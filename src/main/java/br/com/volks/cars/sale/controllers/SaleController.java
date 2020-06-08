package br.com.volks.cars.sale.controllers;

import br.com.volks.cars.car.dto.CarDTO;
import br.com.volks.cars.sale.dto.SaleDTO;
import br.com.volks.cars.sale.dto.SaleInsertDTO;
import br.com.volks.cars.sale.entities.Sale;
import br.com.volks.cars.sale.services.SaleService;
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
@RequestMapping("/sale/v1")
public class SaleController {

    private final SaleService saleService;

    @ApiOperation(value = "Listar todas as vendas")
    @GetMapping
    public ResponseEntity<List<SaleDTO>> getAll() {
        List<SaleDTO> list = new ArrayList<>();
        list = saleService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @ApiOperation(value = "Inserir uma venda")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Venda inserida com sucesso!"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção.")
    })
    @PostMapping
    public ResponseEntity<String> save(@RequestBody SaleInsertDTO dto) {
        saleService.save(dto);
        return new ResponseEntity<>("{'Sucesso':OK}", HttpStatus.CREATED);
    }

    @ApiOperation(value = "Dados de uma venda")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<SaleDTO>> getById(@PathVariable Long id) {
        Optional<SaleDTO> optional;
        try {
            optional = saleService.findById(id);
            return new ResponseEntity<Optional<SaleDTO>>(optional, HttpStatus.OK);
        } catch (NoSuchElementException exception) {
            return new ResponseEntity<Optional<SaleDTO>>(HttpStatus.NOT_FOUND);
        }
    }
}
