import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Font;
import java.awt.event.*;
import java.awt.FlowLayout;


public class PictureForm {
    private JPanel mainPanel;
    private JTextField colorField;
    private JSpinner sideCountSpinner;
    private JSpinner sideLenSpinner;
    private CanvasPanel canvasPanel1;
    //private JButton enterButton;

    public PictureForm(){
        sideCountSpinner.setValue(3);
        //colorField = new JTextField("Red");
        sideLenSpinner.setValue(1);
        colorField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String color = colorField.getText();
                canvasPanel1.setColor(color);
                //System.out.println(s);
            }
        });

        sideCountSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int k = (int)sideCountSpinner.getValue();
                canvasPanel1.setSideNumber(k);
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
