package com.example.my_atm.mine.states;

import com.example.my_atm.mine.ATM;
import com.example.my_atm.mine.Card;
import com.example.my_atm.mine.TransactionType;
import com.example.my_atm.mine.helper.Keypad;

public class SelectOperationState extends ATMState{

    private final Keypad keypad;

    public SelectOperationState(ATM atm, Card card) {
        super();
        this.keypad = Keypad.getInstance();
        showOperations();
        selectOperation(atm, card);
    }

    @Override
    public void selectOperation(ATM atmObject, Card card){
        String userSelectedOption = keypad.getInput();
        TransactionType transactionType = TransactionType.getTransactionTypeFromString(userSelectedOption);

        switch (transactionType) {
            case CASH_WITHDRAWAL:
                atmObject.setCurrentATMState(new CashWithdrawalState(atmObject, card));
                break;
            case BALANCE_CHECK:
                atmObject.setCurrentATMState(new CheckBalanceState(atmObject, card));
                break;
            default: {
                this.screen.showMessage("Invalid option");
                exit(atmObject);
            }
        }
    }

    private void showOperations(){
        String str = "Please select the Operation\n";
        this.screen.showMessage(str+TransactionType.getAllTransactionTypes());
    }

}
