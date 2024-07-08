import java.awt.*;

public class Ball {
    private int x, y; // Position of the ball
    private int dx, dy; // Speed of movement
    private final int diameter = 30; // Diameter of the ball

    public Ball() {
        x = 390; // Initial x-coordinate
        y = 550; // Initial y-coordinate
        dx = 1; // Initial horizontal speed
        dy = -2; // Initial vertical speed
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDiameter() {
        return diameter;
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, diameter, diameter);
    }

    public void move() {
        x += dx;
        y += dy;

        // Bounce off walls (left and right)
        if (x <= 0 || x + diameter >= 800) {
            dx = -dx;
        }

        // Bounce off top
        if (y <= 0) {
            dy = -dy;
        }

        // Check if ball falls off bottom
        if (y + diameter >= 600) {
            // Reset ball position and speed
            x = 390; // Initial x-coordinate
            y = 550; // Initial y-coordinate
            dx = 1; // Initial horizontal speed
            dy = -2; // Initial vertical speed
        }
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.fillOval(x, y, diameter, diameter);
    }
}
