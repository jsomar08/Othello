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
        String[] rowLabels = {"A", "B", "C", "D", "E", "F", "G", "H"};
        
        System.out.print("  ");
        for (int c = 1; c <= 8; c++) {
            System.out.print(c + " ");
        }
        System.out.println();

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
        if (!isInsideBoard(row, col)) {
            return false;
        }
        return board[row][col].getColor().equals(".");
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

    public boolean canFlipUp(int row, int col, Disk d) {
        int count = 0;
        
        for (int i = 1; i < 8; i++) {
            int r = row - i;
            if (!isInsideBoard(r, col)) {
                return false;
            }
            
            Disk c = getAtDiskLocation(r, col);
            
            if (isEmptyPosition(r, col)) {
                return false;
            }
            
            if (d.getColor().equals(c.oppositeDisk().getColor())) {
                count++;
            } else if (d.getColor().equals(c.getColor()) && count >= 1) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean canFlipDown(int row, int col, Disk d) {
        int count = 0;
        
        for (int i = 1; i < 8; i++) {
            int r = row + i;
            if (!isInsideBoard(r, col)) {
                return false;
            }
            
            Disk c = getAtDiskLocation(r, col);
            
            if (isEmptyPosition(r, col)) {
                return false;
            }
            
            if (d.getColor().equals(c.oppositeDisk().getColor())) {
                count++;
            } else if (d.getColor().equals(c.getColor()) && count >= 1) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean canFlipRight(int row, int col, Disk d) {
        int count = 0;
        
        for (int i = 1; i < 8; i++) {
            int c = col + i;
            if (!isInsideBoard(row, c)) {
                return false;
            }
            
            Disk current = getAtDiskLocation(row, c);
            
            if (isEmptyPosition(row, c)) {
                return false;
            }
            
            if (d.getColor().equals(current.oppositeDisk().getColor())) {
                count++;
            } else if (d.getColor().equals(current.getColor()) && count >= 1) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean canFlipLeft(int row, int col, Disk d) {
        int count = 0;
        
        for (int i = 1; i < 8; i++) {
            int c = col - i;
            if (!isInsideBoard(row, c)) {
                return false;
            }
            
            Disk current = getAtDiskLocation(row, c);
            
            if (isEmptyPosition(row, c)) {
                return false;
            }
            
            if (d.getColor().equals(current.oppositeDisk().getColor())) {
                count++;
            } else if (d.getColor().equals(current.getColor()) && count >= 1) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean canFlipUpRight(int row, int col, Disk d) {
        int count = 0;
        
        for (int i = 1; i < 8; i++) {
            int r = row - i;
            int c = col + i;
            if (!isInsideBoard(r, c)) {
                return false;
            }
            
            Disk current = getAtDiskLocation(r, c);
            
            if (isEmptyPosition(r, c)) {
                return false;
            }
            
            if (d.getColor().equals(current.oppositeDisk().getColor())) {
                count++;
            } else if (d.getColor().equals(current.getColor()) && count >= 1) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean canFlipUpLeft(int row, int col, Disk d) {
        int count = 0;

        for (int i = 1; i < 8; i++) {
            int r = row - i;
            int c = col - i;

            if (!isInsideBoard(r, c)) {
                return false;
            }

            Disk current = getAtDiskLocation(r, c);

            if (isEmptyPosition(r, c)) {
                return false;
            }

            if (d.getColor().equals(current.oppositeDisk().getColor())) {
                count++;
            } else if (d.getColor().equals(current.getColor()) && count >= 1) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /** Checks to see if the  disk can be flipped down left
     * @param row the row index at where the disk can be placed
     * @param col the column index at where the disk can be placed
     * @param d the disk that's being flipped
     * @return  true or false
     */
    public boolean canFlipDownLeft(int row, int col, Disk d) {
        int count = 0;
        
        for (int i = 1; i < 8; i++) {
            int r = row + i;
            int c = col - i;
            if (!isInsideBoard(r, c)) {
                return false;
            }
            
            Disk current = getAtDiskLocation(r, c);
            
            if (isEmptyPosition(r, c)) {  
                return false;
            }
            
            if (d.getColor().equals(current.oppositeDisk().getColor())) {
                count++;
            } else if (d.getColor().equals(current.getColor()) && count >= 1) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /** Checks to see if the disk can be flipped in the down right direction
     * @param row the row index at where the disk can be placed
     * @param col the column index at where the disk can be placed
     * @param d the disk thats being flipped
     * @return true or false
     */
    public boolean canFlipDownRight(int row, int col, Disk d) {
        int count = 0;
        
        for (int i = 1; i < 8; i++) {
            int r = row + i;
            int c = col + i;
            if (!isInsideBoard(r, c)) {
                return false;
            }
            
            Disk current = getAtDiskLocation(r, c);
            
            if (isEmptyPosition(r, c)) {
                return false;
            }
            
            if (d.getColor().equals(current.oppositeDisk().getColor())) {
                count++;
            } else if (d.getColor().equals(current.getColor()) && count >= 1) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /** checks to see if the disk can be flipped in all directions
     * @param row the row index at where the disk can be placed
     * @param col the column index at where the disk can be placed
     * @param d the disk that's being flipped
     * @return true or false
     */
    public boolean canFlipAll(int row, int col, Disk d) {
        return canFlipDown(row, col, d) ||
               canFlipUp(row, col, d) ||
               canFlipLeft(row, col, d) ||
               canFlipRight(row, col, d) ||
               canFlipUpRight(row, col, d) ||
               canFlipUpLeft(row, col, d) ||
               canFlipDownLeft(row, col, d) ||
               canFlipDownRight(row, col, d);
    }

    /** Flips the disk up if the move is valid
     * @param row the row index at where the disk was placed
     * @param col the column index at where the disk was placed
     */
    public void turnUp(int row, int col) {
        if (!canFlipUp(row, col, board[row][col])) {
            return;
        }
        
        String color = board[row][col].getColor();
        
        for (int i = 1; i < 8; i++) {
            int r = row - i;
            
            if (!isInsideBoard(r, col) || board[r][col].isEmpty()) {
                break;
            }

            if (board[r][col].getColor().equals(color)) {
                break;
            }
            
            board[r][col].setColor(color);
        }
    }

    /** Flips the disk down if the move is valid
     * @param row the row index at where the disk was placed
     * @param col the row column at where the disk was placed
     */
    public void turnDown(int row, int col) {
        if (!canFlipDown(row, col, board[row][col])) {
            return;
        }
        
        String color = board[row][col].getColor();
        
        for (int i = 1; i < 8; i++) {
            int r = row + i;
            
            if (!isInsideBoard(r, col) || board[r][col].isEmpty()) {
                break;
            }

            if (board[r][col].getColor().equals(color)) {
                break;
            }
            
            board[r][col].setColor(color);
        }
    }

    /** Flips the disk left if move valid
     * @param row the row index at where the disk was placed
     * @param col the column index at where the disk was placed
     */
    public void turnLeft(int row, int col) {
        if (!canFlipLeft(row, col, board[row][col])) {
            return;
        }
        
        String color = board[row][col].getColor();
        
        for (int i = 1; i < 8; i++) {
            int c = col - i;
            
            if (!isInsideBoard(row, c) || board[row][c].isEmpty()) {
                break;
            }

            if (board[row][c].getColor().equals(color)) {
                break;
            }
            
            board[row][c].setColor(color);
        }
    }

    /** Flips the disk right if move is valid
     * @param row the row index at where the disk was placed
     * @param col the column index at where the disk was placed
     */
    public void turnRight(int row, int col) {
        if (!canFlipRight(row, col, board[row][col])) {
            return;
        }
        
        String color = board[row][col].getColor();
        
        for (int i = 1; i < 8; i++) {
            int c = col + i;
            
            if (!isInsideBoard(row, c) || board[row][c].isEmpty()) {
                break;
            }

            if (board[row][c].getColor().equals(color)) {
                break;
            }
            
            board[row][c].setColor(color);
        }
    }

    /** Flips the disk towards the up-right direction if move valid
     * @param row the row index at where the disk was placed
     * @param col the column index at where the disk was placed
     */
    public void uRight(int row, int col) {
        if (!canFlipUpRight(row, col, board[row][col])) {
            return;
        }
        
        String color = board[row][col].getColor();
        
        for (int i = 1; i < 8; i++) {
            int c = col + i;
            int r = row - i;
            
            if (!isInsideBoard(r, c) || board[r][c].isEmpty()) {
                break;
            }

            if (board[r][c].getColor().equals(color)) {
                break;
            }
            
            board[r][c].setColor(color);
        }
    }

    /** Flips the the disk towards the up direction if the move is valid
     * @param row the row index at where the disk was placed
     * @param col the col index at where the disk was placed
     */
    public void uLeft(int row, int col) {
        if (!canFlipUpLeft(row, col, board[row][col])) {
            return;
        }
        
        String color = board[row][col].getColor();
        
        for (int i = 1; i < 8; i++) {
            int c = col - i;
            int r = row - i;
            
            if (!isInsideBoard(r, c) || board[r][c].isEmpty()) {
                break;
            }

            if (board[r][c].getColor().equals(color)) {
                break;
            }
            
            board[r][c].setColor(color);
        }
    }

    /** flips the disk towards the right direction if its valid
     * @param row the row index at where the disk was placed
     * @param col the column index at where the disk was placed
     */
    public void dRight(int row, int col) {
        if (!canFlipDownRight(row, col, board[row][col])) {
            return;
        }
        
        String color = board[row][col].getColor();
        
        for (int i = 1; i < 8; i++) {
            int c = col + i;
            int r = row + i;
            
            if (!isInsideBoard(r, c) || board[r][c].isEmpty()) {
                break;
            }

            if (board[r][c].getColor().equals(color)) {
                break;
            }
            
            board[r][c].setColor(color);
        }
    }

    /** flips the disk in the left direction if valid
     * @param row the row index at where the disk was placed
     * @param col the column index at where the disk was placed
     */
    public void dLeft(int row, int col) {
        if (!canFlipDownLeft(row, col, board[row][col])) {
            return;
        }
        
        String color = board[row][col].getColor();
        
        for (int i = 1; i < 8; i++) {
            int c = col - i;
            int r = row + i;
            
            if (!isInsideBoard(r, c) || board[r][c].isEmpty()) {
                break;
            }

            if (board[r][c].getColor().equals(color)) {
                break;
            }
            
            board[r][c].setColor(color);
        }
    }

    /** Flips all opponent disks in every valid direction from the placed disk.
     * @param row the row index at where the disk was placed
     * @param col the col index at where the disk was placed
     */
    public void allDirections(int row, int col) {
        turnUp(row, col);
        turnDown(row, col);
        turnLeft(row, col);
        turnRight(row, col);
        uLeft(row, col);
        uRight(row, col);
        dLeft(row, col);
        dRight(row, col);
    }

    public Disk getAtDiskLocation(int row, int col) {
        return board[row][col];
    }

    public void placeDisk(int row, int col, String color) {
        board[row][col] = new Disk(color);
    }

    public Disk[][] getBoard() {
        return board;
    }

    public static void main(String[] args) {
        Board b = new Board();
        b.printBoard();
    }
}
