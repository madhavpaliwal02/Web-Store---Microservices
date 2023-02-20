package com.micro.inventoryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.micro.inventoryservice.model.Inventory;
import com.micro.inventoryservice.repository.InventoryRepo;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepo inventoryRepo){
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setSkuCode("Shampoo");
			inventory.setQuantity(100);

			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("Biscuit");
			inventory1.setQuantity(200);

			inventoryRepo.save(inventory);
			inventoryRepo.save(inventory1);
		};
	}

}
