//4a. Basic hello program of Swing displaying the message Hello! VI C , Welcome to Swing Programming
//in Blue color plain font with font size of 32 using Jframe and Jlabel
package Swings;

import java.awt.*;
import javax.swing.*;

public class SwingExample {

    SwingExample() {

        JFrame jfrm = new JFrame("Swing App");

        jfrm.setSize(400, 200);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel jlab = new JLabel("Hello! VI C, Welcome to Swing Programming!");

        jlab.setFont(new Font("Verdana", Font.PLAIN, 18));
        jlab.setForeground(Color.BLUE);

        jfrm.add(jlab);
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SwingExample());
    }
}
