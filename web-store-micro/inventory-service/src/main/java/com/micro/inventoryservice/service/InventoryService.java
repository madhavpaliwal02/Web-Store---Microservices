package com.micro.inventoryservice.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.inventoryservice.dto.InventoryResponse;
import com.micro.inventoryservice.repository.InventoryRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepo inventoryRepo;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        return inventoryRepo.findBySkuCodeIn(skuCode)
                .stream()
                .map(inventory -> InventoryResponse.builder()
                        .skuCode(inventory.getSkuCode())
                        .isInStock(inventory.getQuantity() > 0)
                        .build())
                .toList();
    }
}
