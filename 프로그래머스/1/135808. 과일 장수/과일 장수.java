import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int s : score){
            list.add(s);
        }
         Collections.sort(list, Collections.reverseOrder());
        
        int idx = 0;
        while(true){
            if(idx + m - 1 >= list.size()) break;
            
            answer += list.get(idx + m - 1) * m;
            idx += m;
        }
        
        return answer;
    }
}