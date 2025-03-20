import java.util.*;

class Solution {
    
    class Road{
        int num;
        int cost;
        
        Road(int num, int cost){
            this.num = num;
            this.cost = cost;
        }
    }
    
    class Node{
        int num;
        List<Road> list;
        
        Node(int num){
            this.num = num;
            list = new ArrayList<>();
        }
        
        void add(int num, int cost){
            list.add(new Road(num, cost));
        }
    }
    
    boolean checkSummit(int idx, int[] summits){
        for(int s : summits){
            if(idx == s) return true;
        }
        return false;
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];
        
        ArrayList<Node> node = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] arr = new int[n+1];
        for(int i=0; i<arr.length; i++) arr[i] = Integer.MAX_VALUE;
        
        for(int i=0; i<n+1; i++){
            node.add(new Node(i));
        }
        for(int [] path : paths){
            int startIdx = path[0];
            int endIdx = path[1];
            int cost = path[2];
            node.get(startIdx).add(endIdx, cost);
            node.get(endIdx).add(startIdx, cost);
        }
        for(int gate : gates){
            queue.add(gate);
            arr[gate] = 0;
        }
        
        while(!queue.isEmpty()){
            int currIdx = queue.poll();
            Node currNode = node.get(currIdx);
            for(Road r : currNode.list){
                int max = r.cost > arr[currIdx] ? r.cost : arr[currIdx];
                if(arr[r.num] > max){
                    arr[r.num] = max;
                    if(!checkSummit(r.num, summits)) queue.add(r.num);
                }
            }
        }
        
        // for(int num : arr){
        //     System.out.println(num);
        // }
        
        answer[1] = Integer.MAX_VALUE;
        Arrays.sort(summits);
        for(int s : summits){
            if(arr[s] < answer[1]){
                answer[0] = s;
                answer[1] = arr[s];
            }
        }
        
        return answer;
    }
}