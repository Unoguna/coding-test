import java.util.*;

class Solution {
    
    int convert(String string){
        int time;
        String[] str = string.split(":");
        int mm = Integer.parseInt(str[0]);
        int ss = Integer.parseInt(str[1]);
        
        
        time = mm * 60 + ss;

        return time;
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int videoLen = convert(video_len);
        int currTime = convert(pos);
        int opStart = convert(op_start);
        int opEnd = convert(op_end);
        
        for(String command : commands){
            
            if(currTime < 0) currTime = 0;
            if(currTime > videoLen) currTime = videoLen;
            if(currTime >= opStart && currTime <= opEnd) currTime = opEnd;
            
            if(command.equals("next")){
                currTime += 10;
            }
            else if(command.equals("prev")){
                currTime -= 10;
            }
        }
        
        if(currTime < 0) currTime = 0;
        if(currTime > videoLen) currTime = videoLen;
        if(currTime >= opStart && currTime <= opEnd) currTime = opEnd;
        
        String mm = Integer.toString(currTime/60);
        String ss = Integer.toString(currTime%60);
        
        if(mm.length() == 1) answer += "0" + mm;
        else answer += mm;
        answer += ":";
        if(ss.length() == 1) answer += "0" + ss;
        else answer += ss;
        
        return answer;
    }
}