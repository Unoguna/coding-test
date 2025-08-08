import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        Stack<Integer>[] s = new Stack[board[0].length];
        for (int i = 0; i < board[0].length; i++) {
            s[i] = new Stack<>();
        }
        
        for(int i = board.length-1; i>=0 ;i--){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] != 0)
                    s[j].push(board[i][j]);
            }
        }
        
        for(int move : moves){
            int idx = move - 1;
            int doll = 0;
            if(!s[idx].isEmpty())
                doll = s[idx].pop();
            else continue;
            
            if(!stack.isEmpty()){
                if(stack.peek() == doll){
                    stack.pop();
                    answer+=2;
                }
                else{
                    stack.push(doll);
                }
            }
            else
                stack.push(doll);
        }
        
        return answer;
    }
}