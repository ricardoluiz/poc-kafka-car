package br.com.volks.cars.seller.controllers;

import br.com.volks.cars.seller.dto.SellerDTO;
import br.com.volks.cars.seller.services.SellerService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SellerStreamController {

    private final SellerService sellerService;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Gson jsonConverter;

    @KafkaListener(topics = "seller_response_topic")
    public void getSeller(String seller) throws Exception {
        System.out.println("Valor que chegou no topico....: " + seller);
        SellerDTO dto =(SellerDTO)jsonConverter.fromJson(seller, SellerDTO.class);
        sellerService.save(dto);
    }

}
