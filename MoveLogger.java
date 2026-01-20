import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class MoveLogger {
    private String filename;

    /** Creates a MoveLogger that saves moves to the specified file.
     * @param filename the name of the file to store moves
     */
    public MoveLogger(String filename) {
        this.filename = filename;
        initializeFile();
    }

    /**
     * Initializes the log file by creating it if it doesn't exist and writing the header.
     */
    private void initializeFile() {
        try {
            FileWriter writer = new FileWriter(filename, true); // prevents moves from refreshing
            writer.write("Position\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error creating log file: " + e.getMessage());
        }
    }

    /** Logs a move to the file in the format of board position (e.g., A5)
     * @param row the row index of the move (0-7)
     * @param col the column index of the move (0-7)
     */
    public void logMove(int row, int col) {
    String[] rowLabels = {"A", "B", "C", "D", "E", "F", "G", "H"};
    String position = rowLabels[row] + (col + 1);
    
    try {
        FileWriter writer = new FileWriter(filename, true); //  Add true to prevent moves from refreshing
        writer.write(position + "\n"); 
        writer.close();
    } catch (IOException e) {
        System.out.println("Error logging move: " + e.getMessage());
    }
}

    /** Reads and prints all moves from the given log file.
     * @param filename the name of the file to read moves from
     */
    static void readMoves(String filename) {
        try {
            File f = new File(filename);
            Scanner input = new Scanner(f);
            
            while (input.hasNextLine()) {
                System.out.println(input.nextLine());
            }
            
            input.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        MoveLogger logger = new MoveLogger("game_moves.csv");
        
        logger.logMove( 3, 2);
        logger.logMove( 2, 2);
        logger.logMove( 4, 2);
        
        System.out.println("Moves logged to game_moves.csv\n");
        
        System.out.println("Reading moves:");
        
        readMoves("game_moves.csv");
    }
}
