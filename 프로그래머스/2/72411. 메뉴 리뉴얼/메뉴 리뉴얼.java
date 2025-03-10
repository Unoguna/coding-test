import java.util.*;

class Solution {
    
    void combination(HashMap<String, Integer> map, String string, int course_size, String key, int startIdx){
        
        if(key.length() == course_size){
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        if(startIdx >= string.length()) return;
        
        for(int i = startIdx; i<string.length(); i++){
            combination(map, string, course_size, key + string.charAt(i), i+1);
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        
        List<String> answerList = new ArrayList<>();
        
        for(int course_size : course){
            HashMap<String, Integer> map = new HashMap<>();    
            
            for(String str : orders){
                
                String[] s = new String[str.length()];
                for(int i=0; i<str.length(); i++){
                    s[i] = "" + str.charAt(i);
                }
                Arrays.sort(s);
                String string="";
                for(int i=0; i<s.length; i++){
                    string += s[i];
                }
                
                if(string.length() >= course_size){
                    combination(map, string, course_size, "", 0);
                }
            }
            
            int max = 0;
            for(String key : map.keySet()){
                max = max > map.get(key) ? max : map.get(key);
            }
            for(String key : map.keySet()){
                if(map.get(key) == max && max > 1) {
                    answerList.add(key);
                    //System.out.println(key + " " + max);
                }
            }
            
        }
        
        String[] answer = new String[answerList.size()];
        for(int i=0; i<answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        Arrays.sort(answer);
        
        return answer;
    }
}