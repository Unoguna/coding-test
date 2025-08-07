class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] check = {"aya", "ye", "woo", "ma"};
        
        
        for(String input : babbling){
            int flag = 0;
            int last_idx = -1;
            while(true){
                if(input.length() == 0){
                    answer++;
                    break;
                }
                
                for(int i=0; i<4; i++){
                    if(input.startsWith(check[i])&& last_idx != i){
                        input = input.substring(check[i].length(), input.length());
                        flag = 1;
                        last_idx = i;
                        break;
                    }
                }
                if(flag == 0) break;
                flag = 0;
            }
        }
        return answer;
    }
}