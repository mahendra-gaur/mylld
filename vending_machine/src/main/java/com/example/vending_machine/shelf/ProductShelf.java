package com.example.vending_machine.shelf;

import com.example.vending_machine.products.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductShelf {
    private int code;
    private Product product;
    private boolean soldOut;

    @Override
    public String toString() {
        return "ProductShelf{" +
                "code=" + code +
                ", product=" + product +
                ", soldOut=" + soldOut +
                '}';
    }
}
