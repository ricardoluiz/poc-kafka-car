package br.com.volks.cars.seller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO to represent a Simple Seller Entity
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SimpleSellerDTO {

    private Long id;
    private String name;
}
