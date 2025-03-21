class Solution {
    
    boolean check(int[] diffs, int[] times, long limit, int level){
        long cost = 0;
        
        for(int i=0; i<diffs.length; i++){
            if(diffs[i] > level && i != 0){
                cost += Long.valueOf(times[i] + (diffs[i] - level) * (times[i] + times[i-1]));
            }
            else{
                cost += Long.valueOf(times[i]);
            }
            
            if(limit < cost) return false;
        }
        return true;
    }
    
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int max = 0;
        for(int diff : diffs){
            max = max > diff ? max : diff;
        }
        
        answer = max/2;
        int tmp = answer/2;
        
        while(!(!check(diffs, times, limit, answer-1) && check(diffs, times, limit, answer))){
            if(check(diffs, times, limit, answer)){
                answer -= tmp;
            }
            else answer += tmp;
            
            tmp /= 2;
            if(tmp == 0) tmp = 1;
            
            if(answer == 1) return 1;
        }
        
        
        return answer;
    }
}