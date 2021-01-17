package ch7;

public class ChessMetric {

    long [][][] ways = new long[100][100][55];
    int[] dx = { 1 , 0 , -1 , 0 , 1, -1 , 1 , -1 , 1 ,1, -1, -1, 2, 2, -2, -2};
    int[] dy = { 0 , 1 ,  0, -1, -1 , 1 , 1 , -1 , 2 ,-2 ,2 , -2, 1, -1, 1, -1};
    public long howMany(int size, int[] start, int[] end, int numMoves){
        int x, y, i, j;
        int sx = start[0], sy = start[1], ex = end[0], ey = end[1];

        ways[sy][sx][0] = 1;
        for(i=1;i<= numMoves;i++){
            for(x = 0; x<size;x++){
                for(y=0;y<size;y++){
                    for(j=0;j<16;j++){
                        int nx = x + dx[j];
                        int ny = y + dy[j];
                        if ( nx<0 || ny <0 || nx>= size|| ny >= size)
                            continue;

                        ways[ny][nx][i] += ways[y][x][i-1];
                    }
                }
            }
        }
        // 종착점의 가는 길을 구하는게 아니라 모든 영역에서의 가는 길을 다 구한다.
        // 이후 end 지점의 moves 만 빼온다.
        return ways[ey][ex][numMoves];
    }
}
