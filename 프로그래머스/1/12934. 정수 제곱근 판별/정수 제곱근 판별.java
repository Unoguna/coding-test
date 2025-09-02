class Solution {
    public long solution(long n) {
        long answer = 0;
        long num = 1;
        
        while(n >= num * num){
            if(n == num * num) return (num + 1) * (num + 1);
            
            num++;
        }
        
        return -1;
    }
}