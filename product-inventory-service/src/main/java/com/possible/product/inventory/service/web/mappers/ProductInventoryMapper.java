package com.possible.product.inventory.service.web.mappers;

import com.possible.product.inventory.service.domain.ProductInventory;
import com.possible.product.inventory.service.web.model.ProductInventoryDto;
import org.mapstruct.Mapper;

/**
 * Created by Possible.
 */
@Mapper(uses = {DateMapper.class})
public interface ProductInventoryMapper {

    ProductInventory productInventoryDtoToBeerInventory(ProductInventoryDto productInventoryDTO);

    ProductInventoryDto productInventoryToBeerInventoryDto(ProductInventory productInventory);
}
