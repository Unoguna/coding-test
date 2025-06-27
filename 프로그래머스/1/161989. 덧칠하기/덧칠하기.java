class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int curr_idx = 0;
        
        for(int idx : section){
            if(curr_idx <= idx){
                curr_idx = idx + m;
                answer++;
            }          
        }
        
        return answer;
    }
}