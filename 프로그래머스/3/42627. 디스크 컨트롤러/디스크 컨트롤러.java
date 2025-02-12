import java.util.*;

class Solution {
    public static class Work{
        private int start;
        private int cost;
        
        public Work(int start, int cost){
            this.start = start;
            this.cost = cost;
        }
        
        public int getStart(){
            return start;
        }
        public int getCost(){
            return cost;
        }
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Work> pQ = new PriorityQueue<>(new Comparator<Work>(){
            @Override
            public int compare(Work w1, Work w2){
                if(w1.cost < w2.cost) return -1;
                else if(w1.cost > w2.cost) return 1;
                else{
                    if(w1.start < w2.start) return -1;
                    else return 1;
                }
            }
        });   
        PriorityQueue<Work> tQ = new PriorityQueue<>(new Comparator<Work>(){
            @Override
            public int compare(Work w1, Work w2){
                if(w1.start < w2.start) return -1;
                else return 1;
            }
        }); 
        
        for(int i=0; i<jobs.length; i++){
            Work w = new Work(jobs[i][0], jobs[i][1]);
            tQ.add(w);
        }
        
        int time = 0;
        
        while(!tQ.isEmpty() || !pQ.isEmpty()){  
            if(pQ.isEmpty()){
                while(!tQ.isEmpty() && time < tQ.peek().start){
                    time++;
                }
            }
            
            while(!tQ.isEmpty() && time >= tQ.peek().start){
                pQ.add(tQ.poll());
            }
            
            time += pQ.peek().cost;
            answer += time - pQ.peek().start;
            pQ.poll();
        }
        answer /= jobs.length;
        return answer;
    }
}