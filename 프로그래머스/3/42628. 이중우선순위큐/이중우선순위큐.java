import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        
        for(int i=0; i<operations.length; i++){
            char op = operations[i].charAt(0);
            int num = Integer.parseInt(operations[i].substring(2));
            
            if(op == 'I'){
                minHeap.add(num);
                maxHeap.add(num);
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            else if(num == 1 && !maxHeap.isEmpty()){
                while(!maxHeap.isEmpty() && map.get(maxHeap.peek()) == 0) //이미 없어짐
                    maxHeap.poll();
                if(!maxHeap.isEmpty()){
                    map.put(maxHeap.peek(), map.get(maxHeap.peek()) - 1);
                    maxHeap.poll();
                }
            }
            else if(!minHeap.isEmpty()){
                while(!minHeap.isEmpty() && map.get(minHeap.peek()) == 0) //이미 없어짐
                    minHeap.poll();
                if(!minHeap.isEmpty()){
                    map.put(minHeap.peek(), map.get(minHeap.peek()) - 1);
                    minHeap.poll();
                }
            }   
        }
        while(!maxHeap.isEmpty() && map.get(maxHeap.peek()) == 0) //이미 없어짐
            maxHeap.poll();
        while(!minHeap.isEmpty() && map.get(minHeap.peek()) == 0) //이미 없어짐
            minHeap.poll();
        
        
        if(!maxHeap.isEmpty()){
            answer[0] = maxHeap.peek();
        }
        
        if(!minHeap.isEmpty()){
            answer[1] = minHeap.peek();
        }
        
        return answer;
    }
}