/*************************************************************************
 *  Compilation:  javac PuzzleChecker.java
 *  Execution:    java PuzzleChecker filename1.txt filename2.txt ...
 *  Dependencies: Board.java Solver.java In.java
 *
 *  This program creates an initial board from each filename specified
 *  on the command line and finds the minimum number of moves to
 *  reach the goal state.
 *
 *  % java PuzzleChecker puzzle*.txt
 *  puzzle00.txt: 0
 *  puzzle01.txt: 1
 *  puzzle02.txt: 2
 *  puzzle03.txt: 3
 *  puzzle04.txt: 4
 *  puzzle05.txt: 5
 *  puzzle06.txt: 6
 *  ...
 *  puzzle3x3-impossible: -1
 *  ...
 *  puzzle42.txt: 42
 *  puzzle43.txt: 43
 *  puzzle44.txt: 44
 *  puzzle45.txt: 45
 *
 *************************************************************************/
package week4;
import java.io.File;
import java.io.FileInputStream;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
public class PuzzleChecker {

    public static void main(String[] args) throws Exception {

        // for each command-line argument
//        for (String filename : args) {
            System.setIn(new FileInputStream(new File("F://Libraries/Desktop/TestInput/puzzle/puzzle02.txt")));
            int N = StdIn.readInt(); // num of points
            // read in the board specified in the filename
   //         In in = new In(filename);
            //In in = new In(args[0]);
//            int N = in.readInt();
            char[][] tiles = new char[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    tiles[i][j] = StdIn.readChar();
                }
            }

            // solve the slider puzzle
            Board initial = new Board(tiles);
            Solver solver = new Solver(initial);
            if (solver.isSolvable())
            System.out.println( " some file: " + solver.moves());
            else StdOut.println("No solution possible");
//       } 
    }
}
