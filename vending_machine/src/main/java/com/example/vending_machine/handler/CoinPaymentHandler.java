package com.example.vending_machine.handler;

import com.example.vending_machine.exception.PaymentFailedException;
import com.example.vending_machine.enums.Coin;
import com.example.vending_machine.vendingmachine.VendingMachine;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoinPaymentHandler implements PaymentHandler {

    @Override
    public void makePayment(VendingMachine machine) {
        List<Coin> coinList = getPayment();
        if(coinList.isEmpty()) {
            throw new PaymentFailedException("Payment is not successful");
        }
        machine.setCoinList(coinList);
    }

    @Override
    public boolean refundPayment(int refundAmount) {
        return false;
    }

    private List<Coin> getPayment() {
        Scanner scanner = new Scanner(System.in);
        String input;
        List<Coin> coinList = new ArrayList<>();
        System.out.println("Press OK after coin insertion");
        while(true) {
            try{
                input = scanner.nextLine();
                if("OK".equals(input)) {
                    break;
                }
                int coinValue = Integer.parseInt(input);
                Coin coin = Coin.fromValue(coinValue);
                coinList.add(coin);
            }catch (Exception e) {
                System.out.println("Insert valid amount");
            }
        }
        return coinList;
    }
}
