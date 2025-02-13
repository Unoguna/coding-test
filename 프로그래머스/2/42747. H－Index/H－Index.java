import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        Arrays.sort(citations);
        
        for(int i=0; i<citations.length; i++){
            int num1 = citations[i];
            int num2 = citations.length - i;
            int min = num1 < num2 ? num1 : num2;
            answer = answer > min ? answer : min;
        }
        
        return answer;
    }
}