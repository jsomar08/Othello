class BoardTest{
    public static void main(String[] args) {// testing board
        int row = 1;
        int col = 5;
        Board b = new Board();
        b.printBoard();
    }
}
 
 
class DiskTest {
    public static void main(String[] args) {
        Disk testBlack = new Disk("○");
        Disk testWhite = new Disk("•");
        System.out.println(testBlack.flipingPlayer());
        System.out.println("hello");
        System.out.println(testWhite.flipingPlayer());
    }
}

