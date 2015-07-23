/*************************************************************************
 * Name: Sandiego Rain
 * Email:
 *
 * Compilation:  javac-algs4 Solver.java
 * Execution:
 * Dependencies: 
 *
 * Description: 
 *
 *************************************************************************/
import java.util.Iterator;
import java.util.Comparator;

public class Solver {

    private class SearchNode {
        public Board currB;
        public int moves;
        public Board prevB; 

        public SearchNode() {}
        public SearchNode(Board cB, int moves, Board pB) {
            this.currB  = cB;
            this.moves = moves;
            this.prevB = pB; 
        }
    }
    private final Comparator<SearchNode> NodeComp = new NodeOrder();
    // THE Comparator
    private class NodeOrder implements Comparator<SearchNode> {
        public int compare(SearchNode p, SearchNode q) {
            if (p.moves + p.currB.manhattan() < q.moves + q.currB.manhattan())
                return -1;
            else if  (p.moves + p.currB.manhattan() == 
                q.moves + q.currB.manhattan())
                return 0;
            return 1; //neither of above cases
        }
    }

    private boolean foundGoal = false;
    private SearchNode finalN = new SearchNode();
    private int finalMoves = 0;
    private boolean solvable = false;
    // find a solution to the initial board
    // using the A* algorithm
    public Solver(Board initial) {
        // start Node, initialized by calling Solver()
        private SearchNode sN = new SearchNode(initial, 0, null);
        Board twinB = initial.twin();
        private SearchNode twinN = new SearchNode(twinB, 0, null);
        // initialize a minPQ with THE Comparator
        private MinPQ<SearchNode> minPQ = new MinPQ<SearchNode>(NodeComp);
        private MinPQ<SearchNode> twinPQ = new MinPQ<SearchNode>(NodeComp);
        minPQ.insert(sN);
        twinPQ.insert(twinN);
        SearchNode minNd = minPQ.delMin();
        SearchNode twinNd = twinPQ.delMin();
        // enque neighbors. exclude those disallowed ones
        while (!minNd.currB.isGoal() && !twinNd.currB.isGoal()) {
            for (Board b : minNd.currB.neighbors()) {
                if (!b.equals(minNd.prevB)) {
                    SearchNode neighN = 
                        new SearchNode(b, minNd.moves + 1, minNd.currB);
                    minPQ.insert(neighN);
                }
            } // end for 
            for (Board b2 : twinNd.currB.neighbors()) {
                if (!b2.equals(twinNd.prevB)) {
                    SearchNode neighN2 = 
                        new SearchNode(b2, twinNd.moves + 1, twinNd.currB);
                    twinPQ.insert(neighN2);
                }
            }
            minNd = minPQ.delMin();
            twinNd = twinPQ.delMin();
        } // end while loop
        if (minNd.currB.isGoal()) {
            foundGoal = true;
            finalN = minNd; 
            finalMoves = minNd.moves; 
        }
    }

    // is the initial board solvable ?
    public boolean isSolvable() {
         
         
    }

    // min umber of moves to solve initial board: -1 if no solution
    public int moves() {
        if (!isSolvable)
            return -1;
        if (foundGoal = true) 
            return finalMoves;
    }

    // sequence of boards in a shortest solution; null if no solution
    public Iterable<Board> solution() {
    }
    


    // solve a slider puzzle
    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int N = in.readInt();
        int[][] blocks = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);
    
        // solve the puzzle
        Solver solver = new Solver(initial);
    
        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    
    }
}


