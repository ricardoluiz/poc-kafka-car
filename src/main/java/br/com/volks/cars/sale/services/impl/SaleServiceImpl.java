package br.com.volks.cars.sale.services.impl;

import br.com.volks.cars.car.dto.CarDTO;
import br.com.volks.cars.car.entities.Car;
import br.com.volks.cars.car.repositories.CarRepository;
import br.com.volks.cars.car.services.CarService;
import br.com.volks.cars.sale.dto.SaleDTO;
import br.com.volks.cars.sale.dto.SaleInsertDTO;
import br.com.volks.cars.sale.entities.Sale;
import br.com.volks.cars.sale.repositories.SaleRepository;
import br.com.volks.cars.sale.services.SaleService;
import br.com.volks.cars.seller.dto.SellerIdDTO;
import br.com.volks.cars.seller.dto.SimpleSellerDTO;
import br.com.volks.cars.seller.services.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final CarService carService;
    private final SellerService sellerService;

    @Override
    public List<SaleDTO> getAll() {
        List<SaleDTO> listDTO = new ArrayList<>();
        for (Sale sale : saleRepository.findAll()) {
            SaleDTO dto = sale.toDTO();
            dto.setCar(carService.findById(sale.getCarId()).orElse(new CarDTO()));
            dto.setSeller(sellerService.findById(sale.getSellerId()).orElse(new SimpleSellerDTO()));
            listDTO.add(dto);
        }
        return listDTO;
    }

    @Override
    public Optional<SaleDTO> findById(Long id) {
        Optional<Sale> sale = saleRepository.findById(id);
        if (sale.isPresent()) {
            SaleDTO dto = sale.get().toDTO();
            dto.setCar(carService.findById(sale.get().getCarId()).orElse(new CarDTO()));
            dto.setSeller(sellerService.findById(sale.get().getSellerId()).orElse(new SimpleSellerDTO()));
            return Optional.of(dto);
        }
        return Optional.empty();
    }

    @Override
    public Sale save(SaleInsertDTO dto) {
        Sale sale = dto.toEntity();
        sellerService.sendKafka(new SellerIdDTO(dto.getSellerId()));
        return saleRepository.save(sale);
    }
}
