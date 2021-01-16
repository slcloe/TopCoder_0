package ch7;

public class CorporationSalary {
    public long totalSalary(String[] relations){
        int n = relations.length;
        int[] salary = new int[n];
        int sol = 0;

        salary_cal(0, relations, salary);

        for(int i=0;i<salary.length;i++)
            sol += salary[i];
        return sol;
    }

    void salary_cal(int n, String[] relations, int[] solution){
        if(relations.length <= n ) return;
        if(solution[n] > 0) return;

        for(int i=0;i<solution.length;i++){
            if(relations[n].charAt(i) == 'Y' && i!= n){
                if(solution[i] <= 0)
                    salary_cal(i, relations, solution);
            solution[n] += solution[i];
            }
        }
        if(solution[n] == 0) solution[n] = 1;
        salary_cal(n+1, relations, solution);
    }

    long getSalary(int i, String[] relations, int[] salary){
        if(salary[i] == 0){
            long salary0 = 0;
            String relation = relations[i];
            for(int j=0;j<relation.length(); j++){
                if(relation.charAt(j) == 'Y')
                    salary0 += getSalary(j, relations, salary);
            }
            if ( salary0 == 0) salary0 = 1;
            salary[i] = (int)salary0;
        }
        return salary[i];
    }
}
