class Solution {
    public int solution(String s) {
        int answer = 0;
        char curr = s.charAt(0);
        answer++;
        
        int num1=0;
        int num2=0;
        for(int i=0; i<s.length(); i++){
            if(curr == s.charAt(i)) num1++;
            else num2++;
            
            if(num1 == num2){
                num1=0;
                num2=0;
                if(i+1 < s.length()) {
                    curr = s.charAt(i+1);
                    answer++;
                }
                else break;
            }
        }
        
        return answer;
    }
}