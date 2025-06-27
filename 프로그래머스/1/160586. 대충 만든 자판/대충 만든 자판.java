import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String key : keymap){
            for(int i=0; i<key.length(); i++){
                String str = Character.toString(key.charAt(i));
                
                if(map.containsKey(str)){
                    if(i+1 < map.get(str)) map.put(str, i+1);
                }
                else{
                    map.put(str, i+1);
                }
            }
        }
        
        for(int i=0; i<targets.length; i++){
            int result = 0;
            for(int j=0; j<targets[i].length(); j++){
                String str = Character.toString(targets[i].charAt(j));
                if(!map.containsKey(str)){
                    result = -1;
                    break;
                }
                result += map.get(str);
            }
            answer[i] = result;
        }
        
        return answer;
    }
}