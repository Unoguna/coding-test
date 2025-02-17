import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        int minIdx = 0;
        int maxIdx = people.length - 1;
        
        Arrays.sort(people);
        
        while(minIdx <= maxIdx){
            if(people[minIdx] + people[maxIdx] <= limit){
                answer++;
                minIdx++;
                maxIdx--;
            }
            else{
                answer++;
                maxIdx--;
            }
        }  
        return answer;
    }
}