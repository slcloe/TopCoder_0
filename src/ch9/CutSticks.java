package ch9;

public class CutSticks {
    public double maxKth(int[] sticks, int C, int K){
        double low = 0;
        double high = 1e9;
        int i,j;
        for(i=0;i<100;i++){
            long count = 0;
            double mid = (low + high) / 2;
            long cut = 0;
            for(j=0;j<sticks.length;j++){
                long next = (long)(sticks[j]/mid);
                cut += Math.max(0, (next-1));
                count += next;
            }
            count -= Math.max(0, cut - C);
            if(count >= K )low = mid;
            else high = mid;
        }
        return low; // high 를 리턴해도 상관없음.
    }
}
