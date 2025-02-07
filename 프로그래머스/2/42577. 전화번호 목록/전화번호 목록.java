import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        for(int i=0; i<phone_book.length-1; i++){
            String str1 = new String(phone_book[i]);
            String str2 = new String(phone_book[i+1]);
            
            if(str2.startsWith(str1)){
                return false;
            }
        }
        
        
        
        return answer;
    }
}