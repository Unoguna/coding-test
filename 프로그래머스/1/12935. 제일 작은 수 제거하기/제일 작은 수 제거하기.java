class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length-1];
        
        int idx = -1;
        int num = Integer.MAX_VALUE;
        
        if(arr.length == 1){
            int[] ret = {-1};
            return ret;
        }
        
        for(int i=0; i < arr.length; i++){
            if(num > arr[i]){
                num  = arr[i];
                idx = i;
            }
        }
        
        for(int i=0; i< arr.length; i++){
            if(i < idx) answer[i] = arr[i];
            else if(i > idx) answer[i-1] = arr[i];
        }
        
        return answer;
    }
}