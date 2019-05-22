import java.awt.Graphics;

public class RectangleShapes extends Shape {
	public RectangleShapes(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public RectangleShapes() {
        super();
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect(getX(), getY(), getWidth(), getHeight());
    }
}
