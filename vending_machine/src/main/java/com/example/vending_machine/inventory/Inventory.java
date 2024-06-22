package com.example.vending_machine.inventory;

import com.example.vending_machine.enums.ProductType;
import com.example.vending_machine.exception.InvalidProductCodeException;
import com.example.vending_machine.exception.ProductSoldOutException;
import com.example.vending_machine.products.Product;
import com.example.vending_machine.shelf.ProductShelf;
import java.util.Arrays;
import java.util.Objects;

public class Inventory {

    private ProductShelf[] inventory = null;

    private static volatile Inventory INSTANCE;

    public static Inventory getInstance() {
        if(Objects.isNull(INSTANCE)) {
            synchronized (Inventory.class) {
                if(Objects.isNull(INSTANCE)) {
                    INSTANCE = new Inventory();
                }
            }
        }
        return INSTANCE;
    }

    private Inventory() {
        int productCount = 10;
        inventory = new ProductShelf[productCount];
        initialEmptyInventory();
    }

    private void initialEmptyInventory() {
        int startCode = 101;
        for (int i = 0; i < inventory.length; i++) {
            ProductShelf space = ProductShelf.builder()
                    .code(startCode)
                    .soldOut(false)
                    .product(Product.builder()
                            .type(ProductType.COKE)
                            .price(16)
                            .build())
                    .build();
            inventory[i]= space;
            startCode++;
        }
    }

    public void addProduct(Product product, int codeNumber) throws Exception {
        for (ProductShelf productShelf : inventory) {
            if (productShelf.getCode() == codeNumber) {
                if (productShelf.isSoldOut()) {
                    productShelf.setProduct(product);
                    productShelf.setSoldOut(false);
                } else {
                    throw new Exception("already product is present, you can not add product here");
                }
            }
        }
    }

    public ProductShelf getProduct(int codeNumber) throws ProductSoldOutException, InvalidProductCodeException {
        for (ProductShelf productShelf : inventory) {
            if (productShelf.getCode() == codeNumber) {
                if (productShelf.isSoldOut()) {
                    throw new ProductSoldOutException("product already sold out");
                } else {
                    return productShelf;
                }
            }
        }
        throw new InvalidProductCodeException("Invalid Code");
    }

    public void updateSoldOutProduct(int codeNumber){
        for (ProductShelf productShelf : inventory) {
            if (productShelf.getCode() == codeNumber) {
                productShelf.setSoldOut(true);
            }
        }
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventory=" + Arrays.toString(inventory) +
                '}';
    }
}
