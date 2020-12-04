package app.com.huelightsalarm.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class ColorCalculatorTest {

    @Test
    public void map1() {
        int initialLowerBounds = 5;
        int initialUpperBounds = 15;

        int lowerBounds = 0;
        int upperBounds = 10;

        int value = 10;
        float expectedOutcome = 5;

        float outcome = ColorCalculator.map(initialLowerBounds,initialUpperBounds,lowerBounds,upperBounds,value);

        assert (outcome == expectedOutcome);
    }

    @Test
    public void map2() {
        float initialLowerBounds = 0;
        float initialUpperBounds = 500;

        float lowerBounds = 0;
        float upperBounds = 10;

        float value = 100;
        int expectedOutcome = 2;

        float outcome = ColorCalculator.map(initialLowerBounds,initialUpperBounds,lowerBounds,upperBounds,value);

        assert (outcome == expectedOutcome);
    }
}