import java.util.*;

class Solution {
    
    public class Node{
        List<Node> edge;
        int num;
        int distance;
        
        Node(int num){
            this.num = num;
            this.distance = 0;
            this.edge = new ArrayList<>();
        }
        
        void add(Node node){
            edge.add(node);
        }
    }

    public int solution(int n, int[][] edge) {
        int answer = 1;
        
        List<Node> list = new ArrayList<>();
        int[] visited = new int[n+1];
        
        for(int i=0; i<=n; i++){
            Node node = new Node(i);
            list.add(node);
        }
        
        for(int[] e : edge){
            Node node1 = list.get(e[0]);
            Node node2 = list.get(e[1]);
            node1.add(node2);
            node2.add(node1);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(1);
        visited[1] = 1;
        int max = 0;
        while(!q.isEmpty()){
            int idx = q.poll();
            Node node = list.get(idx);
            for(Node e : node.edge){
                if(visited[e.num] == 0){
                    visited[e.num] = 1;
                    e.distance = node.distance+1;
                    q.add(e.num);
                    
                    if(max < e.distance){
                        max = e.distance;
                        answer = 1;
                    }
                    else if(max == e.distance) answer++;
                }
            } 
        }
        
        
        
        return answer;
    }
}