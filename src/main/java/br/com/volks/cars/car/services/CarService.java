package br.com.volks.cars.car.services;

import br.com.volks.cars.car.dto.CarDTO;
import br.com.volks.cars.car.dto.CarInsertDTO;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<CarDTO> getAll();

    Optional<CarDTO> findById(Long id);

    CarDTO save(CarInsertDTO dto);

    void delete(Long id);
}
