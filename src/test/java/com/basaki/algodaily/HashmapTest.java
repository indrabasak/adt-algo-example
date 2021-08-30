package com.basaki.algodaily;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class HashmapTest {

    @Test
    void getMissingTest() {
        Hashmap dict = new Hashmap();
        dict.set("jess", "213-559-6840");
        dict.set("james", "123-456-7890");
        assertNull(dict.get("jake"));
    }

    @Test
    void getContainedTest() {
        Hashmap dict = new Hashmap();
        dict.set("james", "123-456-7890");
        dict.set("jess", "213-559-6840");
        assertEquals(dict.get("james"), "123-456-7890");
    }
}
