import java.util.Scanner;

class Player {
    private String name;
    private String color;
    private boolean isBot;

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
    
        Scanner scanner = new Scanner(System.in);

    String[] rowLabels = {"A","B","C","D","E","F","G","H"};

    while (true) {
        System.out.print(name + " (" + color + ") enter move: ");
        String input = scanner.nextLine().toUpperCase();

        if (input.length() < 2 || input.length() > 2) {
            System.out.println("Invalid input. "); // does allow A5 but not ABC123
        }

        String rowLetter = input.substring(0, 1); // Gets A
        int col = Integer.parseInt(input.substring(1)) - 1; // Gets 5 

    }

    // Convert the row letter (A–H) into a row index (0–7)
    // use loop


    // if row and column are in the board
    // return array with the coordinate


}
}
