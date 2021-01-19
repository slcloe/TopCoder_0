package ch8;

import java.util.HashMap;

public class BatchSystem {
    public int[] schedule(int[] duration, String[] user){

        int N = duration.length;
        // 딕셔너리 key, value
        HashMap<String, Long> joptime = new HashMap<String, Long>();
        // hashmap 의 key 값의 중복은 없다.
        for(int n = 0; n<N; n++) joptime.put(user[n], 0L);
        for(int n = 0; n<N;n++) joptime.put(user[n], joptime.get(user[n]) + duration[n]);

        boolean [] done = new boolean[N]; // ans 배열에 추가되었는지에 대한 유무
        int [] ans = new int[N];
        int ansCount = 0;
        while(ansCount < N){
            String next = "";
            for(int n = 0;n<N;n++){
                if(!done[n] && (next.equals("")|| joptime.get(user[n])<joptime.get(next)))
                    next = user[n];
            } // key 값에 해당되는 value 의 최솟값을 찻는다.
            for(int n= 0;n<N;n++){
                if(user[n].equals(next)) // 최솟값의 이름이 user 의 몇번째에 있는지 확인 ( 중복처리도 가능)
                { // 같은 이름이 2번 있다면 이건 한번에 실행하는게 평균대기시간을 줄이는 일임
                    //  if 문이 2번 이상 실행될 수도 있음.
                    done[n] = true;
                    ans[ansCount++] = n;
                }
            }
        }
        return ans;
    }
}
