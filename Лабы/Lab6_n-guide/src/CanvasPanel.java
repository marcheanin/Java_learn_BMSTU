import javax.swing.*;
import java.awt.*;

public class CanvasPanel extends JPanel {
    private int radius = 20;
    public void setRadius(int r){
        radius = r;
        System.out.println(radius);
        repaint();
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawOval(50, 50, radius, radius + 5);
        g.drawLine(10, 10, 10, 30);
    }
}
