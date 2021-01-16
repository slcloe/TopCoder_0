package ch7;

public class BadNeightbors {
    public int maxDonations(int[] donations){
        int i;
        int ans=0;

        int N= donations.length;
        int[] dp = new int[N];

        // 첫번째집을 무조건 추가 -> 마지막 집은 FOR 문으로 확인 X
        for(i=0;i<N-1;i++){
            dp[i] = donations[i];
            if(i>0)dp[i] = Math.max(dp[i],dp[i-1]);
            if(i>1)dp[i] = Math.max(dp[i], dp[i-2] + donations[i]);
            ans = Math.max(ans, dp[i]);
        }

        // 마지막집을 무조건 추가 -> 첫번째 집은 FOR 문으로 확인 X
        for(i=0;i<N-1;i++) {
            dp[i] = donations[i + 1];
            if (i > 0) dp[i] = Math.max(dp[i], dp[i - 1]);
            if (i > 1) dp[i] = Math.max(dp[i], dp[i - 2] + donations[i + 1]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
