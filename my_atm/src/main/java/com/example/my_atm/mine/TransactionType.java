package com.example.my_atm.mine;

import java.util.ArrayList;
import java.util.List;

public enum TransactionType {
    CASH_WITHDRAWAL,
    BALANCE_CHECK;

    public static String getAllTransactionTypes(){
        List<String> operationList = new ArrayList<>();
        for(TransactionType type: TransactionType.values()){
            operationList.add(type.name());
        }
        return operationList.toString();
    }

    public static TransactionType getTransactionTypeFromString(String type) {
        if(type.toUpperCase().equals(TransactionType.CASH_WITHDRAWAL.name())) {
            return TransactionType.CASH_WITHDRAWAL;
        } else if(type.toUpperCase().equals(TransactionType.BALANCE_CHECK.name())) {
            return TransactionType.BALANCE_CHECK;
        } else {
            return null;
        }
    }

}
