package com.basaki.ca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Person {
    private static final Person[] EMPTY_PEOPLE_ARRAY = new Person[0];
    //private static CopyOnWriteArrayList<Person> people = new CopyOnWriteArrayList<Person>();
    protected static Vector<Person> people = new Vector<Person>();
    //private String fName = "";
    //private String fAddress = "";
    private final String fName;
    private final String fAddress;

    public Person(String name, String address) {
        if (name == null || name.length() == 0)
            throw new IllegalArgumentException("Person needs a non-null and non-blank name");

        if (address == null || address.length() == 0)
            throw new IllegalArgumentException(
                    "Person needs a non-null and non-blank address");

        fName = name;
        fAddress = address;

        people.add(this);

        initialize();
    }

    // should not return a reference to an actual collection
    // Either return an array, if empty return an empty array and not null
    // or another collection, if empty return an empty collection and not null
    // Also return an interface instead of a returning an implementing class
    public static Vector getPeople() {
        return people;
    }

    public static List<Person> getPeople2() {
        if (people.isEmpty()) {
            return Collections.emptyList();
        } else {
            return new ArrayList<Person>(people);
        }
    }

    public static Person[] getPeople1() {

        return people.toArray(EMPTY_PEOPLE_ARRAY);
    }

    protected void initialize() {
        // ...;
    }

    public void store() {
        try {
            String data = stringify();

            // ...;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String stringify() {
        String result = "";
        result += fName;

        // String[] items = address.split ("\\s+", -2);
        // for (int i = 0; i< items.length; i++)
        // {
        // result += "|";
        // result += items[i];
        // }

        result += "|";
        result += fAddress;

        return result;
    }

    private void xmethod() {

    }

}
