package br.com.volks.cars.seller.entities;

import br.com.volks.cars.seller.dto.SimpleSellerDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Seller {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    /**
     * To DTO
     * @return SimpleSellerDTO
     */
    public SimpleSellerDTO toDTO() {
        SimpleSellerDTO dto = new SimpleSellerDTO(
                this.id,
                this.name
        );
        return dto;
    }
}
