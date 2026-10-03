public class Circle extends Shape {
    private final int radius = 2;

    public Circle(String id, Renderer renderer) {
        super(id, renderer);
    }
    public int getRadius() {
    return radius;
    }

    @Override
    public String execute() {
        return renderer.renderShape("Circle", radius);
    }
}
