package br.com.volks.cars.car.entities;

import br.com.volks.cars.car.dto.CarDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String model;
    private String color;
    private String maker;
    @Column(name = "model_year")
    private String modelYear;

    /**
     * Entity to DTO
     * @return CarDTO
     */
    public CarDTO toDTO() {
        CarDTO dto = new CarDTO(
                this.id,
                this.model,
                this.color,
                this.maker,
                this.modelYear
        );
        return dto;
    }
}
