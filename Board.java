



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

    public void printBoard() {//prints board layout
        System.out.print("  ");
        for (int c = 1; c <= 8; c++) {
            System.out.print(c + " ");
        }
        System.out.println();

        for (int r = 0; r < 8; r++) {
            System.out.print((char)('A' + r) + " ");
            for (int c = 0; c < 8; c++) {
                System.out.print(board[r][c].getColor() + " ");
            }
            System.out.println();
        }
    }

    public boolean isInsideBoard(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }

    public boolean isEmptyPosition(int row, int col, Disk d) {
    return isInsideBoard(row, col) && d.getColor().equals(".");
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

    

    public boolean canFlipUp(int row, int col){
        int count = 0;
        Disk d = getAtDiskLocation(row, col);
        
        for (int i = 0; i<=1 && i<8;i++){
            Disk c = getAtDiskLocation(row -i, col);
            if(isInsideBoard(row - i, col)){
                if(d.getColor().equals(c.oppositeDisk().getColor())){
                    count ++;
                }
                else if(d.getColor().equals(c.getColor()) && count >=1){
                    return true;
                }
                else if (isEmptyPosition(row, col, c)){
                    return false;
                }
            }
        }
        return false;
    }
    public boolean canFlipDown(int row, int col) {
        int count = 0;
        Disk d = getAtDiskLocation(row, col);
        
        for (int i = 0; i<=1 && i<8;i++){
            Disk c = getAtDiskLocation(row+i, col);
            if(isInsideBoard(row+i, col)){
                if(d.getColor().equals(c.oppositeDisk().getColor())){
                    count ++;
                }
                else if(d.getColor().equals(c.getColor()) && count >=1){
                    return true;
                }
                else if (isEmptyPosition(row, col, c)){
                    return false;
                }
            }
        }
        return false;
        
    }
    public boolean canFlipRight(int row, int col) {
        int count = 0;
        Disk d = getAtDiskLocation(row, col);
        
        for (int i = 0; i>=1 && i<8;i++){
            Disk c = getAtDiskLocation(row, col-i);
            if(isInsideBoard(row, col-i)){
                if(d.getColor().equals(c.oppositeDisk().getColor())){
                    count ++;
                }
                else if(d.getColor().equals(c.getColor()) && count >=1){
                    return true;
                }
                else if (isEmptyPosition(row, col, c)){
                    return false;
                }
            }
        }
        return false;
        
    }
    public boolean canFlipUpRight(int row, int col) {
        int count = 0;
        Disk d = getAtDiskLocation(row, col);
        
        for (int i = 0; i>=1 && i<8;i++){
            Disk c = getAtDiskLocation(row-i, col-i);
            if(isInsideBoard(row-i, col-i)){
                if(d.getColor().equals(c.oppositeDisk().getColor())){
                    count ++;
                }
                else if(d.getColor().equals(c.getColor()) && count >=1){
                    return true;
                }
                else if (isEmptyPosition(row, col, c)){
                    return false;
                }
            }
        }
        return false;
        
    }
    public boolean canFlipUpLeft(int row, int col) {
        int count = 0;
        Disk d = getAtDiskLocation(row, col);
        
        for (int i = 0; i<=1 && i<8;i++){
            Disk c = getAtDiskLocation(row-i, col+i);
            if(isInsideBoard(row-i, col+i)){
                if(d.getColor().equals(c.oppositeDisk().getColor())){
                    count ++;
                }
                else if(d.getColor().equals(c.getColor()) && count >=1){
                    return true;
                }
                else if (isEmptyPosition(row, col, c)){
                    return false;
                }
            }
        }
        return false;
    }

    public boolean canFlipLeft(int row, int col) {
        int count = 0;
        Disk d = getAtDiskLocation(row, col);
        
        for (int i = 0; i<=1 && i<8;i++){
            Disk c = getAtDiskLocation(row, col+i);
            if(isInsideBoard(row, col+i)){
                if(d.getColor().equals(c.oppositeDisk().getColor())){
                    count ++;
                }
                else if(d.getColor().equals(c.getColor()) && count >=1){
                    return true;
                }
                else if (isEmptyPosition(row, col, c)){
                    return false;
                }
            }
        }
        return false;
    }
    public boolean canFlipDownLeft(int row, int col) {
        int count = 0;
        Disk d = getAtDiskLocation(row, col);
        
        for (int i = 0; i<=1 && i<8;i++){
            Disk c = getAtDiskLocation(row+i, col+i);
            if(isInsideBoard(row+i, col+i)){
                if(d.getColor().equals(c.oppositeDisk().getColor())){
                    count ++;
                }
                else if(d.getColor().equals(c.getColor()) && count >=1){
                    return true;
                }
                else if (isEmptyPosition(row, col, c)){
                    return false;
                }
            }
        }
        return false;
    }
    public boolean canFlipDownRight(int row, int col) {
        int count = 0;
        Disk d = getAtDiskLocation(row, col);
        
        for (int i = 0; i>=1 && i<8;i++){
            Disk c = getAtDiskLocation(row+i, col-i);
            if(isInsideBoard(row+i, col-i)){
                if(d.getColor().equals(c.oppositeDisk().getColor())){
                    count ++;
                }
                else if(d.getColor().equals(c.getColor()) && count >=1){
                    return true;
                }
                else if (isEmptyPosition(row, col, c)){
                    return false;
                }
            }
        }
        return false;
        
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




    public Disk getAtDiskLocation(int row, int col) {// gets the disk at the specific location
    
        return board[row][col];
    }

    public void placeDisk(int row, int col, String color) {//puts disk over position
        board[row][col] = new Disk(color);
        
    }

    public boolean isValidMove(int row, int col, String color) {
        if (!getAtDiskLocation(row, col).getColor().equals(".")) {
        return false;
        }
        return canFlipUp(row, col) ||canFlipDown(row, col) ||canFlipLeft(row, col) ||canFlipRight(row, col) ||canFlipUpRight(row, col) ||canFlipUpLeft(row, col) ||canFlipDownRight(row, col) ||canFlipDownLeft(row, col);

    }
}

