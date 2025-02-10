import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        int product_num = 0;
        
        for(int i=0; i<progresses.length; i++){
            int day = (99 - progresses[i]) / speeds[i] + 1;
            if(stack.empty()){
                stack.push(day);
                product_num++;
            }
            else if(stack.peek() >= day){
                product_num++;
            }
            else{
                stack.push(day);
                list.add(product_num);
                product_num = 1;
            }
        }
        list.add(product_num);
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}