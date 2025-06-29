import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        Map<Character, Integer> map = new HashMap<>();
        
        char[] c = new char[s.length()];
        
        for(int i=0; i<s.length(); i++){
            c[i] = s.charAt(i);
        }
        
        for(int i=0; i<skip.length(); i++){
            map.put(skip.charAt(i), 0);
        }
        
        for(int i=0; i<index; i++){
            for(int j=0; j<s.length(); j++){
                c[j]++;
                if(c[j]>'z') c[j] = 'a';
                while(map.containsKey(c[j])){
                    c[j]++;
                    if(c[j]>'z') c[j] = 'a';
                }
            }
        }
        
        for(int i=0; i<c.length; i++){
            answer += Character.toString(c[i]);
        }
        
        return answer;
    }
}