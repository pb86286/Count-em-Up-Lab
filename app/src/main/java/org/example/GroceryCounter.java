package org.example;

public class GroceryCounter {
    private int value; // ranges from 0000 to 9999
    private int overflowCount;

    public GroceryCounter() {
        value = 0;
        overflowCount = 0;
    }

    private void increment(int amount) {
        value += amount;
        if (value > 9999) {
            value %= 10000;
            overflowCount++;
        }
    }

    public void tens() {
        increment(1000);
    }

    public void ones() {
        increment(100);
    }

    public void tenths() {
        increment(10);
    }

    public void hundreths() {
        increment(1);
    }

    public String total() {
        int dollars = value / 100;
        int cents = value % 100;
        return String.format("$%d.%02d", dollars, cents);
    }

    public int overflows() {
        return overflowCount;
    }

    public void clear() {
        value = 0;
        overflowCount = 0;
    }
}