import java.util.Scanner;

class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private MoveLogger logger;
    private Scanner scanner;

    /**
     * Creates a new game, initializes the board, move logger, input scanner, and sets up the players and game
     */ 
    public Game() {
        board = new Board();
        logger = new MoveLogger("game_moves.csv");
        scanner = new Scanner(System.in);
        setupGame();
    }

    /**
     * Asks the user to choose the game mode and sets up the colours and whether its pvp or pvb
     */
    private void setupGame() {
        System.out.println("=== OTHELLO ===");
        System.out.println("1. Player vs Player");
        System.out.println("2. Player vs Bot");
        System.out.print("Choose game mode: ");
        
        int choice = 0;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            choice = 1;
        }

        if (choice == 1) {
            // Player vs Player
            System.out.print("Enter Player 1 name: ");
            String name1 = scanner.nextLine();
            player1 = new Player(name1, "•", false);

            System.out.print("Enter Player 2 name: ");
            String name2 = scanner.nextLine();
            player2 = new Player(name2, "○", false);
        } else {
            // Player vs Bot
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            
            System.out.println("Choose your color:");
            System.out.println("Type 'black' (•) - goes first");
            System.out.println("Type 'white' (○) - goes second");
            System.out.print("Choice: ");
            
            String colorChoice = scanner.nextLine().toLowerCase().trim();

            if (colorChoice.equals("black")) {
                player1 = new Player(name, "•", false);
                player2 = new Player("Bot", "○", true);
            } else if (colorChoice.equals("white")) {
                player1 = new Player("Bot", "•", true);
                player2 = new Player(name, "○", false);
            } else {
                // Default to black if invalid input
                System.out.println("Invalid choice. Defaulting to black.");
                player1 = new Player(name, "•", false);
                player2 = new Player("Bot", "○", true);
            }
        }

        currentPlayer = player1;
    }

    /**
     *  Controls the full Othello game flow from start until the game ends.
     */
    public void play() {
        System.out.println("\n=== GAME START ===");
        System.out.println("Black (•) vs White (○)");
        System.out.println();

        int consecutivePasses = 0;

        while (true) {
            board.printBoard();
            System.out.println("\nScore - Black (•): " + board.countDisks("•") + 
                             " | White (○): " + board.countDisks("○"));
            System.out.println();

            // Check if current player has any valid moves
            if (!hasValidMoves(currentPlayer)) {
                System.out.println(currentPlayer.getName() + " has no valid moves. Passing turn.");
                consecutivePasses++;
                
                if (consecutivePasses == 2) {
                    System.out.println("\nBoth players have no valid moves. Game over!");
                    break;
                }
                
                switchPlayer();
                continue;
            }

            consecutivePasses = 0;

            int[] move = currentPlayer.getMove(board);
            
            if (move != null) {
                int row = move[0];
                int col = move[1];

                // Log the move to CSV
                logger.logMove(row, col);

                // Place the disk
                board.placeDisk(row, col, currentPlayer.getColor());
                
                // Flip all disks in all valid directions
                board.allDirections(row, col);
            }

            // Check if board is full
            if (isBoardFull()) {
                System.out.println("\nBoard is full. Game over!");
                break;
            }

            switchPlayer();
        }

        endGame();
    }

    /** Checks if the given player has at least one valid move
    * @param player the player being checked for possible moves
    * @return true if the player has a valid move false otherwise
    */
    private boolean hasValidMoves(Player player) {
        // Loop through entire board to find at least one valid move
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if (board.isEmptyPosition(r, c)) {
                    Disk d = new Disk(player.getColor());
                    if (board.canFlipAll(r, c, d)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /** Checks to see if the board is full
     * @return true if it is false if not
     */
    private boolean isBoardFull() {
        // Check if any empty positions remain
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if (board.isEmptyPosition(r, c)) {
                    return false;
                }
            }
        }
        return true;
    }

    /** 
     * switches turns for the player after every completed move
     */
    private void switchPlayer() {
    if (currentPlayer == player1) {
        currentPlayer = player2;
    } else {
        currentPlayer = player1;
    }
}


    /**
     * Displays the final board, scores both players, announces the winner, and ends the game.
     */
    private void endGame() {
        board.printBoard();
        
        int blackCount = board.countDisks("•");
        int whiteCount = board.countDisks("○");

        System.out.println("\n=== FINAL SCORE ===");
        System.out.println(player1.getName() + " (•): " + blackCount);
        System.out.println(player2.getName() + " (○): " + whiteCount);

        if (blackCount > whiteCount) {
            System.out.println("\n" + player1.getName() + " wins!");
        } else if (whiteCount > blackCount) {
            System.out.println("\n" + player2.getName() + " wins!");
        } else {
            System.out.println("\nIt's a tie!");
        }
        
        System.out.println("\nGame moves saved to game_moves.csv");
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
