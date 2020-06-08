package br.com.volks.cars.seller.dto;

import br.com.volks.cars.seller.entities.Seller;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO to represent a Seller Entity
 */
@Getter
@Setter
@AllArgsConstructor
public class SellerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String unit;

    /**
     * Parse a DTO to Entity
     * @return Seller
     */
    public Seller toEntity() {
        Seller entity = new Seller();
        entity.setId(this.id);
        entity.setName(this.firstName + " " + this.lastName);
        return entity;
    }
}
