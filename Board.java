public class Board {

    private Disk[][] board;

    public Board() {
        board = new Disk[8][8];
        initializeBoard();
    }

    public void initializeBoard() {//creates the board
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

    public void printBoard() { // Jan 10 2025 by omar
    System.out.println("  1 2 3 4 5 6 7 8");
    String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H"};
    
    for (int r = 0; r < 8; r++) {
        System.out.print(letters[r] + " ");
        for (int c = 0; c < 8; c++) {
            System.out.print(board[r][c].getColor() + " ");
        }
        System.out.println();
    }
}


    public boolean isInsideBoard(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }

    public boolean isEmptyPosition(int row, int col) {//if the board coord is empty 
        return isInsideBoard(row, col) && board[row][col].isEmpty();
    }
    
    public int countDisks(String color) {// counts the amount of disks
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
        String.valueOf(row).replace(String.valueOf(row), letters[row]);
            
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

public void flipDisksInDirection(int row, int col, int dRow, int dCol, String color) { // jan 10
    int r = row + dRow; //starts checking next position
    int c = col + dCol;
    
    while (isInsideBoard(r, c)) {
        if (board[r][c].isEmpty()) {
            System.out.println("disk not found to flip");
        }
        if (board[r][c].getColor().equals(color)) { // disks between the start and here should be flipped
         
       



    
}
