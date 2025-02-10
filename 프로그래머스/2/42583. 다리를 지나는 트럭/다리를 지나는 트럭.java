import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> moving_truck_time = new LinkedList<>();
        Queue<Integer> moving_truck_weight = new LinkedList<>();
        int curr_weight = 0;
        
        int truck_idx = 0;
        int finish_num = 0;
        
        while(true){
            answer++;
 
            if(!moving_truck_time.isEmpty() && answer == moving_truck_time.peek()){
                moving_truck_time.poll();
                curr_weight -= moving_truck_weight.poll();
                finish_num++;
            }
            
            if(truck_idx != truck_weights.length && curr_weight + truck_weights[truck_idx] <= weight){
                
                moving_truck_time.add(answer + bridge_length);
                moving_truck_weight.add(truck_weights[truck_idx]);
                curr_weight += truck_weights[truck_idx];
                
                truck_idx++;
            }
            
            if(finish_num == truck_weights.length)
                break;
            
        }
        
        return answer;
    }
}