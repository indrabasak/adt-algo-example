package com.basaki.algodaily;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class HashmapTest {

    @Test
    public void getMissingTest() {
        Hashmap dict = new Hashmap();
        dict.set("jess", "213-559-6840");
        dict.set("james", "123-456-7890");
        assertNull(dict.get("jake"));
    }

    @Test
    public void getContainedTest() {
        Hashmap dict = new Hashmap();
        dict.set("james", "123-456-7890");
        dict.set("jess", "213-559-6840");
        assertEquals(dict.get("james"), "123-456-7890");
    }

}
