import java.util.Scanner;

class OthelloGame {

    private char[][] board;
    private char currentPlayer;

    public OthelloGame() {
        board = new char[8][8];
        currentPlayer = '⚫';
    }
    

    public void initializeBoard() {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                board[r][c] = '.';
            }
        }
        board[3][3] = '⚪';
        board[3][4] = '⚫';
        board[4][3] = '⚫';
        board[4][4] = '⚪';
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        while (hasValidMove('⚫') || hasValidMove('⚪')) {
            showBoard();

            if (!hasValidMove(currentPlayer)) {
                System.out.println("No valid moves for " + currentPlayer + ". Turn skipped");
                switchPlayer();
            }

            System.out.println("Current Player: " + currentPlayer);
            System.out.println("Enter row (1-8): ");
            int row = scanner.nextInt();
            System.out.println("Enter column (1-8): ");
            int col = scanner.nextInt();

            if (isValidMove(row, col)) {
                makeMove(row, col);
                switchPlayer();
            } else {
                System.out.println("Invalid move please try again");
            }
        }

        endGame();
    }

    public boolean isValidMove(int row, int col) {
        

    }

    public void makeMove(int row, int col) {

    }

    public boolean hasValidMove(char player) {
    
    }

    public void switchPlayer() {
        
    }

    public void showBoard() {
        
    }

    public void endGame() {
        
    }

    public static void main(String[] args) {
        
    }
}
