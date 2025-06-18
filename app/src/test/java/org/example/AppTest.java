package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void testInitialTotalAndOverflow() {
        GroceryCounter counter = new GroceryCounter();
        assertEquals("$0.00", counter.total());
        assertEquals(0, counter.overflows());
    }

    @Test
    void testIncrementingDigits() {
        GroceryCounter counter = new GroceryCounter();
        counter.tens(); // +1000
        counter.tens(); // +1000
        counter.hundreths(); // +1
        assertEquals("$20.01", counter.total());
        assertEquals(0, counter.overflows());
    }

    @Test
    void testOverflowBehavior() {
        GroceryCounter counter = new GroceryCounter();
        for (int i = 0; i < 10000; i++) {
            counter.hundreths();
        }
        assertEquals("$0.00", counter.total());
        assertEquals(1, counter.overflows());
    }

    @Test
    void testClear() {
        GroceryCounter counter = new GroceryCounter();
        counter.ones(); // +100
        counter.clear();
        assertEquals("$0.00", counter.total());
        assertEquals(0, counter.overflows());
    }
}