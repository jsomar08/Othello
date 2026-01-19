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
            FileWriter writer = new FileWriter(filename);
            writer.write("MoveNumber,Player,Color,Row,Column,Position\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error creating log file: " + e.getMessage());
        }
    }

    public void logMove(int moveNumber, String playerName, String color, int row, int col) {
        String[] rowLabels = {"A", "B", "C", "D", "E", "F", "G", "H"};
        String position = rowLabels[row] + (col + 1); // converts 3 2 into D3
        
        try {
            FileWriter writer = new FileWriter(filename); 
            writer.write(moveNumber + "," + playerName + "," + color + "," + row + "," + col + "," + position + "\n");
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
        
        logger.logMove(1, "Alice", "•", 3, 2);
        logger.logMove(2, "Bob", "○", 2, 2);
        logger.logMove(3, "Alice", "•", 4, 2);
        
        System.out.println("Moves logged to game_moves.csv\n");
        
        System.out.println("Reading moves:");
        readMoves("game_moves.csv");
    }
}
