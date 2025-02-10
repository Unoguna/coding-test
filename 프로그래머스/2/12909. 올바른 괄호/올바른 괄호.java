class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int num1 = 0;
        int num2 = 0;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                num1++;
            }
            else{
                num2++;
            }
            
            if(num2 > num1)
                return false;
            
        }
        if(num2 != num1)
            return false;

        return answer;
    }
}