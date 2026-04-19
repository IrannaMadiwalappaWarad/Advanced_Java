//4c. Develop a Swing program in Java to display a message “Digital Clock is pressed” or “Hour Glass
//is pressed” depending upon the Jbutton with image either Digital Clock or Hour Glass is pressed by
//implementing the event handling mechanism with addActionListener( ).
package Swings;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ImageButtonExample {

    JLabel label;

    ImageButtonExample() {

        JFrame f = new JFrame("Image Button Example");

        label = new JLabel();
        label.setBounds(50, 50, 500, 50);
        label.setFont(new Font("Arial", Font.BOLD, 20));

        // 👉 Add your own image paths here
        ImageIcon clockIcon = new ImageIcon("clock.png");
        ImageIcon hourglassIcon = new ImageIcon("hourglass.png");
//"Digital Clock",
        //"Hour Glass", 
        JButton b1 = new JButton(clockIcon);
        JButton b2 = new JButton(hourglassIcon);

        b1.setBounds(50, 150, 200, 100);
        b2.setBounds(300, 150, 200, 100);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Digital Clock is pressed");
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Hour Glass is pressed");
            }
        });

        f.add(b1);
        f.add(b2);
        f.add(label);

        f.setSize(600, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ImageButtonExample();
    }
}
