public class Square extends Shape {
    private final int side = 3;

    public Square(String id, Renderer renderer) {
        super(id, renderer);
    }
    public int getSide() {
        return side;
    }

    @Override
    public String execute() {
        return renderer.renderShape("Square", side);
    }
}
