package com.possible.product.inventory.service.web.mappers;

import com.possible.product.inventory.service.domain.ProductInventory;
import com.possible.product.inventory.service.domain.ProductInventory.ProductInventoryBuilder;
import com.possible.product.inventory.service.web.model.ProductInventoryDto;
import com.possible.product.inventory.service.web.model.ProductInventoryDto.ProductInventoryDtoBuilder;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-15T00:50:20+0100",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
@Component
public class ProductInventoryMapperImpl implements ProductInventoryMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public ProductInventory productInventoryDtoToBeerInventory(ProductInventoryDto productInventoryDTO) {
        if ( productInventoryDTO == null ) {
            return null;
        }

        ProductInventoryBuilder productInventory = ProductInventory.builder();

        productInventory.id( productInventoryDTO.getId() );
        productInventory.createdDate( dateMapper.asTimestamp( productInventoryDTO.getCreatedDate() ) );
        productInventory.lastModifiedDate( dateMapper.asTimestamp( productInventoryDTO.getLastModifiedDate() ) );
        productInventory.beerId( productInventoryDTO.getBeerId() );
        productInventory.quantityOnHand( productInventoryDTO.getQuantityOnHand() );

        return productInventory.build();
    }

    @Override
    public ProductInventoryDto productInventoryToBeerInventoryDto(ProductInventory productInventory) {
        if ( productInventory == null ) {
            return null;
        }

        ProductInventoryDtoBuilder productInventoryDto = ProductInventoryDto.builder();

        productInventoryDto.id( productInventory.getId() );
        productInventoryDto.createdDate( dateMapper.asOffsetDateTime( productInventory.getCreatedDate() ) );
        productInventoryDto.lastModifiedDate( dateMapper.asOffsetDateTime( productInventory.getLastModifiedDate() ) );
        productInventoryDto.beerId( productInventory.getBeerId() );
        productInventoryDto.quantityOnHand( productInventory.getQuantityOnHand() );

        return productInventoryDto.build();
    }
}
