package br.com.volks.cars.sale.dto;

import br.com.volks.cars.sale.entities.Sale;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

/**
 * DTO to persist new Sale
 */
@Getter
@Setter
@AllArgsConstructor
public class SaleInsertDTO {

    private Float valor;
    private Long carId;
    private Long sellerId;

    /**
     * Return a Sale entity from DTO
     * @return Sale
     */
    public Sale toEntity() {
        Sale sale = new Sale();
        sale.setValor(this.valor);
        sale.setCarId(this.carId);
        sale.setSellerId(this.sellerId);
        return sale;
    }
}
