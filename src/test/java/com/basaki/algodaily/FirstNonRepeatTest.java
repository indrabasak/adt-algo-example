package com.basaki.algodaily;

import org.junit.jupiter.api.Test;

import static com.basaki.algodaily.FirstNonRepeat.firstNonRepeat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstNonRepeatTest {

    @Test
    void testFirstNonRepeat() {
        assertEquals('j', firstNonRepeat("asdfsdafdasfjdfsafnnunl"));
    }
}
