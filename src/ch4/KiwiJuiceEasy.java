package ch4;

public class KiwiJuiceEasy {

    public static int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId){

        for(int i=0;i< fromId.length; i++) {
            int from = fromId[i];
            int to = toId[i];

            if (bottles[from] + bottles[to] <= capacities[to]) {
                bottles[to] = bottles[from] + bottles[to];
                bottles[from] = 0;
            } else {
                bottles[from] = bottles[from] - (capacities[to] - bottles[to]);
                bottles[to] = capacities[to];
            }

        }
        return bottles;
    }
}

