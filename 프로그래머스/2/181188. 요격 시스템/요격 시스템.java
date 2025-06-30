import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1, o2) -> {
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        
        int front = 0;
        int back = 100000000;
       
        for(int[] t : targets){
            if(t[0] >= back){
                answer++;
                front = t[0];
                back = t[1];
            } 
            else if(t[1] < back) back = t[1];   
        }
        return answer+1;
    }
}