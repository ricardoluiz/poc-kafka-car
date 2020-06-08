package br.com.volks.cars.car.dto;

import br.com.volks.cars.car.entities.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO to represent a Seller Entity
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {

    private Long id;
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
        entity.setId(this.id);
        entity.setModel(this.model);
        entity.setColor(this.color);
        entity.setMaker(this.maker);
        entity.setModelYear(this.modelYear);
        return entity;
    }
}
