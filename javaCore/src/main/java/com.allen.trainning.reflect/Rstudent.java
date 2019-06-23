package com.allen.trainning.reflect;

import java.math.BigDecimal;

public class Rstudent {
    public String name = "Bill";
    public BigDecimal money = new BigDecimal("10000000");
    private String accountNumber = "999908998600";

    public Rstudent() {
    }

    public Rstudent(String name) {
        this.name = name;
    }

    private Rstudent(BigDecimal money) {
        this.money = money;
    }

    public String toString() {
        return name + " " + money + " " + accountNumber;
    }

    public void printName() {
        System.out.println("name is" + name);
    }

    private void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        System.out.println("accountNumber is" + accountNumber);
    }

    private void printAccountNumber() {
        System.out.println("accountNumber is" + accountNumber);
    }

}
