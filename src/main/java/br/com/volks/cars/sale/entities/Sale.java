package br.com.volks.cars.sale.entities;

import br.com.volks.cars.sale.dto.SaleDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sale_date")
    @CreationTimestamp
    private Date saleDate;

    @Column(name = "valor_venda")
    private Float valor;

    @Column(name = "car_id")
    private Long carId;

    @Column(name = "seller_id")
    private Long sellerId;

    /**
     * Entity to DTO
     * @return SaleDTO
     */
    public SaleDTO toDTO() {
        SaleDTO dto = new SaleDTO();
        dto.setId(this.id);
        dto.setSaleDate(this.saleDate);
        dto.setValor(this.valor);
        return dto;
    }
}
