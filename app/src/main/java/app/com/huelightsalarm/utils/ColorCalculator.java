package app.com.huelightsalarm.utils;

public class ColorCalculator {
    public static int map(float initialLowerBounds, float initialUpperBounds, float lowerBounds, float upperBounds, float value) {
        return (int)(((upperBounds-lowerBounds)/(initialUpperBounds - initialLowerBounds)) * value);
    }
    public static float map(int initialLowerBounds, int initialUpperBounds, int lowerBounds, int upperBounds, int value) {
        return ((float) (upperBounds-lowerBounds)/ (float) (initialUpperBounds - initialLowerBounds)) * (float) value;
    }
}
