import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String str = "";
        
        String[] number_str = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        int[] number_length = {4,3,3,5,4,4,3,5,5,4}; 
        
        int idx = 0;
        while(idx < s.length()){
            if(s.charAt(idx) >= '0' && s.charAt(idx) <= '9'){
                str += s.charAt(idx);
                idx++;
            }
            else{
                for(int i=0; i<10; i++){
                    if(idx + number_length[i] <= s.length()&& number_str[i].compareTo(s.substring(idx, idx + number_length[i])) == 0){
                        
                        str += Integer.toString(i);
                        idx += number_length[i];
                        break;
                    }
                }
            }
        }
        
        answer = Integer.parseInt(str);
        
        return answer;
    }
}