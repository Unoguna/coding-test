class Solution {
    
    int calc(int number, int limit, int power){
        int returnVal = 1;
        
        int[] arr = new int[100001];
        int arr_idx = 0;
        
        int a = 2;
        while(number != 1){
            if(number % a == 0) {
                number /= a;
                arr[arr_idx]++;
            }
            else {
                a++;
                arr_idx++;
            }
        }
        
        for(int i=0; i<=arr_idx; i++){
            returnVal *= arr[i]+1;
        }
        
        if(returnVal > limit)
            returnVal = power;
        
        return returnVal;
    }
    
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i=1; i<=number; i++){
            answer += calc(i, limit, power);
        }
        
        return answer;
    }
}