import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class MoveLogger {
    private String filename;

    public MoveLogger(String filename) {
        this.filename = filename;
        initializeFile();
    }

    private void initializeFile() {
        try {
            FileWriter writer = new FileWriter(filename, true); // prevents moves from refreshing
            writer.write("Position\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error creating log file: " + e.getMessage());
        }
    }

    public void logMove(int row, int col) {
    String[] rowLabels = {"A", "B", "C", "D", "E", "F", "G", "H"};
    String position = rowLabels[row] + (col + 1);
    
    try {
        FileWriter writer = new FileWriter(filename, true); // ← Add true for append mode
        writer.write(position + "\n"); // ← Add \n for new line
        writer.close();
    } catch (IOException e) {
        System.out.println("Error logging move: " + e.getMessage());
    }
}

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
