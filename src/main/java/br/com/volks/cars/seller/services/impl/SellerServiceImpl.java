package br.com.volks.cars.seller.services.impl;

import br.com.volks.cars.car.entities.Car;
import br.com.volks.cars.seller.dto.SellerDTO;
import br.com.volks.cars.seller.dto.SellerIdDTO;
import br.com.volks.cars.seller.dto.SimpleSellerDTO;
import br.com.volks.cars.seller.entities.Seller;
import br.com.volks.cars.seller.repositories.SellerRepository;
import br.com.volks.cars.seller.services.SellerService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Gson jsonConverter;

    @Override
    public void sendKafka(SellerIdDTO sellerIdDTO) {
        kafkaTemplate.send("seller_get_topic", jsonConverter.toJson(sellerIdDTO));
    }

    @Override
    public Optional<SimpleSellerDTO> findById(Long id) {
        Optional<Seller> opSeller = sellerRepository.findById(id);
        if (opSeller.isPresent()) {
            return opSeller.map(Seller::toDTO);
        }
        return Optional.empty();
    }

    @Override
    public Seller save(SellerDTO dto) {
        return sellerRepository.save(dto.toEntity());
    }
}
