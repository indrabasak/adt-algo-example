package com.basaki.ca;

@SuppressWarnings({"squid:S1068"})
public class Customer extends Person {

    private AccountType fAccountType = AccountType.BASIC;

    public Customer(String name, String address) {
        super(name, address);
    }

    public enum AccountType {BASIC, PLUS, EXEC}

}
