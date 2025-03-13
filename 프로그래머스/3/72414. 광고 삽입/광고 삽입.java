import java.util.*;

class Solution {
    
    public int convert(String string){
        String[] str = string.split(":");
        int[] time = new int[3];
        
        for(int i=0; i<3; i++){
            time[i] = Integer.parseInt(str[i]);
        }
        
        return time[0] * 3600 + time[1] * 60 + time[2];
    }
    
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int playTime = convert(play_time);
        int advTime = convert(adv_time);
        
        int[] check = new int[360_000];
        
        for(String log : logs){
            String[] str = log.split("-");
            int time1 = convert(str[0]);
            int time2 = convert(str[1]);
            for(int i=time1; i<time2; i++){
                check[i]++;
            }
        }
        
        long max = 0;
        int answerInt = 0;
        long max_sum;
        
        for(int i=0; i<advTime; i++){
            max += Long.valueOf(check[i]);
        }
        max_sum = max;
        
        for(int i=advTime; i<playTime; i++){
            max += Long.valueOf(check[i] - check[i - advTime]);
            
            if(max_sum < max){
                max_sum = max;
                answerInt = i + 1 - advTime;
            }
        }
        
        int[] a = new int[3];
        a[0] = answerInt/3600;
        a[1] = (answerInt%3600)/60;
        a[2] = answerInt%60;
        
        if(a[0]/10 == 0){
            answer += "0";
        }
        answer += Integer.toString(a[0]);
        answer += ":";
        if(a[1]/10 == 0){
            answer += "0";
        }
        answer += Integer.toString(a[1]);
        answer += ":";
        if(a[2]/10 == 0){
            answer += "0";
        }
        answer += Integer.toString(a[2]);
        
        return answer;
    }
}