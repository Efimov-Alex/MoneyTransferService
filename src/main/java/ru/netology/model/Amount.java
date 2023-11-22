package ru.netology.model;

public class Amount {
    private String currency;
    private Float value;

    public Amount(){
    }

    public Amount(String currency, Float value) {
        this.currency = currency;
        this.value = (float) value ;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return "value: " + value + " currency:  " + currency;
    }
}
