import java.util.Scanner;

class Player {
    private String name;
    private String color;
    private boolean isBot;
    static Scanner scanner = new Scanner(System.in);

    public Player(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public boolean isBot() {
        return isBot;
    }

    public int[] getMove(Board board) {
    String[] rowLabels = {"A","B","C","D","E","F","G","H"};

    while (true) { // keep asking until legal move
        System.out.print(name + " (" + color + ") enter move: ");
        String input = scanner.nextLine().toUpperCase();

        // 
        if (input.length() != 2) {
            System.out.println("Invalid input. Use format like A5.");
           
        }

        String rowLetter = input.substring(0, 1);// gets the value of the row (A)
        int col = 0;
        try {
            col = Integer.parseInt(input.substring(1)) - 1; // gets the value of the column and subtracts it by 1 because array starts 0
        } catch (NumberFormatException e) {
            System.out.println("Invalid column number. Use 1-8.");
            
        }

    
        int row = -1;
        for (int i = 0; i < rowLabels.length; i++) {
            if (rowLabels[i].equals(rowLetter)) {
                row = i;

            }
        }

        if (row < 0 || row > 8) { 
            System.out.println("Invalid row letter. Use A-H.");
  
        }

        
        if (!board.isInsideBoard(row, col)) {
            System.out.println("Move is outside the board. Try again.");
 
        }

        if (!board.isEmptyPosition(row, col)) {
            System.out.println("Position already inplace");
      
        }

        return new int[] {row, col};
    }
}

}

