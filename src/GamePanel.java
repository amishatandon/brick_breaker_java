import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener {
    private Timer timer;
    private Paddle paddle;
    private Ball ball;
    private MapGenerator mapGenerator;
    private boolean inGame = false;
    private int score = 0;

    public GamePanel() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new KeyHandler());
        initGame();
    }

    private void initGame() {
        paddle = new Paddle();
        ball = new Ball();
        mapGenerator = new MapGenerator();
        timer = new Timer(10, this);
        score = 0;
        inGame = true;
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            paddle.move();
            ball.move();
            checkCollision();
        }
        repaint();
    }

    private void checkCollision() {
        // Check collision with paddle
        if (ball.getRect().intersects(paddle.getRect())) {
            ball.setDy(-ball.getDy());
        }

        // Check collision with bricks
        ArrayList<Brick> bricks = mapGenerator.getBricks();
        for (Brick brick : bricks) {
            if (!brick.isDestroyed() && ball.getRect().intersects(brick.getRect())) {
                brick.setDestroyed(true);
                ball.setDy(-ball.getDy());
                score += 5;
            }
        }

        // Check if ball falls off the paddle
        if (ball.getY() > 600) {
            inGame = false; // Set game state to end
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw game objects
        paddle.draw(g2d);
        ball.draw(g2d);
        mapGenerator.draw(g2d);

        // Draw score
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Serif", Font.BOLD, 14));
        g2d.drawString("Score: " + score, 5, 15);

        // Game over screen
        if (!inGame) {
            showGameOver(g2d);
        }
    }

    private void showGameOver(Graphics2D g2d) {
        String msg = "Game Over. Your Score: " + score;
        String restartMsg = "Press Enter to Restart";
        Font font = new Font("Serif", Font.BOLD, 18);
        FontMetrics fm = getFontMetrics(font);
        g2d.setColor(Color.WHITE);
        g2d.setFont(font);
        g2d.drawString(msg, (800 - fm.stringWidth(msg)) / 2, 300);
        g2d.drawString(restartMsg, (800 - fm.stringWidth(restartMsg)) / 2, 330);
    }

    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_ENTER && !inGame) {
                initGame(); // Restart the game
            }
            paddle.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            paddle.keyReleased(e);
        }
    }
}
