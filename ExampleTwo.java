package LESSONS;


import java.awt.*;
import javax.swing.*;

class GuiExample {

    static int x = 0;
    static int y = 0;

    static void horizontal(JLabel label, int value){
        x += value;
        label.setText(String.format("(%d,%d)", x, y));
    }

    static void vetical(JLabel label, int value){
        y += value;
        label.setText(String.format("(%d,%d)", x, y));
    }

    static void greet(JFrame window) {
        Jf
    }

    public static void main(String[] args) {

        JFrame gui = new JFrame("Gui Ex 2");

        JPanel main = new JPanel(new BorderLayout());
        JPanel top = new JPanel();

        JLabel label = new JLabel(String.format("(%d,%d)", x, y));
        top.add(label);

        JPanel bottem = new JPanel(new GridLayout(2,2));

        JButton[][] buttons = new JButton[2][2];
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                buttons[i][j] = new JButton();
                bottem.add(buttons[i][j]);
            }
        }

        buttons[0][0].setText("Up");
        buttons[0][1].setText("Down");
        buttons[1][0].setText("Right");
        buttons[1][1].setText("Left");

        buttons[0][0].addActionListener(e -> vetical(label, 1));
        buttons[0][1].addActionListener(e -> vetical(label, -1));
        buttons[1][0].addActionListener(e -> horizontal(label, 1));
        buttons[1][1].addActionListener(e -> horizontal(label, -1));

        main.add(top, BorderLayout.PAGE_START);
        main.add(bottem, BorderLayout.CENTER);

        gui.add(main);
        gui.pack();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}