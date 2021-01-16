package ch5;

public class Cryptography {
    public long encrypt(int[] numbers){
        long sol = 1;
        int min= 0, idx = 0;
        min = numbers[0];
        for(int i=0;i< numbers.length; i++){

            if(min < numbers[i]){
                min = numbers[i];
                idx = i;
            }
        }

        numbers[idx] += 1;

        for(int num : numbers){
            sol *= num;
        }

        return sol;
    }
}
