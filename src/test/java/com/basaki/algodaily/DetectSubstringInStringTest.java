package com.basaki.algodaily;

import org.junit.jupiter.api.Test;

import static com.basaki.algodaily.DetectSubstringInString.detectSubstring;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DetectSubstringInStringTest {

    @Test
    void firstTest() {
        assertEquals(detectSubstring("thepigflewwow", "flew"), 6);
    }

    @Test
    void secondTest() {
        assertEquals(detectSubstring("twocanplay", "two"), 0);
    }

    @Test
    void thirdTest() {
        assertEquals(detectSubstring("wherearemyshorts", "pork"), -1);
    }
}
