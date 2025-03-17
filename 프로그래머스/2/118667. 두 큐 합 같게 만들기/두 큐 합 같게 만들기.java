class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        
        long sum1 = 0;
        long sum2 = 0;
        
        int idx1 = 0;
        int idx2 = queue1.length;
        
        int count = 0;
        
        int[] queue = new int[2 * queue1.length];
        
        for(int i=0; i<queue1.length; i++){
            sum1 += Long.valueOf(queue1[i]);
            sum2 += Long.valueOf(queue2[i]);
            queue[i] = queue1[i];
            queue[queue1.length + i] = queue2[i];
        }
        
        while(sum1 != sum2 && count < 2 * queue.length){
            
            if(idx2 == queue.length) idx2 = 0;
            if(idx1 == queue.length) idx1 = 0;
            
            if(sum1 > sum2){
                sum1 -= Long.valueOf(queue[idx1]);
                sum2 += Long.valueOf(queue[idx1]);
                idx1++;
            }
            else{
                sum2 -= Long.valueOf(queue[idx2]);
                sum1 += Long.valueOf(queue[idx2]);
                idx2++;
            }
            count++;
        }
        
        if(sum1 == sum2) answer = count;
        
        return answer;
    }
}