package LESSONS;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUIIntro {
    //JFrame
    //JPanel
    //JLabel
    //JButton

    static void buttonAction(JLabel label){
        int clicks = Integer.valueOf(label.getText());
        clicks ++;
        label.setText(String.valueOf(clicks));
    }

    public static void main (String [] args){
        JFrame window = new JFrame ("GUI");
        JPanel panel = new JPanel(); // holf and organizes your widgits
        // you can only have one JFrame
        // but you can have multiple JPanel

        JLabel label = new JLabel("0");
        panel.add(label);

        JButton button = new JButton ("Click me");
        button.addActionListener(e -> buttonAction(label));
        panel.add(button);

        window.add(panel);
        window.pack(); // size the window to fit the componenets
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // what happens when you click the x
    }
}