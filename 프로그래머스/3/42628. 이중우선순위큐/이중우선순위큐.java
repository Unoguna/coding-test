import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        
        for(int i=0; i<operations.length; i++){
            char op = operations[i].charAt(0);
            int num = Integer.parseInt(operations[i].substring(2));
            
            if(op == 'I'){
                minHeap.add(num);
                maxHeap.add(num);
            }
            else if(num == 1 && !maxHeap.isEmpty()){
                minHeap.remove(maxHeap.poll());
            }
            else if(!minHeap.isEmpty()){
                maxHeap.remove(minHeap.poll());
            }   
        }
        
        
        if(!maxHeap.isEmpty()){
            answer[0] = maxHeap.peek();
        }
        
        if(!minHeap.isEmpty()){
            answer[1] = minHeap.peek();
        }
        
        return answer;
    }
}