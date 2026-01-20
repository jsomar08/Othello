class BoardTest{
    public static void otherMethods(String[] args) {// testing board
        int row1 = 1;
        int col1 = 5;
        int row2 = 2;
        int col2 = 5;
        String coord1 = "A5";
        String coord2 = "D3";
        Board b = new Board();
        b.printBoard();
        System.out.println(b.isInsideBoard(row1,col1));
        System.out.println(b.letterToRowNumber(coord1));
        System.out.println(b.canFlipAll(row1, col1, b.getAtDiskLocation(row1,col1).getColor()));
        System.out.println(b.getAtDiskLocation(row1, col1));
        System.out.println(b.countDisks(b.getAtDiskLocation(row1, col1).getColor()));
        System.out.println(b.isInsideBoard(row2,col2));
        System.out.println(b.letterToRowNumber(coord2));
        System.out.println(b.canFlipAll(row2, col2, b.getAtDiskLocation(row2,col2).getColor()));
        System.out.println(b.getAtDiskLocation(row2, col2));
        System.out.println(b.countDisks(b.getAtDiskLocation(row2, col2).getColor()));
        
        

        
        


        
    }


    static void testCanFlip() {
        Board testBoard = new Board();
        testBoard.initializeBoard(); // Clear board first
        
        Disk white = new Disk("○");
        Disk black = new Disk("•");

        // Test 1: Vertical flip UP
       
        testBoard.getBoard()[6][5] = new Disk("○"); // starting position
        testBoard.getBoard()[5][5] = new Disk("•");
        testBoard.getBoard()[4][5] = new Disk("•");
        testBoard.getBoard()[3][5] = new Disk("•");
        testBoard.getBoard()[2][5] = new Disk("○");
        System.out.println("Up (should be true): " + testBoard.canFlipUp(6, 5));

        // Test 2: Horizontal flip left
        testBoard = new Board();
        testBoard.getBoard()[5][5] = new Disk("○");
        testBoard.getBoard()[5][4] = new Disk("•");
        testBoard.getBoard()[5][3] = new Disk("•");
        testBoard.getBoard()[5][2] = new Disk("•");
        testBoard.getBoard()[5][1] = new Disk("○");
        System.out.println("Left (should be true): " + testBoard.canFlipLeft(5, 5));

        // Test 3: Diagonal flip left up
        testBoard = new Board();
        testBoard.getBoard()[6][6] = new Disk("○");
        testBoard.getBoard()[5][5] = new Disk("•");
        testBoard.getBoard()[4][4] = new Disk("•");
        testBoard.getBoard()[3][3] = new Disk("•");
        testBoard.getBoard()[2][2] = new Disk("○");
        System.out.println("Up-Left (should be true): " + testBoard.canFlipUpLeft(6, 6));

        // Test 4: Should fail no matching disk at end
        testBoard = new Board();
        testBoard.getBoard()[6][5] = new Disk("○");
        testBoard.getBoard()[5][5] = new Disk("•");
        testBoard.getBoard()[4][5] = new Disk("•");
        testBoard.getBoard()[3][5] = new Disk("•");
        testBoard.getBoard()[2][5] = new Disk("."); 
        System.out.println("Up (should be false): " + testBoard.canFlipUp(6, 5));
    }

    public static void main(String[] args) {
        testCanFlip();
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
        System.out.println(testBlack.isEmpty());
        System.out.println(testWhite.isEmpty());
        System.out.println(testEmpty.isEmpty());

    }

}
class PlayerTest{
    public static void testGetters() {
        Player p1 = new Player("Alice", "•", false);
        Player p2 = new Player("Bot", "○", true);

        System.out.println(p1.getName());
        System.out.println(p1.getColor());
        System.out.println(p1.isBot());

        System.out.println(p2.getName());
        System.out.println(p2.getColor());
        System.out.println(p2.isBot());
    }
    static void testBotMove() {
        Board board = new Board();
        Player bot = new Player("Bot", "○", true);

        int[] move = bot.getMove(board);

        System.out.println((move != null));
        if (move != null) {
            System.out.println(move[0] >= 0 && move[0] < 8);

            System.out.println((move[1] >= 0 && move[1] < 8));
        }
    }

    static void testHumanIsBot() {
        Player human = new Player("Human", "•", false);

        System.out.println(!human.isBot());
    }

    public static void main(String[] args) {

        testGetters();
        testHumanIsBot();
        testBotMove();
    }

}

class GameTest {

    static void testHasValidMoves() {
        Game game = new Game();

        Player p1 = new Player("Test1", "•", false);
        Player p2 = new Player("Test2", "○", false);

        System.out.println(game.hasValidMoves(p1));

        System.out.println(game.hasValidMoves(p2));
    }

    static void testIsBoardFull() {
        Game game = new Game();

        System.out.println(game.isBoardFull());
    }

    public static void main(String[] args) {
        testHasValidMoves();
        testIsBoardFull();
    }
}

    
    
