import java.util.*;

class Solution {
    public boolean isPrime(int num){
        int sq = (int)Math.sqrt(num);
        for(int i=2; i<=sq; i++){
            if(num % i == 0) return false;
        }

        return true;
    }   
    
    public int solution(int[] nums) {
        int answer = 0;

        for(int i=0; i<nums.length - 2; i++){
            for(int j=i+1; j<nums.length - 1; j++){
                for(int h = j + 1; h<nums.length; h++){
                    if(isPrime(nums[i] + nums[j] + nums[h])) answer++;
                }
            }
        }
    
        return answer;
    }
}
