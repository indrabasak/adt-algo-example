package com.basaki.ca;

public class Customer extends Person {

    private AccountType fAccountType = AccountType.Basic;

    ;
    public Customer(String name, String address) {
        super(name, address);
        // TODO Auto-generated constructor stub
    }

    private void xmethod() {

    }

    public enum AccountType {Basic, Plus, Excec}

}
