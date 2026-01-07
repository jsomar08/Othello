public class Board {

    private Disk[][] board;

    public Board() {
        board = new Disk[8][8];
        initializeBoard();
    }
    public void initializeBoard() {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                board[r][c] = new Disk('.');
            }
        }
    
        board[3][3] = new Disk('•');
        board[3][4] = new Disk('○');
        board[4][3] = new Disk('○');
        board[4][4] = new Disk('•');
    }

    public void printBoard() {
        for (int c = 1; c <= 8; c++) {
            System.out.print(c + " ");
        }
        System.out.println();

       
    }

    public boolean isInsideBoard(){ 

    }


    public boolean isEmptyPosition() {

    }

    public int countDisks(char color) {
        int count = 0;
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if (board[r][c].getColour() == color) {
                    count++;
                }
            }
        }
        return count;
    }



    public static void main(String[] args) {
       
    }

}    
