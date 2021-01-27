package ch8;

public class HamiltonPath {
    String[] roads;
    boolean[] visited;
    public int countPaths(String[] roads){
        int group = 0, free = 0;
        int[] connect = new int[roads.length];
        long sum = 1;

        this.roads = roads;
        visited = new boolean[roads.length];

        for(int i=0;i< roads.length;i++){
            int y= 0;
            for(int j=0;j<roads[i].length();j++){
                if(roads[i].charAt(j) == 'Y'){
                    if(2 < ++y) return 0;
                }
            }
            connect[i] = y;
        }

        for(int i=0;i<connect.length;i++){
            if(connect[i] == 0){
                visited[i] = true;
                free++;
            } else if(connect[i] == 1 && !visited[i]){
                group++;
                dfs(i);
            }
        }

        for(int i=0;i<visited.length;i++)
            if(!visited[i]) return 0;
        for(int i=0;i <group+free;i++)
            sum = sum *(i+1) % 1000000007;
        for(int i=0;i<group; i++)
            sum = sum * 2 % 1000000007;
        return (int) sum;
    }
    void dfs(int city){
        visited[city] = true;
        for(int i=0;i< roads[city].length();i++)
            if(roads[city].charAt(i)=='Y' && !visited[i]) dfs(i);
    }
}
