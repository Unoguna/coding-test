import java.util.*;

class Solution {
    
    public class Bridge{
        int idx1;
        int idx2;
        int cost;
        
        Bridge(int idx1, int idx2, int cost){
            this.idx1 = idx1;
            this.idx2 = idx2;
            this.cost = cost;
        }
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        int[] check = new int[n];
        
        Bridge[] bridge = new Bridge[costs.length];
        
        for(int i=0; i<costs.length; i++){
            bridge[i] = new Bridge(costs[i][0], costs[i][1], costs[i][2]);
        }
        
        Arrays.sort(bridge, new Comparator<Bridge> () {
           @Override
            public int compare(Bridge bridge1, Bridge bridge2) {
                if(bridge1.cost > bridge2.cost) return 1;
                else return -1;
            }
        });
        
        check[bridge[0].idx1] = 1;
        check[bridge[0].idx2] = 1;
        answer+=bridge[0].cost;
        
        while(true){
            int min_cost = 10000000;
            int min_idx1 = -1;
            int min_idx2 = -1;
            for(int i=0; i<bridge.length; i++){
                int idx1 = bridge[i].idx1;
                int idx2 = bridge[i].idx2;
                if((check[idx1] == 1 && check[idx2] == 0) || (check[idx1] == 0 && check[idx2] == 1)){
                    if(min_cost > bridge[i].cost){
                        min_idx1 = idx1;
                        min_idx2 = idx2;
                        min_cost = bridge[i].cost;
                    }
                }
            }
            if(min_idx1 == -1) break;
            
            answer+=min_cost;
            check[min_idx1] = 1;
            check[min_idx2] = 1;
        }
            
            
        
        return answer;
    }
}