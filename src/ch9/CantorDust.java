package ch9;

public class CantorDust {
    public String getstring(int T){
        if(T == 0) return "X";

        String c = getstring(T-1);
        String s = "";
        for(int i=0;i<c.length();i++) s+= " ";
        return c + s + c;
    }
    // ex) time = 2
    // 1 0 1, 0 0 0, 1 0 1 -> 세로도 같은 무늬이기때문에 한 행이 모두 흰색인 줄도 어디인지 알수 있다

    public int occurrencesNumber(String[] pattern, int time){
        int M = pattern.length, N = pattern[0].length(); // pattern 의 가로 세로 길이
        boolean[] a = new boolean[M], b = new boolean[N]; // pattern 의 각 행렬의 X 포함 여부
        String C = getstring(time); // 프랙탈 1행
        int L = C.length(); // 프랙탈의 길이
        int x, y ,k;
        int p =0, q =0;
        boolean flag = false;

        for(x = 0;x <M; x++)
            for(y =0;y<N;y++)
                if(pattern[x].charAt(y) == 'X')
                    a[x] = b[y] = flag = true;
        // flag == true : pattern 에 X 존재 || false: pattern 에 X 존재 X

        for(x = 0;x <M; x++)
            for(y =0;y<N;y++)
                if((pattern[x].charAt(y) == 'X') != (a[x] && b[y]))
                    return 0;
        //pattern 001 010 000 -> 모순 // 이때 a, b 배열은 'FTT' 로 저장 -> 001 검사할때 return 0 으로 감.

        //가로의 일치수 확인
        for(k = 0; k+ M <= L; k++){
            for(x =0;x< M;x++)
                if((C.charAt(k+x) == 'X')!= a[x]) break;
            if(x == M) ++p; // 중간에 break 가 걸렸다면 이 if 문은 실행 X 됨
        }

        for(k = 0; k+ N <= L; k++){
            for(y =0;y< N;y++)
                if((C.charAt(k+y) == 'X')!= b[y]) break;
            if(y == N) ++q;
        }
        if(flag) return (p*q);
        else return (p *(L - N+1) + (L - M+1) * q - p *q); // 가로  + 세로 - (가로 * 세로 겹친거 뺌)



    }

}


