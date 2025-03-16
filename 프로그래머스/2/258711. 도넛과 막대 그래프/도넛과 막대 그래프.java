import java.util.*;

class Solution {
    
    class Edge{
        int num;
        Queue<Integer> q;
        boolean check;
        
        Edge(int num){
            this.num = num;
            q = new LinkedList<Integer>();
            check = false;
        }
        
    }
    
    int DFS(int idx, Edge[] curr){
        
        if(curr[idx].q.size() == 2) return 3;
        
        if(curr[idx].check == true){
            if(curr[idx].q.isEmpty()) return 1;
            else return 3;
        }
        else{
            if(curr[idx].q.isEmpty()) return 2;
            curr[idx].check = true;
            return DFS(curr[idx].q.poll(), curr);
        }
    }
    
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        int N = 1000000;
        // for(int[] edge : edges){
        //     int start = edge[0];
        //     int end = edge[1];
        //     N = N > start ? N : start;
        //     N = N > end ? N : end;
        // }
        
        int[] findStart = new int[N+1];
        Edge[] curr = new Edge[N+1];
        for(int i=0; i<N+1; i++) {
            curr[i] = new Edge(i);
        }
        
        for(int[] edge : edges){
            int start = edge[0];
            int end = edge[1];
            
            curr[start].q.add(end);
            findStart[end] = 1;
            if(findStart[start] == 0) findStart[start] = -1;
        }
        for(int i=1; i<N+1; i++){
            if(findStart[i] == -1) {
                if(curr[i].q.size()>=2){
                    answer[0] = i;
                    break;
                }
            }
        }
        
        while(!curr[answer[0]].q.isEmpty()){
            int idx = curr[answer[0]].q.poll();
            int type = DFS(idx, curr);
            answer[type]++;
        }
        
        
        return answer;
    }
}