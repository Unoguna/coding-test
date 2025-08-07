import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
       Arrays.sort(numbers);
        
        int idx = 0;
        for(int i=0; i<10; i++){
            if(idx >= numbers.length) break;
            
            if(i == numbers[idx]){
                answer += i;
                idx++;
                continue;
            }
            else if(i > numbers[idx]) idx++;
            else continue;
        }
        
        return 45 - answer;
    }
}