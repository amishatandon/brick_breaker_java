import java.awt.*;

public class Brick {
    private int x, y;
    private final int width = 70;
    private final int height = 20;
    private boolean destroyed;

    public Brick(int x, int y) {
        this.x = x;
        this.y = y;
        this.destroyed = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, width, height);
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.GREEN); // Example color
        g2d.fillRect(x, y, width, height);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(x, y, width, height);
    }
}
