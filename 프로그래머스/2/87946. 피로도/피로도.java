class Solution {
    
    public int max = 0;
    public void func(boolean[] check, int[][] dungeons, int time, int hp){
        
        for(int i=0; i<check.length; i++){
            if(check[i] && hp >= dungeons[i][0]){
                check[i] = false;
                
                func(check, dungeons, time+1, hp-dungeons[i][1]);
                
                check[i] = true;
            }
        }
        max = time > max ? time : max;
    }
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        boolean[] check = new boolean[dungeons.length];
        for(int i=0; i<check.length; i++) check[i] = true;
        
        func(check, dungeons, 0, k);
        
        return max;
    }
}