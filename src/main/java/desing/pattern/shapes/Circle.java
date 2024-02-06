package desing.pattern.shapes;

public class Circle implements Shape {
    private static final int IMAGE_SIZE = 5000;

    private final Color color;
    private final int radius;
    private final byte encodedImage[];

    public Circle(final Color color, final int radius) {
        this.color = color;
        this.radius = radius;
        this.encodedImage = new byte[IMAGE_SIZE];
    }

    @Override
    public void draw() {
        System.out.println(String.format("I am drawing Circle with " +
                "%s color and %s radius!", color, radius));
    }
}
