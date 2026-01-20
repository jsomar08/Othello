import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Player {
    private String name;
    private String color;
    private boolean isBot;
    static Scanner scanner = new Scanner(System.in);

    public Player(String name, String color, boolean isBot) {
        this.name = name;
        this.color = color;
        this.isBot = isBot;
    }

    /** gets the name of the human
     * @return the name
     */
    public String getName() {
        return name;
    }

    /** gets the colour of the player
     * @return the colour
     */
    public String getColor() {
        return color;
    }

    /** checks to see if a bot will be playing or not
     * @return true or false
     */
    public boolean isBot() {
        return isBot;
    }

    /** gets the move from either the human or the bot
     * @param board 
     * @return human or bot moves
     */
    public int[] getMove(Board board) {
        if (isBot) {
            return getBotMove(board);
        } else {
            return getHumanMove(board);
        }
    }

    /** Gets any valid move the human inputs
     * @param board the current board
     * @return an int array {row, col} representing the human player's move
     */
    private int[] getHumanMove(Board board) {
        String[] rowLabels = {"A", "B", "C", "D", "E", "F", "G", "H"};

        while (true) {
            System.out.print(name + " (" + color + ") enter move: ");
            String input = scanner.nextLine().toUpperCase().trim();

            if (input.length() < 2) {
                System.out.println("Invalid input. Use format like A5.");
                continue;
            }

            String rowLetter = input.substring(0, 1);
            int col;
            
            try {
                col = Integer.parseInt(input.substring(1)) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Invalid column. Use 1-8.");
                continue;
            }

            int row = -1;
            for (int i = 0; i < 8; i++) {
                if (rowLabels[i].equals(rowLetter)) {
                    row = i;
                    break;
                }
            }

            if (row < 0 || col < 0 || row >= 8 || col >= 8) {
                System.out.println("Invalid move. Use A-H and 1-8.");
                continue;
            }

            if (!board.isEmptyPosition(row, col)) {
                System.out.println("Position already occupied");
                continue;
            }

            Disk d = new Disk(color);
            if (!board.canFlipAll(row, col, d)) {
                System.out.println("Illegal move no disks would flip");
                continue;
            }

            return new int[] {row, col};
        }
    }

    /** Finds a valid move for the bot by checking all empty board positions and selecting one at random
     * @param board  the current game board used to determine valid moves
     * @return an int array {row, col} representing the bot’s move, or null if no valid moves exist
     */
    private int[] getBotMove(Board board) {

        
        ArrayList<int[]> validMoves = new ArrayList<>();
        
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if (board.isEmptyPosition(r, c)) {
                    Disk d = new Disk(color);
                    if (board.canFlipAll(r, c, d)) {
                         // Check if placing here would flip opponent disks 
                        validMoves.add(new int[] {r, c});
                    }
                }
            }
        }

        if (validMoves.isEmpty()) {
            return null;
        }

        // Pick random valid move
        Random rand = new Random();
        int[] move = validMoves.get(rand.nextInt(validMoves.size()));
        
        String[] rowLabels = {"A", "B", "C", "D", "E", "F", "G", "H"};
        System.out.println(name + " plays: " + rowLabels[move[0]] + (move[1] + 1));
        
        return move;
    }

    public static void main(String[] args) {
        Board board = new Board();
        
        Player human = new Player("Human", "•", false);
        Player bot = new Player("Bot", "○", true);
        
        board.printBoard();
        
        int[] humanMove = human.getMove(board);
        System.out.println("Human move: " + humanMove[0] + ", " + humanMove[1]);
        
        int[] botMove = bot.getMove(board);
        System.out.println("Bot move: " + botMove[0] + ", " + botMove[1]);
    }
}
