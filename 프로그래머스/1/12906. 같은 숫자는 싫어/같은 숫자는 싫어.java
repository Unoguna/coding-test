import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Stack<Integer> stack = new Stack<>();
        
        for(int num : arr){            
            if(stack.empty() || stack.peek() != num)
                stack.push(num);
        }
        
        int[] answer = new int[stack.size()];
        for(int i=0; i<answer.length; i++){
            answer[answer.length - i - 1] = stack.peek();
            stack.pop();
        }
        
        return answer;
    }
}