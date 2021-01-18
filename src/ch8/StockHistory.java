package ch8;

public class StockHistory {
    // 투자한 금액은 마지막에 팔아야함.
    public int maximumEarnings(int initialInvestment, int monthlyContribution, String[] stockPrices){
        int money = initialInvestment;
        int month = stockPrices.length;
        int corp = stockPrices[0].split(" ").length;     //회사갯수 저장변수 / split("str") str 문자 기준으로 문자열을 나눠서 String 배열을 리턴

        int[][] prices = new int[month][corp];
        double max = 0, profit = 0;
        double[] proportion = new double[month -1]; // 최대 증가율 저장하기 위해
        boolean[] buy = new boolean[month-1];

        // string 으로 저장되어있는 회사별 금액을 int 형 배열로 저장하는 과정
        for(int i=0;i<month;i++){
            String[] s = stockPrices[i].split(" ");

            for(int j=0;j<corp;j++)
                prices[i][j] = Integer.valueOf(s[j]);
        }


        for(int i=month-2; i >= 0;i--){
            for(int j=0;j<corp;j++){
                double p = 1.0 * prices[month-1][j] / prices[i][j] -1; // 1.0 은 double 자료형 맞춰주기 위해서
                // -1을 해주는 이유 -> ex) p == 0.9 는 손해 / p == 1.2 는 이익이라 이걸 구분하기 위해
                if (0 < p && max < p) {
                    buy[i] = true;
                    max = p;
                    proportion[i] = p;
                }
            }
        }

        for(int i=0;i<buy.length;i++){
            if(buy[i]){
                profit+= money * proportion[i]; // 있는 돈으로 우선 다 투자하는거 -> 앞에 있는 거일수록 이율이 max 니까
                money = 0;
            }
            money += monthlyContribution;//월급 개념
        }
        return (int)Math.round(profit);
        // Math.round(double) -> 현재 double 에서 제일 가까운 long 값을 반환 --> 그래서 (int) 로 강제형변환 시켜줘야함.
    }
}
