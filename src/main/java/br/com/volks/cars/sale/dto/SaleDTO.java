package br.com.volks.cars.sale.dto;

import br.com.volks.cars.car.dto.CarDTO;
import br.com.volks.cars.seller.dto.SellerDTO;
import br.com.volks.cars.seller.dto.SimpleSellerDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.util.Date;

/**
 * DTO to represent a Sale Entity
 */
@Getter
@Setter
@NoArgsConstructor
public class SaleDTO {

    private Long id;
    private Date saleDate;
    private Float valor;
    private CarDTO car;
    private SimpleSellerDTO seller;
}
