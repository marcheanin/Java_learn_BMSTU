import javax.swing.*;
import java.awt.*;

public class CanvasPanel extends JPanel {
    private int sideLen = 30;
    private int sideNumber = 3;
    private int radius = (int)Math.round(sideLen / (2 * Math.sin(Math.PI / (double)sideNumber)));
    private int x[] = new int[1000];
    private int y[] = new int[1000];
    private int centerX = 200;
    private int centerY = 200;
    private String color = "Black";

    public void setSideCount(int n){
        sideNumber = n;
        radius = Math.abs((int)Math.round(sideLen / (2 * Math.sin(Math.PI / (double)sideNumber))));
        System.out.println(sideNumber);
        repaint();
    }

    public void setSideLen(int value){
        sideLen = value;
        //System.out.println(sideLen);
        radius = Math.abs((int)Math.round(sideLen / (2 * Math.sin(Math.PI / (double)sideNumber))));
        System.out.println(radius);

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
            case ("White") :
                g.setColor(Color.white);
                break;
            case ("Green"):
                g.setColor(Color.green);
                break;
            default:
                g.setColor(Color.black);
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
