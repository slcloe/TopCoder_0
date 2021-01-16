package ch5;

public class FriendScore {
    public int highestScore(String[] friends){
//        int max = 0;
//
//        for(int i=0;i<friends.length;i++) {
//            int cnt = 0;
//            int n = friends[i].length();
//            char[] solve = new char[n];
//            for(int j=0;j<n; j++){
//                solve[j] = friends[i].charAt(j);
//            }
//            for(int j=0; j<n;j++) {
//                if (solve[j] == 'Y') {
//                    for (int k = 0; k < n; k++) {
//                        if (friends[j].charAt(k) == 'Y' && solve[k] != 'Y')
//                            solve[k] = 'y';
//                    }
//                }
//            }
//            for(int j=0;j<n;j++){
//                if(solve[j] != 'N')
//                    cnt++;
//            }
//
//            max = Math.max(cnt, max);
//        }
//
//        return max;


        int sol = 0;
        int n = friends[0].length();

        for(int i=0;i<n;i++){
            int cnt = 0;

            for(int j=0;j<n;j++){
                if ( i == j ) continue;

                if(friends[i].charAt(j) == 'Y'){
                    cnt++;
                }
                else{
                    for(int k=0;k<n;k++){
                        if(friends[j].charAt(k) == 'Y' && friends[k].charAt(i) == 'Y'){
                            cnt++; break;
                        }
                    }
                }
            }

            sol = Math.max(sol, cnt);
        }
        return sol;
    }
}
