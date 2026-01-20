class Test {

    /** testing all canFlip methods 
     * 
     */
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

        // Test 4: Should fail no matching disk at end
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
