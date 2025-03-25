import java.util.*;

class Solution {
    
    int max = 0;
    
    class Node{
        int type;
        int idx;
        List<Integer> child;
        
        Node(int type, int idx){
            this.type = type;
            this.idx = idx;
            child = new ArrayList<>();
        }
        
        void add(int child_idx){
            child.add(child_idx);
        }
    }
    
    void DFS(Node[] node, int idx, Queue q, int sheep, int wolf){
        
        if(node[idx].type == 0) sheep++;
        else wolf++;
        
        max = max > sheep ? max : sheep;
        if(wolf >= sheep){
            return;
        }
        
        Queue<Integer> nextQ = new LinkedList<>(q);
        for(int i : node[idx].child){
            //여기도 재귀써서 양 노드를 미리 확인하면 절약 가능할듯
            nextQ.add(i);
        }
        
        int size = nextQ.size();
        for(int i=0; i<size; i++){
            int nextIdx = nextQ.poll();
            DFS(node, nextIdx, nextQ, sheep, wolf);
            nextQ.add(nextIdx);
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        Node[] node = new Node[info.length];
        for(int i=0; i<info.length; i++){
            node[i] = new Node(info[i], i);
        }
        for(int[] edge : edges){
            node[edge[0]].add(edge[1]);
        }
        Queue<Integer> q = new LinkedList<>();
        DFS(node, 0, q, 0, 0);
        return max;
    }
}