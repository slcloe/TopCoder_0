package ch7;

public class ChessMetric {

    int[][] grid;
    int[] dx = { 1 , 0 , -1 , 0 , 1, -1 , 1 , -1 , 1 ,1, -1, -1, 2, 2, -2, -2};
    int[] dy = { 0 , 1 ,  0, -1, -1 , 1 , 1 , -1 , 2 ,-2 ,2 , -2, 1, -1, 1, -1};
    public long howMany(int size, int[] start, int[] end, int numMoves){
        grid = new int[size][size];


    }
}
