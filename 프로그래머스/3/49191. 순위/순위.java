import java.util.*;

class Solution {
    
    public class Player{
        int number;
        List<Integer> winIdx;
        List<Integer> loseIdx;
        
        Player(int number){
            this.number = number;
            winIdx = new ArrayList<>();
            loseIdx = new ArrayList<>();
        }
        
        void addWin(int idx){
            winIdx.add(idx);
        }
        void addLose(int idx){
            loseIdx.add(idx);
        }
        
    }
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        List<Player> list = new ArrayList<>();
        
        for(int i=0; i<=n ;i++){
            Player player = new Player(i);
            list.add(player);
        }

        for(int[] result : results){
            int win = result[0];
            int lose = result[1];
            
            Player p1 = list.get(win);
            Player p2 = list.get(lose);
            
            p1.addWin(lose);
            p2.addLose(win);
        }
        

        for(int i=1; i<=n; i++){
            Player p = list.get(i);
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[n+1];
            visited[p.number] = true;
            for(int idx : p.winIdx){
                q.add(idx);
                visited[idx] = true;
            }
            while(!q.isEmpty()){
                int idx = q.poll();
                Player p1 = list.get(idx);
                for(int idx1 : p1.winIdx){
                    if(!visited[idx1]){
                        q.add(idx1);
                        visited[idx1] = true;
                        p.addWin(idx1);
                    }
                }
            }
            
            for(int idx : p.loseIdx){
                q.add(idx);
                visited[idx] = true;
            }
            while(!q.isEmpty()){
                int idx = q.poll();
                Player p1 = list.get(idx);
                for(int idx1 : p1.loseIdx){
                    if(!visited[idx1]){
                        q.add(idx1);
                        visited[idx1] = true;
                        p.addLose(idx1);
                    }
                }
            }
        }
        
        
        
        for(Player p : list){
            if(p.winIdx.size() + p.loseIdx.size() == n-1) {
                answer++;
            }
        }
        
        
        
        return answer;
    }
}