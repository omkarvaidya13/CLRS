package miscl;

import java.util.*;
public class tictactoe {
    private static   int[] rows;
    private static int cols[];
    private static int diagonal1;
    private static int diagnoal2;

    private tictactoe(int n){
        rows = new int[n];
        cols = new int[n];
    }

    private static int move(int row, int col, int player){
        int move = (player == 1) ? 1 : -1;
        int n = rows.length;

        rows[row] += move;
        cols[col] += move;

        if(row == col)
            diagonal1 += move;
        if(row + col == n-1)
            diagnoal2 += move;
        if(Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diagonal1) == n || Math.abs(diagnoal2) == n)
            return player;

        return 0;
    }

    public static void main(String[] args) {
        tictactoe t = new tictactoe(3);
        int result;
        result = t.move(0,0,1);
        System.out.println(result);
        result = t.move(0,2,2);
        System.out.println(result);
        result = t.move(2,2,1);
        System.out.println(result);
        result = t.move(1,1,2);
        System.out.println(result);
        result = t.move(2,0,1);
        System.out.println(result);
        result = t.move(1,0,2);
        System.out.println(result);
        result = t.move(2,1,1);
        System.out.println(result);
    }
}
