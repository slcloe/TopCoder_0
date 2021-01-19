package ch8;

import java.util.HashMap;

public class BatchSystem {
    public int[] schedule(int[] duration, String[] user){

        int N = duration.length;
        // 딕셔너리 key, value
        HashMap<String, Long> joptime = new HashMap<String, Long>();
        for(int n = 0; n<N; n++) joptime.put(user[n], 0L);
        for(int n = 0; n<N;n++) joptime.put(user[n], joptime.get(user[n]) + duration[n]);

        boolean [] done = new boolean[N];
        int [] ans = new int[N];
        int ansCount = 0;
        while(ansCount < N){
            String next = "";
            for(int n = 0;n<N;n++){
                if(!done[n] && (next.equals("")|| joptime.get(user[n])<joptime.get(next)))
                    next = user[n];
            }
            for(int n= 0;n<N;n++){
                if(user[n].equals(next))
                {done[n] = true;
                ans[ansCount++] = n;
                }
            }
        }
        return ans;
    }
}
