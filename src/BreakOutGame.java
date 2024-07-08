import javax.swing.JFrame;

public class BreakOutGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Breakout Ball Game");
        GamePanel gamePanel = new GamePanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(gamePanel);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
