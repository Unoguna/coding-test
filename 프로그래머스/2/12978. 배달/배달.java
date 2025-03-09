import java.io.*;
import java.util.*;

class Solution {
    
    class Node{
        int idx;
        int cost;
        
        Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        ArrayList<Node>[] list = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for(int[] r : road){
            int num1 = r[0];
            int num2 = r[1];
            int cost = r[2];
            
            list[num1].add(new Node(num2, cost));
            list[num2].add(new Node(num1, cost));
        }
        
        
        PriorityQueue<Node> pQ = new PriorityQueue<>((o1,o2) -> o1.cost - o2.cost);
        dist[1] = 0;
        for(Node n : list[1]){
            pQ.add(n);
        }
        
        while(!pQ.isEmpty()){
            Node node = pQ.poll();
            if(node.cost < dist[node.idx]){
                dist[node.idx] = node.cost;
                for(Node n : list[node.idx]){
                    pQ.add(new Node(n.idx, n.cost + node.cost));
                }
            }
        }
        
        for(int d : dist){
            if(K >= d) answer++;
        }
        

        return answer;
    }
}