package com.possible.product.inventory.service.bootstrap;

import com.possible.product.inventory.service.domain.ProductInventory;
import com.possible.product.inventory.service.repositories.ProductInventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by Possible.
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class ProductInventoryBootstrap implements CommandLineRunner {
    public static final String PRODUCT_1_UPC = "0631234200036";
    public static final String PRODUCT_2_UPC = "0631234300019";
    public static final String PRODUCT_3_UPC = "0083783375213";
    public static final UUID PRODUCT_1_UUID = UUID.fromString("0a818933-087d-47f2-ad83-2f986ed087eb");
    public static final UUID PRODUCT_2_UUID = UUID.fromString("a712d914-61ea-4623-8bd0-32c0f6545bfd");
    public static final UUID PRODUCT_3_UUID = UUID.fromString("026cc3c8-3a0c-4083-a05b-e908048c1b08");

    private final ProductInventoryRepository productInventoryRepository;

    @Override
    public void run(String... args) throws Exception {
        if(productInventoryRepository.count() == 0){
            loadInitialInv();
        }
    }

    private void loadInitialInv() {
        productInventoryRepository.save(ProductInventory
                .builder()
                .beerId(PRODUCT_1_UUID)
                .upc(PRODUCT_1_UPC)
                .quantityOnHand(50)
                .build());

        productInventoryRepository.save(ProductInventory
                .builder()
                .beerId(PRODUCT_2_UUID)
                .upc(PRODUCT_2_UPC)
                .quantityOnHand(50)
                .build());

        productInventoryRepository.saveAndFlush(ProductInventory
                .builder()
                .beerId(PRODUCT_3_UUID)
                .upc(PRODUCT_3_UPC)
                .quantityOnHand(50)
                .build());

        log.debug("Loaded Inventory. Record count: " + productInventoryRepository.count());
    }
}
