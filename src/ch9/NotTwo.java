package ch9;

public class NotTwo {
    public int maxStones(int width, int height){
        int i, j, res = 0;
        for(i=0;i<2;i++){
            for(j=0;j<2;j++)
                res += (((width+i)/2)*((height+j)/2)+1)/2;
        }
        return res;
    }
}
