package br.com.volks.cars.seller.services;

import br.com.volks.cars.seller.dto.SellerDTO;
import br.com.volks.cars.seller.dto.SellerIdDTO;
import br.com.volks.cars.seller.dto.SimpleSellerDTO;
import br.com.volks.cars.seller.entities.Seller;

import java.util.Optional;

public interface SellerService {

    Optional<SimpleSellerDTO> findById(Long id);

    Seller save(SellerDTO dto);

    void sendKafka(SellerIdDTO sellerIdDTO);
}
