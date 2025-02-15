class Solution {
    public int solution(String name) {
        int answer = 0;
        int aToz = 'Z' - 'A' + 1;
        for(int i=0; i<name.length(); i++){
            int move = name.charAt(i) - 'A';
            answer += move < aToz - move ? move : aToz - move;     
        }
        
        int move = name.length();
        for(int i=0; i<name.length(); i++){
            int count = 1;
            if(name.charAt(i) != 'A'){
                while(i + count < name.length() && name.charAt(i + count) == 'A') count++;
                
                move = Math.min(move, i + name.length() - count);
                move = Math.min(move, 2 * name.length() - i - 2 * count);
            }
        }
        
        if(move == name.length()) move = 0;
        answer += move;
        
        return answer;
    }
}