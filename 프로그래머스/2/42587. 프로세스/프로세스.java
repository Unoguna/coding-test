import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i=0; i<priorities.length; i++){
            q.add(i);
        }
        
        while(true){
            int num = priorities[q.peek()];
            int check = 0;
            
            for(int idx : q){
                if(num < priorities[idx]){
                    q.add(q.poll());
                    check = 1;
                    break;
                }   
            }
            
            if(check == 0){
                if(q.peek() == location){
                    return ++answer;
                }
                else{
                    q.poll();
                    answer++;
                }
            }
            
        }
    }
}