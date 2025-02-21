import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int num = 0;
        int min_corr = 0;
        
        
        for(int lotto : lottos){
            if(lotto == 0) num++;
            else{
                for(int nums : win_nums){
                    if(lotto == nums){
                        min_corr++;
                        break;
                    }
                }
            }
        }
        
        int max_corr = min_corr + num;
        if(max_corr > 1){
            answer[0] = 7 - max_corr;
        }
        else{
            answer[0] = 6;
        }
        
        if(min_corr > 1){
            answer[1] = 7 - min_corr;
        }
        else{
            answer[1] = 6;
        }
        
        return answer;
    }
}