package com.freetech.items.itemservice.infraestructure.adapters.in.http.controllers;

import com.freetech.items.itemservice.infraestructure.adapters.in.http.dtos.NewItemDto;
import com.freetech.items.itemservice.infraestructure.adapters.in.http.mappers.ItemMapper;
import com.freetech.items.itemservice.infraestructure.ports.in.CreateItemPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping(value = "v1/items")
@RestController
public class ItemController {
    private final CreateItemPort createItemPort;
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<NewItemDto> createItem(@RequestBody @Valid NewItemDto newItemDto) {
        var item = ItemMapper.toDomain(newItemDto);
        return new ResponseEntity<>(
                ItemMapper.toDto(createItemPort.createItem(item), NewItemDto.class),
                HttpStatus.CREATED);
    }
}
