/*************************************************************************
 * Name: Sandiego Rain
 * Email:
 *
 * Compilation:  javac-algs4 Board.java
 * Execution:
 * Dependencies: 
 *
 * Description: an immutable data type Board
 *
 *************************************************************************/
//import java.util.Iterator;
//import java.util.Arrays;
package week4;
import edu.princeton.cs.algs4.Stack;

public class Board {
    // dimension is N
    private int N = 0;
    // tiles on the Board
    private char[][] tiles;
    // construct a board from an N-by-N array of blocks
    // where blocks[i][j] = blcok in row i, column j
    public Board(char[][] blocks) {
        if (blocks != null) {
            N = blocks[0].length;
            tiles = new char[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                 tiles[i][j] = blocks[i][j]; 
                }
            }
        }
    }
    // board dimension N
    public int dimension() {
        return N;
    }
    //number of blocks out of place
    public int hamming() {
        int hm = 0; // counter
        for (int i = 0; i < N; i++) {
           for (int j = 0; j < N; j++) {
               if ((tiles[i][j] > 0) && (tiles[i][j] != (i*N + j + 1))) 
                   hm++;
           }
        }
        return hm;
    }
    // sum of Man distances between blocks and goal
//    public int manhattan() {
//        int gi, gj, mh = 0;
//        for (int i = 0; i < N; i++) {
//           for (int j = 0; j < N; j++) {
//            gi = tiles[i][j] / N;
//            gj = tiles[i][j] % N - 1;
//            mh += gi + gj;    
//         }
//         }
//         return mh;
//    }
    public int manhattan() {
        int gi, gj, mh = 0;
        int value = 0;
        for (int i = 0; i < N; i++) {
           for (int j = 0; j < N; j++) {
            value = tiles[i][j];
            if (value == 0)
                continue;
            gi = (value - 1) / N;
            gj = (value - 1) % N;
            mh += Math.abs(i - gi) + Math.abs(j - gj);
         }
         }
         return mh;
    }
    // is this board the goal board?
    public boolean isGoal() {
        for (int i = 0; i < N; i++) {
           for (int j = 0; j < N; j++) {
               if ((tiles[i][j] > 0) && (tiles[i][j] != (i*N + j + 1))) 
               return false;
           }
        }
        return true;
    }
    // a board obtained by exchanging 2 adjacent blocks in the same row
    public Board twin() {
        char[][] newTiles = new char[N][N];
        for (int i = 0; i < N; i++) {
           for (int j = 0; j < N; j++) {
            newTiles[i][j] = tiles[i][j]; }
        }
        if (newTiles[0][0] != 0 && newTiles[0][1] != 0) {
            char tmp = newTiles[0][0];
            newTiles[0][0] = newTiles[0][1];
            newTiles[0][1] = tmp; }
        else {
            char tmp = newTiles[1][0];
            newTiles[1][0] = newTiles[1][1];
            newTiles[1][1] = tmp; 
            }
        Board nB = new Board(newTiles);
        return nB;
    }
    // does this board equal y?
    public boolean equals(Object y) {
        if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        Board that = (Board) y;
        for (int i = 0; i < N; i++) {
           for (int j = 0; j < N; j++) {
               if (this.tiles[i][j] != that.tiles[i][j])
                   return false; }
        }
        return true;
    }
    // all neighboring boards
    public Iterable<Board> neighbors() {
        Stack<Board> nbs = new Stack<Board>(); // neighboring Boards
        int iof0 = 0, jof0 = 0;
        for (int i = 0; i < N; i++) {
           for (int j = 0; j < N; j++) {
               if (tiles[i][j] == 0) {
                   iof0 = i;
                   jof0 = j;
                   break; }
           }
        }
        if (iof0 > 0) {
           exch(iof0, jof0, iof0 - 1, jof0);
        Board upN = new Board(tiles);
        nbs.push(upN);
        exch(iof0, jof0, iof0 - 1, jof0); }

        if (iof0 < N - 1) {
           exch(iof0, jof0, iof0 + 1, jof0);
        Board dwnN = new Board(tiles);
        nbs.push(dwnN);
        exch(iof0, jof0, iof0 + 1, jof0); }

        if (jof0 > 0) {
           exch(iof0, jof0, iof0, jof0 - 1);
        Board leftN = new Board(tiles);
        nbs.push(leftN);
           exch(iof0, jof0, iof0, jof0 - 1); }

        if (jof0 < N - 1) {
           exch(iof0, jof0, iof0, jof0 + 1);
        Board rightN = new Board(tiles);
        nbs.push(rightN);
           exch(iof0, jof0, iof0, jof0 + 1); }

        return nbs; // return the Iterable Stack
    }
    private void exch(int i, int j, int k, int l) {
        char tmp = tiles[i][j];
        tiles[i][j] = tiles[k][l];
        tiles[k][l] = tmp; 
    }
    //string representation of the board
    public String toString() {
    StringBuilder s = new StringBuilder();
    s.append(N + "\n");
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            s.append(String.format("%2d ", tiles[i][j]));
        }
        s.append("\n");
    }
    return s.toString();
    }
       

}


