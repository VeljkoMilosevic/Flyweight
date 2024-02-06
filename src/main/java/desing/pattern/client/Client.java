package desing.pattern.client;

import desing.pattern.factory.CircleFactory;
import desing.pattern.shapes.Circle;
import desing.pattern.shapes.Color;

import java.util.LinkedList;
import java.util.List;

public class Client {

    private static final int ONE_HUNDRED_THOUSAND = 100_000;
    private final Color[] colors;
    private final CircleFactory circleFactory;


    public Client() {
        colors = Color.values();
        circleFactory = new CircleFactory();
    }

    public List<Circle> createNewCircles() {
        clearHeapMemory();
        System.out.println("Calculating taken heap memory before " +
                "invoking new circle creation without flyweight " +
                "factory...");
        final List<Circle> circles = new LinkedList<>();
        calculateTakenMemory();
        for (int i = 0; i < ONE_HUNDRED_THOUSAND; i++) {
            final Color randomColor = getRandomColor();
            final Circle circle = new Circle(randomColor, 100);
            circles.add(circle);
        }
        System.out.println("Calculating taken heap memory after " +
                "invoking new circle creation without flyweight " +
                "factory...");
        calculateTakenMemory();
        return circles;
    }

    public List<Circle> createNewCirclesFlyweight() {
        clearHeapMemory();
        System.out.println("Calculating taken heap memory before " +
                "invoking new circle creation with flyweight " +
                "factory...");
        calculateTakenMemory();
        final List<Circle> circles = new LinkedList<>();
        for (int i = 0; i < ONE_HUNDRED_THOUSAND; i++) {
            final Color randomColor = getRandomColor();
            final Circle circle = circleFactory.getCircle(100, randomColor);
            circles.add(circle);
        }
        System.out.println("Calculating taken heap memory after " +
                "invoking new circle creation with flyweight " +
                "factory...");
        calculateTakenMemory();
        clearHeapMemory();
        return circles;
    }

    void calculateTakenMemory() {
        // calculating from bytes to megabytes
        final long total = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        final long free = Runtime.getRuntime().freeMemory() / 1024 / 1024;
        System.out.println(String.format("Taken memory: %s " +
                        "Megabytes!",
                (total - free)));
    }


    Color getRandomColor() {
        return colors[(int) (Math.random() * Color.values().length)];
    }

    void clearHeapMemory() {
        System.out.println("Clearing heap memory...");
        System.gc();
        System.out.println("Heap memory cleared.");
    }
}
