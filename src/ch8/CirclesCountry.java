package ch8;

public class CirclesCountry {
    public int leastBorders(int[] X, int[] Y, int[] R, int x1, int y1, int x2, int y2){
        int ans = 0;
        for(int i=0;i<X.length;i++){
            if(check(X[i],Y[i],x1,y1,R[i]) != check(X[i],Y[i],x2,y2,R[i]))
                ans++;
        }
        return ans;
    }

    boolean check(int x1, int y1, int x2, int y2, int r){
        int check_distance = ( x1-x2) * (x1-x2) + (y1- y2)*(y1-y2);
        if(check_distance < r *r ) return true;
        else return false;
    }
}
