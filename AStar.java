
import java.util.PriorityQueue;

class AStar {

    /**
     * Method that executes an A* search to find a solution to the N Queens
     * problem.
     *
     * @param b Board to perform the search on.
     */
    public static void performSearch(Board initial, int n) {
        //Init variables
        Board bestChild;

        //Boards to be evaluated
        PriorityQueue<Board> closed = new PriorityQueue();
        //Boards that have been evaluated
        PriorityQueue<Board> open = new PriorityQueue();

        open.add(initial); //Add initial board to list

        while (!open.isEmpty()) {
            //First Board will always have heuristic value <= all other Boards
            bestChild = open.poll();

            if (bestChild.getHV() == 0) {
                System.out.println("Final Board:");
                bestChild.printBoard();
                checkH(bestChild, n); // Check conflicts for the final board
                return;
            }
            //We've now evaluated this Board
            closed.add(bestChild);
            PriorityQueue<Board> childrenOfCurrent = bestChild.generateChildren();
            childrenOfCurrent.stream().filter((b) -> !(closed.contains(b)))
                    .filter((b) -> (!closed.contains(b))).forEach((b) -> {
                open.add(b);
            });

        }
        //If we get here, no solution was found
        System.out.println("No solution found.");
    }//doAStar

    public static void checkH(Board initial, int n){
        int[]board = initial.getBState();
        int conflict = 0;

        for(int i=0; i<n; i++){
            for (int j = i+1; j < n; j++) {
                if (j != i) { //Don't check the current queen's column

                    // Check for diagonal
                    if (Math.abs(board[i] - board[j]) == Math.abs(i - j)
                    && board[j] != 0 && board[i] != 0) {
                        conflict++; //There is a conflict
                        
                    // Check for knights move
                    }if (Math.abs(board[j] - board[i]) + Math.abs(j - i) == 3 && board[i] != 0 && board[j] != 0) {
                        conflict++; //There is a conflict
                    }
                }
            }
        }
        System.out.print("No. of conflicts: " + conflict);
    }

}
