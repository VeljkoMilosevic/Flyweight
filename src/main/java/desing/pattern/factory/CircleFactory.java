package desing.pattern.factory;

import desing.pattern.shapes.Circle;
import desing.pattern.shapes.Color;

import java.util.HashMap;
import java.util.Map;

public class CircleFactory {

    Map<Color, Circle> coloredCircles;

    public CircleFactory() {
        coloredCircles = new HashMap();
    }

    public Circle getCircle(final int radius, final Color color) {
        if (coloredCircles.containsKey(color)) {
            return coloredCircles.get(color);
        }
        final Circle circle = new Circle(color, radius);
        coloredCircles.put(color, circle);
        return circle;
    }
}
