class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        
        long total_price = 0;
        
        for(int i=1; i<=count; i++){
            total_price += price * i;
        }
        
        answer = total_price - (long)money;
        answer = Math.max(answer, 0);
        
        return answer;
    }
}