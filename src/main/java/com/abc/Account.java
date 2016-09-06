package com.abc;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Account {

    public static final int CHECKING = 0;
    public static final int SAVINGS = 1;
    public static final int MAXI_SAVINGS = 2;

    private final int accountType;
    public List<Transaction> transactions;

    public Account(int accountType) {
        this.accountType = accountType;
        this.transactions = new ArrayList<Transaction>();
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
            transactions.add(new Transaction(amount));
        }
    }

public void withdraw(double amount) {
    if (amount <= 0) {
        throw new IllegalArgumentException("amount must be greater than zero");
    } else 
    {
        transactions.add(new Transaction(-amount));
    }
}

    public double interestEarned() {
        double amount = sumTransactions();
        switch(accountType){
            case SAVINGS:
                if (amount <= 1000)
                    return amount * 0.001;
                else
                    return 1 + (amount-1000) * 0.002;
//            case SUPER_SAVINGS:
//                if (amount <= 4000)
//                    return 20;
            case MAXI_SAVINGS:
               if(isMoneyWithdrawnPastTenDays())
                    return amount * 0.001;
                else
                    return amount * 0.005;
            default:
                return amount * 0.001;
        }
    }

    // This method checks if there are any transactions for the past 10 days.
    // Returns true if there are any, else returns false
    
    public boolean isMoneyWithdrawnPastTenDays(){
        
        Date date = new Date();
        for(Transaction trans : transactions){
            if(getDaysBetween(trans.getTransactionDate(), date)<10 && trans.getTransactionType().equalsIgnoreCase("WITHDRAW"){
                return true;
            }
        }
        return false;
    }
    
    // This method gets the number of days between transactions and current date
    
    public int getDaysBetween(Date transDate, Date currDate){
        return daysBetween = (currDate.getTime()- transDate.getTime())/(1000 * 60 * 60 * 24);
    }
    
    public double sumTransactions() {
       return checkIfTransactionsExist(true);
    }

    private double checkIfTransactionsExist(boolean checkAll) {
        double amount = 0.0;
        for (Transaction t: transactions)
            amount += t.amount;
        return amount;
    }

    public int getAccountType() {
        return accountType;
    }

}
