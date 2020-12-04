package app.com.huelightsalarm.utils;

public class ColorCalculator {

    public static int map(float initialLowerBounds, float initialUpperBounds, float lowerBounds, float upperBounds, float value) {
        float initialRange = initialUpperBounds-initialLowerBounds;
        float range = upperBounds-lowerBounds;

        float percentage = (value-initialLowerBounds)/initialRange;

        return (int)(percentage*range+lowerBounds);
    }

    public static float map(int initialLowerBounds, int initialUpperBounds, int lowerBounds, int upperBounds, int value) {
        float initialRange = initialUpperBounds-initialLowerBounds;
        float range = upperBounds-lowerBounds;

        float percentage = (value-initialLowerBounds)/initialRange;

        return percentage*range+lowerBounds;
    }
}
