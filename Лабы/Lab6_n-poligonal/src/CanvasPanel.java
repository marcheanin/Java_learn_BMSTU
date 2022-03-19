import javax.swing.*;
import java.awt.*;

public class CanvasPanel extends JPanel {
    private int sideLen = 1;
    private int sideNumber = 3;
    private int radius = 30;
    private int x[] = new int[200];
    private int y[] = new int[200];
    private int centerX = 50;
    private int centerY = 50;
    private String color = "White";

    public void setSideCount(int n){
        sideNumber = n;
        repaint();
    }

    public void setSideLen(int value){
        sideLen = value;
        radius = (int) (sideLen / (2 * Math.sin(360 / sideNumber / 2)));
        repaint();
    }

    public void setSideNumber(int value){
        sideNumber = value;
        repaint();
    }

    public void setColor(String color){
        this.color = color;
        repaint();
    }

    private void changeColor(Graphics g){
        switch (color){
            case ("Red"):
                g.setColor(Color.RED);
                break;
            case ("Yellow"):
                g.setColor(Color.yellow);
                break;
            default:
                g.setColor(Color.white);
                break;
        }
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        changeColor(g);

        double a, b; int n = sideNumber;
        double angle = 360.0 / n;
        double startAngle = 270;
        for (int i = 0; i < n; i++){
            a = startAngle + angle * i;
            b = a * Math.PI / 180;
            x[i] = (int)(centerX + radius * Math.cos(b));
            y[i] = (int)(centerY + radius * Math.sin(b));
        }
        //g.drawOval(centerX, centerY, radius, radius);
        g.drawPolygon(x, y, sideNumber);
    }
}
