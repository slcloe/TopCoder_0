package ch8;

public class ColorfulBoxesAndBalls {
//    public static void main(String[] args){
//        System.out.println(getMaximum(9 , 1 , -1, -10, 4));
//    }
    public static int getMaximum(int numRed, int numBlue, int onlyRed, int onlyBlue, int bothColors){
        int ans = numRed * onlyRed + numBlue * onlyBlue;
        int only = onlyBlue + onlyRed, both = bothColors * 2;
        if( only < both){
            int min = Math.min(numRed, numBlue);
            ans += (min * (both - only));
        }
        return ans;
    }
}

// onlyRed + onlyBlue < bothColors * 2 -> switch ball
// else : not switch

