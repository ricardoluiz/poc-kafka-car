package br.com.volks.cars.car.dto;

import br.com.volks.cars.car.entities.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO to represent a Seller Entity to create a new one
 */
@Getter
@Setter
@AllArgsConstructor
public class CarInsertDTO {

    private String model;
    private String color;
    private String maker;
    private String modelYear;

    /**
     * Parse a DTO to Entity
     * @return Car
     */
    public Car toEntity() {
        Car entity = new Car();
        entity.setModel(this.model);
        entity.setColor(this.color);
        entity.setMaker(this.maker);
        entity.setModelYear(this.modelYear);
        return entity;
    }
}
