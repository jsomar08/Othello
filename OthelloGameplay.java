import java.util.Scanner;

class OthelloGame {

    private char[][] board;
    private char currentPlayer;

    public OthelloGame() {
        board = new char[8][8];
        currentPlayer = 'B';
        initializeBoard();
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
        while (hasValidMove('B') || hasValidMove('W')) {
            showBoard();

            if (!hasValidMove(currentPlayer)) {
                System.out.println("No valid moves for " + currentPlayer + ". Turn skipped");
                switchPlayer();
                continue;
            }

            System.out.println("Current Player: " + currentPlayer);
            System.out.print("Enter row (0-7): ");
            int row = scanner.nextInt();
            System.out.print("Enter column (0-7): ");
            int col = scanner.nextInt();

            if (isValidMove(row, col)) {
                makeMove(row, col);
                switchPlayer();
            } else {
                System.out.println("Invalid move. Try again.");
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
