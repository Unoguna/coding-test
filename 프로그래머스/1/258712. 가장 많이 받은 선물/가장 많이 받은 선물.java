import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[][] matrix = new int[friends.length][friends.length];
        int[] present_score = new int[friends.length];
        int[] curr_present = new int[friends.length];
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<friends.length; i++){
            map.put(friends[i], i);
        }
        
        for(String gift : gifts){
            String[] str = gift.split(" ");
            int sender_idx = map.get(str[0]);
            int reciever_idx = map.get(str[1]);
            matrix[sender_idx][reciever_idx]++;
            present_score[sender_idx]++;
            present_score[reciever_idx]--;
        }
        
        for(int i=0; i<friends.length-1; i++){
            for(int j=i+1; j<friends.length; j++){
                int score = matrix[i][j] - matrix[j][i];
                if(score > 0) curr_present[i]++;
                else if(score < 0) curr_present[j]++;
                else{
                    if(present_score[i] > present_score[j]) curr_present[i]++;
                    else if(present_score[i] < present_score[j]) curr_present[j]++;
                }
            }
        }
        
        for(int p : curr_present){
            answer = Math.max(p, answer);
        }
        
        return answer;
    }
}