package com.possible.product.inventory.service.web.controllers;

import com.possible.product.inventory.service.web.mappers.ProductInventoryMapper;
import com.possible.product.inventory.service.repositories.ProductInventoryRepository;
import com.possible.product.inventory.service.web.model.ProductInventoryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by Possible.
 */
@Slf4j
@RequiredArgsConstructor
@RestController
public class ProductInventoryController {

    private final ProductInventoryRepository productInventoryRepository;
    private final ProductInventoryMapper productInventoryMapper;

    @GetMapping("api/v1/beer/{beerId}/inventory")
    List<ProductInventoryDto> listBeersById(@PathVariable UUID beerId){
        log.debug("Finding Inventory for beerId:" + beerId);

        return productInventoryRepository.findAllByBeerId(beerId)
                .stream()
                .map(productInventoryMapper::productInventoryToBeerInventoryDto)
                .collect(Collectors.toList());
    }
}
