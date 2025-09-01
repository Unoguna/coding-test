class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int mul = n * m;
        
        int a = 1;
        
        int num = 2;
        while(n/num >= 1 && m/num >= 1){
            if(n%num == 0 && m%num == 0){
                n/=num;
                m/=num;
                a *= num;
            }
            else{
                num++;
            }
        }
        answer[0] = a;
        answer[1] = mul/a;
        return answer;
    }
}