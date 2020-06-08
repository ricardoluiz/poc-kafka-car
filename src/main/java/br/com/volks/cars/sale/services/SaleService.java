package br.com.volks.cars.sale.services;

import br.com.volks.cars.sale.dto.SaleDTO;
import br.com.volks.cars.sale.dto.SaleInsertDTO;
import br.com.volks.cars.sale.entities.Sale;

import java.util.List;
import java.util.Optional;

public interface SaleService {

    List<SaleDTO> getAll();

    Optional<SaleDTO> findById(Long id);

    Sale save(SaleInsertDTO dto);
}
