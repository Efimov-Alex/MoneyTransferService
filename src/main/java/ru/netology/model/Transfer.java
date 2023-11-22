package ru.netology.model;

import java.util.Objects;

public class Transfer {
    private Amount amount;
    private String cardFromCVV;
    private String cardFromNumber;
    private String cardFromValidTill;
    private String cardToNumber;
    private String date;
    private String time;
    public String getDate(){
        return date;
    }


    public Transfer(Amount amount, String cardFromCVV, String cardFromNumber, String cardFromValidTill, String cardToNumber){
        this.amount = amount;
        this.cardFromCVV = cardFromCVV;
        this.cardFromNumber = cardFromNumber;
        this.cardFromValidTill = cardFromValidTill;
        this.cardToNumber = cardToNumber;
    }
    public Amount getAmount(){
        return amount;
    }
    public void setAmount(Amount amount){
        this.amount = amount;
    }
    public String getCardFromCVV(){
        return cardFromCVV;
    }
    public void setCardFromCVV(String cardFromCVV){
        this.cardFromCVV = cardFromCVV;
    }
    public String getCardFromNumber(){
        return cardFromNumber;
    }
    public void setCardFromNumber(String cardFromNumber){
        this.cardFromNumber = cardFromNumber;
    }
    public String getCardFromValidTill(){
        return cardFromValidTill;
    }
    public void setCardFromValidTill(String cardFromValidTill){
        this.cardFromValidTill = cardFromValidTill;
    }
    public String getCardToNumber(){
        return cardToNumber;
    }
    public void setCardToNumber(String cardToNumber){
        this.cardToNumber = cardToNumber;
    }

    public void setDate(String date){
        this.date = date;
    }
    public String getTime(){
        return time;
    }
    public void setTime(String time){
        this.time = time;
    }
    public Transfer(){
    }
    @Override
    public String toString(){
        return "Transfer  " + " amount: " + amount.toString() +
                " cardFromNumber: " + cardFromNumber  +
                " cardToNumber: " + cardToNumber;
    }


}
