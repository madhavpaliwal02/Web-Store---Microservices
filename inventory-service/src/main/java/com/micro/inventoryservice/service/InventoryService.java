package com.micro.inventoryservice.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.micro.inventoryservice.repository.InventoryRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepo inventoryRepo;

    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode) {
        return inventoryRepo.findBySkuCode(skuCode).isPresent();
    }
}
