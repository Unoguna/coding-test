class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = schedules.length;
        int satIdx = 6 - startday;
        int sunIdx = 7 - startday; 
        
        if(satIdx == -1) satIdx = 6;
        
        int perIdx = 0;
        for(int schedule : schedules){
            
            int limitTime = schedule + 10;
            if(limitTime % 100 >= 60){
                limitTime += 40;
            }
            
            for(int i=0; i<7; i++){
                if(i != satIdx && i != sunIdx){
                    if(timelogs[perIdx][i] > limitTime){
                        answer--;
                        break;
                    }
                }
            }
            
            perIdx++;
        }
        
        return answer;
    }
}