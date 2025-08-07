class Solution {
    
    int answer = 0;
    
    void recur(int[] number, int depth, int start_idx, int sum){
        if(depth == 3){
            if(sum == 0) answer++;
            return;
        }
        
        for(int i = start_idx; i<number.length; i++){
            recur(number, depth+1, i+1, sum + number[i]);
        }
        
        
    }
    
    public int solution(int[] number) {
        recur(number, 0, 0, 0);
        
        return answer;
    }
}