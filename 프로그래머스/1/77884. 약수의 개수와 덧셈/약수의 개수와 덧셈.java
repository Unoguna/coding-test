class Solution {
    
    int calc(int num){
        
        int output = 1;
        
        
        for(int i=2; i<=num; i++){
            int count = 0;
            while(true){
                if(num % i != 0){
                    output *= count + 1;
                    break;
                } 
                
                num /= i;
                count++;
            }
        }
        
        return output;
    }
    
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left; i<=right; i++){
            if(calc(i) %2 == 0){
                answer += i;
            }
            else{
                answer -= i;
            }
        }
        
        return answer;
    }
}