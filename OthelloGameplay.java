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

