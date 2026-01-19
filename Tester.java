class BoardTest{
    public static void main(String[] args) {// testing board
        int row = 1;
        int col = 5;
        String coord = "A5";
        Board b = new Board();
        b.printBoard();
        System.out.println(b.isInsideBoard(row,col));
        System.out.println(b.letterToRowNumber(coord));
        System.out.println(b.isValidMove(row, col, b.getAtDiskLocation(row,col).getColor()));
        System.out.println(b.getAtDiskLocation(row, col));
        
        


        
    }
}
 
 
class DiskTest {
    public static void main(String[] args) {
        Disk testBlack = new Disk("○");
        Disk testWhite = new Disk("•");
        Disk testEmpty = new Disk(".");
        System.out.println(testBlack.flipingPlayer());
        System.out.println("hello");
        System.out.println(testWhite.flipingPlayer());
        System.out.println(testEmpty.flipingPlayer());
        System.out.println(testBlack.oppositeDisk());
        System.out.println(testWhite.oppositeDisk());
        System.out.println(testEmpty.oppositeDisk());

    }
}
