package com.example.vending_machine.products;

import com.example.vending_machine.enums.ProductType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Product {
    ProductType type;
    int price;

    @Override
    public String toString() {
        return "Product{" +
                "type=" + type +
                ", price=" + price +
                '}';
    }
}
