package com.micro.inventoryservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.micro.inventoryservice.dto.InventoryResponse;
import com.micro.inventoryservice.service.InventoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryCtrl {

    private final InventoryService inventoryService;

    // http://localhost:8082/api/inventory?sku-code=shampoo&sku-code=biscuit
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String>skuCode) {
        return inventoryService.isInStock(skuCode);
    }
}
