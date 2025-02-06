import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int loop=0; loop<commands.length; loop++){
            int i = commands[loop][0] - 1;
            int j = commands[loop][1] - 1;
            int k = commands[loop][2] - 1;
            
            int[] tmp = new int[j-i+1];
            
            for(int loop2=i; loop2<=j; loop2++){
                tmp[loop2 - i] = array[loop2];
            }
            
            Arrays.sort(tmp);
            

            answer[loop] = tmp[k];
        }
            
        
        
        
        return answer;
    }
}