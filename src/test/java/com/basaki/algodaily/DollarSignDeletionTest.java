package com.basaki.algodaily;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.basaki.algodaily.DollarSignDeletion.isDollarDeleteEqual;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DollarSignDeletionTest {

    @ParameterizedTest
    @CsvSource({
            //"ab$$, c$d$, true",
            "f$st, st, true",
            "a90$n$c$se, a90n$cse, false",
            "f$ec, ec, true",
            //"b$$p, $b$p, true"
    })
    void testDeletion(String str, String expected, boolean result) {
        if (result) {
            assertTrue(isDollarDeleteEqual(new String[]{str, expected}));
        } else {
            assertFalse(isDollarDeleteEqual(new String[]{str, expected}));
        }
    }
}
