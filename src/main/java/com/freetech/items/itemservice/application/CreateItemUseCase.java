package com.freetech.items.itemservice.application;

import com.freetech.items.itemservice.application.clients.ProductFeignClient;
import com.freetech.items.itemservice.application.enums.ExceptionEnum;
import com.freetech.items.itemservice.application.exception.BussinessException;
import com.freetech.items.itemservice.application.mappers.ItemEntityMapper;
import com.freetech.items.itemservice.domain.Item;
import com.freetech.items.itemservice.infraestructure.ports.in.CreateItemPort;
import com.freetech.items.itemservice.infraestructure.ports.out.EntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Component
public class CreateItemUseCase implements CreateItemPort {
    private final EntityRepository entityRepository;
    private final ProductFeignClient productFeignClient;

    @Override
    public Item createItem(Item item) {
        try {
            var product = productFeignClient.getProduct(item.getProductId());
            var itemEntity = ItemEntityMapper.toEntity(item);
            itemEntity.setTotal(product.getPrice().multiply(new BigDecimal(item.getQuantity())));
            itemEntity = entityRepository.save(itemEntity);
            item.setId(itemEntity.getId());
            return item;
        } catch (Exception ex) {
            throw new BussinessException(
                    ExceptionEnum.ERROR_CREATE_ITEM.getCode(),
                    ExceptionEnum.ERROR_CREATE_ITEM.getMessage(),
                    ex.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
