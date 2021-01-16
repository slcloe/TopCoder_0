package ch5;

public class InterestingDigits {
    public int[] digits(int base){
        int[] sol = new int[1000];
        int sol_idx = 0;
        for(int i=2;i<base;i++)
        {
            if((base-1) % i == 0)
                sol[sol_idx++] = i;
        }

        return sol;
    }
}
