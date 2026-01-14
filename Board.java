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

    public void printBoard() {
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

    public boolean isEmptyPosition(int row, int col, Disk empty) {//if the board coord is empty 
        if(empty.getColor().equals(".") && isInsideBoard(row, col)){
            return true;
        }
        else{}
        return false;
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

    public boolean canFlipUp(int row, int col, Disk current){
        int count = 0;
        Disk d = getAtDiskLocation(row, col);
        
        for (int i = 0; i<=1 && i<8;i++){
            Disk c = getAtDiskLocation(row -i, col);
            if(isInsideBoard(row - i, col)){
                if(d.getColor() == c.oppositeDisk().getColor()){
                count ++;
                }
                else if(d.getColor() == c.getColor() && count >=1){
                    return true;
                }
                else if (isEmptyPosition(row, col, c)){
                    return false;
                }
            }
        }
        return false;
    }



    public Disk getAtDiskLocation(int row, int col) {// gets the disk location
    
        return board[row][col];
    }

    public void placeDisk(int row, int col, String color) {//makes disk over position
        board[row][col] = new Disk(color);
        
    }

    public void turnUp(int row, int col) {
        String color = board[row][col].getColor();
    
        for (int i = 1; i <= 8; i++) {
            int r = row - i;
    
            if (board[r][col].isEmpty()) {
                break; 
            }

            if (board[r][col].getColor().equals(color)) {
                break;
            }
    
            board[r][col].setColor(color);
        }
    }
    
    

    public void turnDown(int row, int col) {
        String color = board[row][col].getColor();
    
        for (int i = 1; i <= 8; i++) {
            int r = row + i;
    
            if (board[r][col].isEmpty()) {
                break; 
            }

            if (board[r][col].getColor().equals(color)) {
                break;
            }
    
            board[r][col].setColor(color);
        }
    }

    public void turnLeft(int row, int col) {
        String color = board[row][col].getColor();
    
        for (int i = 1; i <= 8; i++) {
            int c = col - i;
    
            if (board[row][c].isEmpty()) {
                break; 
            }

            if (board[row][c].getColor().equals(color)) {
                break;
            }
    
            board[row][c].setColor(color);
        }
    }

    public void turnRight(int row, int col) {
        String color = board[row][col].getColor();
    
        for (int i = 1; i <= 8; i++) {
            int c = col + i;
    
            if (board[row][c].isEmpty()) {
                break; 
            }

            if (board[row][c].getColor().equals(color)) {
                break;
            }
    
            board[row][c].setColor(color);
        }
    }

    public void uRight(int row, int col) {
        String color = board[row][col].getColor();
    
        for (int i = 1; i <= 8; i++) {
            int c = col + i;
            int r = row - i;
    
            if (board[r][c].isEmpty()) {
                break; 
            }

            if (board[r][c].getColor().equals(color)) {
                break;
            }
    
            board[r][c].setColor(color);
        }
    }

    public void uLeft(int row, int col) {
        String color = board[row][col].getColor();
    
        for (int i = 1; i <= 8; i++) {
            int c = col - i;
            int r = row - i;
    
            if (board[r][c].isEmpty()) {
                break; 
            }

            if (board[r][c].getColor().equals(color)) {
                break;
            }
    
            board[r][c].setColor(color);
        }
    }

    public void dRight(int row, int col) {
        String color = board[row][col].getColor();
    
        for (int i = 1; i <= 8; i++) {
            int c = col + i;
            int r = row + i;
    
            if (board[r][c].isEmpty()) {
                break; 
            }

            if (board[r][c].getColor().equals(color)) {
                break;
            }
    
            board[r][c].setColor(color);
        }
    }

    public void dLeft(int row, int col) {
        String color = board[row][col].getColor();
    
        for (int i = 1; i <= 8; i++) {
            int c = col - i;
            int r = row + i;
    
            if (board[r][c].isEmpty()) {
                break; 
            }

            if (board[r][c].getColor().equals(color)) {
                break;
            }
    
            board[r][c].setColor(color);
        }
    }

    public void allDirections(int row, int col) {
        turnUp(row, col);
        turnDown(row, col);
        turnLeft(row, col);
        turnRight(row, col);
        dLeft(row, col);
        dRight(row, col);
        uLeft(row, col);
        uRight(row, col);
    }

    




    

    public static void main(String[] args) {
        Board b = new Board();
        b.printBoard();
    }
}


