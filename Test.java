class BoardTest {
    public static void testOtherMethods() {
        int row1 = 1;
        int col1 = 5;
        int row2 = 2;
        int col2 = 5;
        
        Board b = new Board();
        b.printBoard();
        
        System.out.println("Is inside board (1,5): " + b.isInsideBoard(row1, col1));
        System.out.println("Disk at (1,5): " + b.getAtDiskLocation(row1, col1).getColor());
        System.out.println("Count of disks: " + b.countDisks(b.getAtDiskLocation(row1, col1).getColor()));
        
        System.out.println("Is inside board (2,5): " + b.isInsideBoard(row2, col2));
        System.out.println("Disk at (2,5): " + b.getAtDiskLocation(row2, col2).getColor());
    }

    public static void main(String[] args) {
        testOtherMethods();
    }
}

class CanFlipTest {
    static void testCanFlip() {
        Board testBoard = new Board();
        testBoard.initializeBoard();
        
        Disk white = new Disk("○");
        Disk black = new Disk("•");

        // Test 1: Vertical flip UP
        testBoard.getBoard()[6][5] = new Disk("○");
        testBoard.getBoard()[5][5] = new Disk("•");
        testBoard.getBoard()[4][5] = new Disk("•");
        testBoard.getBoard()[3][5] = new Disk("•");
        testBoard.getBoard()[2][5] = new Disk("○");
        System.out.println("Up (should be true): " + testBoard.canFlipUp(6, 5, white));

        // Test 2: Horizontal flip left
        testBoard = new Board();
        testBoard.getBoard()[5][5] = new Disk("○");
        testBoard.getBoard()[5][4] = new Disk("•");
        testBoard.getBoard()[5][3] = new Disk("•");
        testBoard.getBoard()[5][2] = new Disk("•");
        testBoard.getBoard()[5][1] = new Disk("○");
        System.out.println("Left (should be true): " + testBoard.canFlipLeft(5, 5, white));

        // Test 3: Diagonal flip left up
        testBoard = new Board();
        testBoard.getBoard()[6][6] = new Disk("○");
        testBoard.getBoard()[5][5] = new Disk("•");
        testBoard.getBoard()[4][4] = new Disk("•");
        testBoard.getBoard()[3][3] = new Disk("•");
        testBoard.getBoard()[2][2] = new Disk("○");
        System.out.println("Up-Left (should be true): " + testBoard.canFlipUpLeft(6, 6, white));

        // Test 4: Should fail  no matching disk at end
        testBoard = new Board();
        testBoard.getBoard()[6][5] = new Disk("○");
        testBoard.getBoard()[5][5] = new Disk("•");
        testBoard.getBoard()[4][5] = new Disk("•");
        testBoard.getBoard()[3][5] = new Disk("•");
        testBoard.getBoard()[2][5] = new Disk(".");
        System.out.println("Up (should be false): " + testBoard.canFlipUp(6, 5, white));
    }

    public static void main(String[] args) {
        testCanFlip();
    }
}

class DiskTest {
    public static void main(String[] args) {
        Disk testBlack = new Disk("•");
        Disk testWhite = new Disk("○");
        Disk testEmpty = new Disk(".");
        
        System.out.println("Black opposite: " + testBlack.oppositeDisk().getColor());
        System.out.println("White opposite: " + testWhite.oppositeDisk().getColor());
        System.out.println("Empty opposite: " + testEmpty.oppositeDisk().getColor());
        
        System.out.println("Black is empty: " + testBlack.isEmpty());
        System.out.println("White is empty: " + testWhite.isEmpty());
        System.out.println("Empty is empty: " + testEmpty.isEmpty());
    }
}

class PlayerTest {
    static void testGetters() {
        Player p1 = new Player("Alice", "•", false);
        Player p2 = new Player("Bot", "○", true);

        System.out.println("P1 name: " + p1.getName());
        System.out.println("P1 color: " + p1.getColor());
        System.out.println("P1 is bot: " + p1.isBot());

        System.out.println("P2 name: " + p2.getName());
        System.out.println("P2 color: " + p2.getColor());
        System.out.println("P2 is bot: " + p2.isBot());
    }
    
    static void testBotMove() {
        Board board = new Board();
        Player bot = new Player("Bot", "○", true);

        int[] move = bot.getMove(board);

        System.out.println("Bot made a move: " + (move != null));
        if (move != null) {
            System.out.println("Row in range: " + (move[0] >= 0 && move[0] < 8));
            System.out.println("Col in range: " + (move[1] >= 0 && move[1] < 8));
        }
    }

    static void testHumanIsBot() {
        Player human = new Player("Human", "•", false);
        System.out.println("Human is not bot: " + !human.isBot());
    }

    public static void main(String[] args) {
        testGetters();
        testHumanIsBot();
        testBotMove();
    }
}

class GameTest {
    static void testGameCreation() {
        System.out.println("Creating game - follow prompts to test");
      // This will prompt for user input
        // Game game = new Game();
        System.out.println("Game creation test skipped (requires user input)");
    }

    public static void main(String[] args) {
        testGameCreation();
        System.out.println("\nAll tests require manual verification");
        System.out.println("Run individual test classes to verify components");
    }
}
