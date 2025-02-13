import java.util.*;

class Solution {
    HashMap<Character, Integer> map = new HashMap<>();
    
    public int recurr(int length){
        if(length == 0)
            return 1;
        
        return 1 + 5 * recurr(length - 1);
    }
    
    public int solution(String word) {
        int answer = 0;
        map.put('A', 0);
        map.put('E', 1);
        map.put('I', 2);
        map.put('O', 3);
        map.put('U', 4);
        
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            int num = map.get(ch);
            
            answer += num * recurr(4 - i) + 1;   
        }
        
        return answer;
    }
}