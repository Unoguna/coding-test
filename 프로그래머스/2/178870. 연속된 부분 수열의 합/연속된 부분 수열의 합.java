class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = Integer.MAX_VALUE;
        
        int startIdx = 0;
        int endIdx = 0;
        int num = sequence[0];
        
        while(true){
            if(num == k){
                if(endIdx - startIdx < answer[1] - answer[0]){
                    answer[1] = endIdx;
                    answer[0] = startIdx;
                }
                num -= sequence[startIdx++];
            }
            else if(num < k){
                endIdx++;
                if(endIdx >= sequence.length) break;
                num += sequence[endIdx];
            }
            else{
                num -= sequence[startIdx++];
            }
        }
        
        return answer;
    }
}