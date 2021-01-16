package ch5;

public class NumberMagicEasy {
    public int theNumber(String answer){
        int ans = 0;
        int[ ] bit = {8 , 4 , 2 ,1};
        for(int i=0;i<4 ;i++){
            if(answer.charAt(i) == 'N'){
                ans += bit[i];
            }
        }

        return ans + 1;
    }
}
