import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        
        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i],"a");
        }
        
        return map.size() > nums.length/2 ? nums.length/2 : map.size();
    }
}