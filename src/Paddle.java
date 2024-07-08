import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle {
    private int x, y;
    private int dx;
    private final int width = 100;
    private final int height = 10;

    public Paddle() {
        x = 350;
        y = 550;
        dx = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, width, height);
    }

    public void move() {
        x += dx;
        if (x <= 0) {
            x = 0;
        }
        if (x >= 700) {
            x = 700;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            dx = -3;
        }
        if (key == KeyEvent.VK_RIGHT) {
            dx = 3;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.fillRect(x, y, width, height);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(x, y, width, height);
    }
}
