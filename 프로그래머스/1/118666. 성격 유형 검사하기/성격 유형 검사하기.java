import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<survey.length; i++){
            String s = "";
            int choice = choices[i];
            choice -= 4;
            if(choice < 0){
                s += survey[i].charAt(0);
                map.put(s,map.getOrDefault(s,0) - choice);
            }
            else if(choice > 0){
                s += survey[i].charAt(1);
                map.put(s,map.getOrDefault(s,0) + choice);
            }
        }
        
        if(map.getOrDefault("R", 0) >= map.getOrDefault("T", 0)) answer += "R";
        else answer += "T";
        if(map.getOrDefault("C", 0) >= map.getOrDefault("F", 0)) answer += "C";
        else answer += "F";
        if(map.getOrDefault("J", 0) >= map.getOrDefault("M", 0)) answer += "J";
        else answer += "M";
        if(map.getOrDefault("A", 0) >= map.getOrDefault("N", 0)) answer += "A";
        else answer += "N";
        
        return answer;
    }
}