package ch5;

public class ThePalindrome {
    public int find(String s){
        int sol_len = s.length() * 2 - 1;
        int front , rear ;
        for(int i=1;i<s.length();i++) {
            for(front = s.length()-1-i, rear= s.length()-1; front < rear ; front++, rear--){
                if(s.charAt(front) != s.charAt(rear))
                    break;
            }
            if(front>=rear){
                sol_len = s.length() * 2 - (i+1);
            }
        }
        return sol_len ;
    }
}