import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class OthelloGame extends JFrame {

    JPanel main;
    JLabel statusLabel;
    Board board;
    Player blackPlayer;
    Player whitePlayer;
    Player currentPlayer;

    public static void main(String[] args){
        JButton button = new JButton("Player vs Player");

        JButton anotherButton = new JButton("Player vs Computer");
    }


        public OthelloGame() {
        super("Othello");
        setUpGame();
        setUpPanels();
        setUpBoardButtons();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}

