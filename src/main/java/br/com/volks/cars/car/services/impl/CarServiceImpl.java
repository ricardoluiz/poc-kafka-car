package br.com.volks.cars.car.services.impl;

import br.com.volks.cars.car.dto.CarDTO;
import br.com.volks.cars.car.dto.CarInsertDTO;
import br.com.volks.cars.car.entities.Car;
import br.com.volks.cars.car.repositories.CarRepository;
import br.com.volks.cars.car.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CarServiceImpl implements CarService {

    public final CarRepository carRepository;

    @Override
    public List<CarDTO> getAll() {
        List<CarDTO> listDTO = new ArrayList<>();
        for (Car car : carRepository.findAll()) {
            listDTO.add(car.toDTO());
        }
        return listDTO;
    }

    @Override
    public Optional<CarDTO> findById(Long id) {
        Optional<Car> opSeller = carRepository.findById(id);
        if (opSeller.isPresent()) {
            return opSeller.map(Car::toDTO);
        }
        return Optional.empty();
    }

    @Override
    public CarDTO save(CarInsertDTO dto) {
        Car car = carRepository.save(dto.toEntity());
        return car.toDTO();
    }

    @Override
    public void delete(Long id) {
        carRepository.deleteById(id);
    }

}
