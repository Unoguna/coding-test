class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(true){
            if(n < a) break;
            
            int add = (n/a) * b;
            n = n%a + add;
            answer += add;
            
        }
        
        return answer;
    }
}