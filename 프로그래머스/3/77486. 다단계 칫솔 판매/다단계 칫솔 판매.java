import java.util.*;

class Solution {
    
    class User{
        String referral;
        int result;
        
        User(String referral, int result){
            this.referral = referral;
            this.result = result;
        }
    }
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        HashMap<String, Integer> map = new HashMap<>();
        
        User[] users = new User[enroll.length];
        
        for(int i=0; i<enroll.length; i++){
            map.put(enroll[i], i);
            users[i] = new User(referral[i], 0);
        }
        
        for(int i=0; i<seller.length; i++){
            String curr_name = seller[i];
            int curr_amount = amount[i] * 100;
            while(!curr_name.equals("-") && curr_amount != 0){
                int curr_idx = map.get(curr_name);
                User user = users[curr_idx];
                

                user.result += curr_amount - curr_amount/10;

                curr_name = user.referral;
                curr_amount = curr_amount/10;
            }
        }
        
        for(int i=0; i<users.length; i++){
            answer[i] = users[i].result;
        }
        
        return answer;
    }
}