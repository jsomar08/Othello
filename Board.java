public class Board {

    private Disk[][] board;

    public Board() {
        board = new Disk[8][8];
        initializeBoard();
    }

    public void initializeBoard() {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                board[r][c] = new Disk(".");
            }
        }

        board[3][3] = new Disk("•");
        board[3][4] = new Disk("○");
        board[4][3] = new Disk("○");
        board[4][4] = new Disk("•");
    }

    public void printBoard() {
        System.out.print("  ");
        for (int c = 1; c <= 8; c++) {
            System.out.print(c + " ");
        }
        System.out.println();

        String[] rowLabels = {"A","B","C","D","E","F","G","H"};

        for (int r = 0; r < 8; r++) {
        System.out.print(rowLabels[r] + " ");
        for (int c = 0; c < 8; c++) {
        System.out.print(board[r][c].getColor() + " ");
        }
        System.out.println();
}

    }

    public boolean isInsideBoard(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }

    public boolean isEmptyPosition(int row, int col) {
        return isInsideBoard(row, col) && board[row][col].isEmpty();
    }

    public int countDisks(String color) {
        int count = 0;
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if (board[r][c].getColor().equals(color)) {
                    count++;
                }
            }
        }
        return count;
    }

    public int [] rowNumberToLetter(int row, int col){// try to interpret A5 as row 1 column 5
        String[] letters = {"A","B","C","D","E","F","G","H"};
        
        for (int i = 0; i<letters.length;i++){
            String.valueOf(row).replace("1", letters[i]);
            
            i++;
             
        }
        return new int [] {row, col};
        
        
    
    }

    public Disk getDisk(int row, int col) {// gets the disk
        if (!isInsideBoard(row, col)){
            return null;
        }
        return board[row][col];
    }

    public void placeDisk(int row, int col, String color) {//makes disk over position
        board[row][col] = new Disk(color);
    }

    public static void main(String[] args) {
        Board b = new Board();
        b.printBoard();
    }
}
