package com.basaki.splunk;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomTargetIndexTest {

    @Test
    void testRandomTarget() {
        RandomTargetIndex sol = new RandomTargetIndex();
        sol.start(3);
        sol.process(4);
        sol.process(3);
        sol.process(3);
        sol.process(5);
        sol.process(4);
        sol.process(3);
        System.out.println(sol.end());

        List<Integer> indexes = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(5);
            }
        };
        assertTrue(indexes.contains(sol.end()));
    }
}
