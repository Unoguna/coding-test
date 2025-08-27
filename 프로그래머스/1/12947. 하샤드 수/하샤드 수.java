class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int input = x;
        int num  = 0;
        
        while(input!=0){
            num += input%10;
            input/=10;
        }
        
        if(x%num == 0) return true;
        else return false;
    }
}