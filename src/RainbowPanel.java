import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RainbowPanel extends JPanel {
    private float hue = 0f;
    private Timer timer;

    public RainbowPanel() {
        setPreferredSize(new Dimension(1000, 800));
        
        // Create and start the animation timer
        timer = new Timer(33, e -> updateHue()); // 30 FPS
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.getHSBColor(hue % 1, 1f, 1f));
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    private void updateHue() {
        hue = (hue + 0.01f) % 1f; // Increment hue by 0.01 (about 6 degrees)
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Rainbow Animation");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            RainbowPanel panel = new RainbowPanel();
            frame.add(panel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}