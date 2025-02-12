import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        
        for(int num : scoville){
            pQ.add(num);
        } 
        
        while(true){
            int scov1 = pQ.poll();
            if(scov1 >= K)
                return answer;
            if(pQ.size() == 0)
                return -1;
            int scov2 = pQ.poll();
            

            
            answer++;
            pQ.add(scov1 + scov2 * 2);
        }
    }
}