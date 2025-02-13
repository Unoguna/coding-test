import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] num = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            num[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(num, new Comparator<String>(){
            @Override
            public int compare(String str1, String str2){
                
                String tmp1 = new String((str1+str1+str1));
                String tmp2 = new String((str2+str2+str2));
                
                return tmp2.compareTo(tmp1);
            }
        });
        
        for(int i=0; i<num.length; i++)
            answer += num[i];
        
        if(answer.charAt(0) == '0')
            return "0";
        
        return answer;
    }
}