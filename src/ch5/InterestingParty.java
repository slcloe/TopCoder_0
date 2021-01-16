package ch5;
import java.util.*;

public class InterestingParty {
    public int bestInvitation(String[] first, String[] second){
        int cnt = 0, max = 0;

        for(int i=0;i< first.length; i++)
        {
            cnt = 0;
            for(int j=0;j<first.length; j++)
            {
                if( first[i].equals(first[j]) || first[i].equals(second[j]))
                    cnt++;
            }

            if( cnt > max)
                max = cnt;
        }

        for(int i=0;i< first.length; i++)
        {
            cnt = 0;
            for(int j=0;j<first.length; j++)
            {
                if( second[i].equals(first[j]) || second[i].equals(second[j]))
                    cnt++;
            }

            if( cnt > max)
                max = cnt;
        }
        return max;
    }
}


class InterestingParty2{
    public int bestInvitation(String[] first, String[] second ){
        HashMap<String, Integer> dic = new HashMap<String, Integer>();

        for(int i=0;i< first.length; i++){
            dic.put(first[i], 0);
            dic.put(second[i], 0);
        }

        for(int i=0;i<first.length;i++){
            dic.put(first[i], dic.get(first[i])+1);
            dic.put(second[i], dic.get(second[i])+ 1);
        }

        int ans = 0;
        for(String key : dic.keySet() ){
            ans = Math.max(ans , dic.get(key));
        }

        return ans;
    }
}
