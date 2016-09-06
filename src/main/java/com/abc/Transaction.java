package com.abc;

import java.util.Calendar;
import java.util.Date;

public class Transaction {
    private final double amount;

    private Date transactionDate;
    
    private String transactionType;

    public Transaction(double amount, String transactionType) {
        this.amount = amount;
        this.transactionDate = DateProvider.getInstance().now();
        this.transactionType=transactionType;
    }
    
    public double getAmount(){
        return amount;
    }
    
    public void setAmount(double amount){
        this.amount=amount;
    }
    
    public Date getTransactionDate(){
        return transactionDate;
    }
    
    public void setTransactionDate(Date transactionDate){
        this.transactionDate=transactionDate;
    }
    
    public String getTransactionType(){
        return transactionType;
    }
    
    public void setTransactionType(String transactionType){
        this.transactionType=transactionType;
    }

}
