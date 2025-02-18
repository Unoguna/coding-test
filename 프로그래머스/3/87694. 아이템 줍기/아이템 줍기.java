import java.util.*;

class Solution {
    public int[][] move = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    // 위 아래 오른쪽 왼쪽
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
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        int[][] map = new int[102][102];
        Queue<State> q = new LinkedList<>();
        
        for(int k=0; k<rectangle.length; k++){
            int start_x = 2 * rectangle[k][0];
            int start_y = 2 * rectangle[k][1];
            int end_x = 2 * rectangle[k][2];
            int end_y = 2 * rectangle[k][3];
            
            for(int i=start_x; i<=end_x; i++){
                for(int j=start_y; j<=end_y; j++){
                    if(i == start_x || i == end_x || j == start_y || j == end_y){
                        if(map[j][i] == 0) map[j][i] = 2;   //가장자리 : 2
                    }
                    else{
                        map[j][i] = 1;  //내부 : 1
                    }
                }
            } 
        }
        
        q.add(new State(2 * characterY, 2 * characterX, 0));
        
        while(!q.isEmpty()){
            State curr = q.poll();
            if(curr.y == 2 * itemY && curr.x == 2 * itemX){
                return curr.count/2;
            }
            
            for(int i=0; i<4; i++){
                int next_y = curr.y + move[i][0];
                int next_x = curr.x + move[i][1];
                if(next_y>=0 && next_y<=101 && next_x>=0 && next_x<=101 && map[next_y][next_x] == 2){
                    map[next_y][next_x] = 0;
                    q.add(new State(next_y, next_x, curr.count+1));
                }
            }
            
        }
        
        return answer;
    }
}