package app.com.huelightsalarm.utils;

public class ColorCalculator {
    public static int map(float initialLowerBounds, float initialUpperBounds, float lowerBounds, float upperBounds, float value) {
        return (int)(((upperBounds-lowerBounds)/(initialUpperBounds - initialLowerBounds)) * value);
    }
}
