import java.util.*;

class Solution {
    
    class Stage{
        int idx;
        int total = 0;
        int success = 0;
        float rate;
        Stage(int idx){
            this.idx = idx;
        }
    }
    
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        Stage[] stage = new Stage[N];
        for(int i=0; i<N; i++){
            stage[i] = new Stage(i + 1);
        }
        
        for(int s : stages){
            int idx = s-1;
            if(idx < N)
                stage[idx].total++;
            for(int i=0; i<idx; i++){
                stage[i].total++;
                stage[i].success++;
            }
        }
        
        for(Stage s : stage){
            if(s.total == 0)
                s.rate = 0.0f;
            else
                s.rate = (float) (s.total - s.success) / s.total;
        }
        
        Arrays.sort(stage, (s1, s2) -> {
            if(s1.rate != s2.rate) return Float.compare(s2.rate, s1.rate);
            else return s1.idx - s2.idx;
        });
        
        for(int i=0; i<N; i++){
            answer[i] = stage[i].idx;
        }
        
        return answer;
    }
}