import java.util.*;
    
class Solution {
    public int[][] move = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    //아래 위 오른쪽 왼쪽
    
    public class State{
        public int y;
        public int x;
        public int count;
        
        State(int y, int x, int count){
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
    
    
    
    
    public int solution(int[][] maps) {
        
        Queue<State> q = new LinkedList<>();
        q.add(new State(0,0,1));
        maps[0][0] = 0;
        
        int max_y = maps.length;
        int max_x = maps[0].length;
        
        while(!q.isEmpty()){
            State curr = q.poll();
            if(curr.y == max_y - 1 && curr.x == max_x - 1)
                return curr.count;
            
            for(int i=0; i<4; i++){
                int next_y = curr.y + move[i][0];
                int next_x = curr.x + move[i][1];
                if(next_y >= 0 && next_y <max_y && next_x >= 0 && next_x < max_x && maps[next_y][next_x] != 0){
                    maps[next_y][next_x] = 0;
                    q.add(new State(next_y, next_x, curr.count + 1));
                }
            }
        }
        
        return -1;
    }
}