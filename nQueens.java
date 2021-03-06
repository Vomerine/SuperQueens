
import java.util.*;

public final class nQueens {

    public static int n;
    public static int seed;
    public static int blind_configs_tested;
    public static int aStar_configs_tested;
    Scanner scanner;

    public nQueens() {
        //Init variables
        getInput();
        blind_configs_tested = 0;
        aStar_configs_tested = 0;

        Random ra = new Random();
        seed = ra.nextInt(10);
        Random rand = new Random(seed);
        int[] board = new int[n]; //Array to represent seeded board
        //Filling array using Math.Random and seed value
        for (int i = 0; i < n; i++) {
            board[i] = rand.nextInt(n) + 1;
        }
       
        Board initial = new Board(board); //Creating new Board object
        PriorityQueue<Board> PQ; //PriorityQueue to store children of b
        PQ = initial.generateChildren();
        System.out.println("\nA* Search");
        System.out.println("Initial Board: ");
        initial.printBoard();
        AStar.performSearch(initial, n);
     
    }

    /**
     * Method to get user input for problem size and seed.
     */
    private void getInput() {
        scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Please enter the size of the problem (n >= 4): ");
            try {
                n = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("\nError: invalid input.");
            }
            if (n < 4) {
                System.out.println("Error: n must be greater than or equal to 4.");
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        nQueens q = new nQueens();
    }
}
