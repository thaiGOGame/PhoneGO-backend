package iuh.fit.se.utils;

import java.math.BigDecimal;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import iuh.fit.se.models.dtos.ProductDTO;
import iuh.fit.se.models.enums.*;
import iuh.fit.se.models.services.ProductService;

@Component
public class DBInsertion {
	private  ProductService productService;

    private final Random random = new Random();

    // Insert 20 random ProductDTOs into the database
    public void insertProducts() {
        for (int i = 0; i < 20; i++) {
            ProductDTO productDTO = createRandomProductDTO();
            productService.save(productDTO);
        }
    }

    // Create a random ProductDTO with various attributes
    private ProductDTO createRandomProductDTO() {
        ProductDTO.ProductDTOBuilder builder = ProductDTO.builder();

        // Assign common product attributes
        builder.name("Product " + random.nextInt(1000))
               .brand(Brand.values()[random.nextInt(Brand.values().length)])
               .quantity(random.nextInt(100))
               .salePrice(BigDecimal.valueOf(random.nextDouble() * 1000))
               .purchasePrice(BigDecimal.valueOf(random.nextDouble() * 800))
               .discountedPrice(BigDecimal.valueOf(random.nextDouble() * 750));

        // Randomly select and set the category
        Category category = Category.values()[random.nextInt(Category.values().length)];
        builder.category(category);

        // Assign random attributes based on the selected category
        switch (category) {
            case PHONE:
                builder.os(OS.values()[random.nextInt(OS.values().length)])
                       .ram(RAM.values()[random.nextInt(RAM.values().length)])
                       .rom(ROM.values()[random.nextInt(ROM.values().length)])
                       .chip("Chip " + random.nextInt(10))
                       .screenSize(random.nextFloat() * 6 + 4); // Screen size between 4 and 10 inches
                break;
            case POWER_BANK:
                builder.capacity(random.nextInt(10000) + 5000) // Capacity between 5000 and 15000
                       .input("Input " + random.nextInt(5))
                       .output("Output " + random.nextInt(5))
                       .connectionType(ConnectionType.values()[random.nextInt(ConnectionType.values().length)]);
                break;
            case EARPHONE:
                builder.connectionType(ConnectionType.values()[random.nextInt(ConnectionType.values().length)])
                       .batteryLife(random.nextInt(30) + 5); // Battery life between 5 and 35 hours
                break;
            case CHARGING_CABLE:
                builder.connectionType(ConnectionType.values()[random.nextInt(ConnectionType.values().length)]);
                break;
        }

        return builder.build();
    }
}
