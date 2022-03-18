import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class PictureForm {
    private JPanel mainPanel;
    private JSpinner radiusSpinner;
    private JTextField textField1;
    private JLabel areaField;
    private CanvasPanel canvasPanel1;

    public PictureForm ( ) {
        radiusSpinner.setValue(20);
        radiusSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int radius = (int)radiusSpinner.getValue();
                double area = Math.PI*radius*radius;
                areaField.setText(String.format("%.2f", area));
                canvasPanel1.setRadius(radius);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PictureForm");
        frame.setContentPane(new PictureForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

