import java.awt.*;
import java.util.ArrayList;

public class MapGenerator {
    private ArrayList<Brick> bricks;

    public MapGenerator() {
        initMap();
    }

    private void initMap() {
        bricks = new ArrayList<>();
        // Logic to generate bricks, for example:
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 10; col++) {
                bricks.add(new Brick(col * 75 + 50, row * 30 + 50));
            }
        }
    }

    public ArrayList<Brick> getBricks() {
        return bricks;
    }

    public void draw(Graphics2D g2d) {
        for (Brick brick : bricks) {
            if (!brick.isDestroyed()) {
                brick.draw(g2d);
            }
        }
    }
}
