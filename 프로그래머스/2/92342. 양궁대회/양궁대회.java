class Solution {
    
    int[] answer = new int[11];
    int max_value = 0;
    
    void calc_score(int[]info, int[]tmp){
        int score = 0;
        for(int i=0; i<=10; i++){
            if(info[i] >= tmp[i] && info[i] != 0) score -= 10 - i;
            else if(info[i] < tmp[i]) score += 10 - i;
            
        }
        
        if(max_value <= score){
            max_value = score;
            for(int i=0; i<=10; i++){
                answer[i] = tmp[i];
            }
        }
    }
    
    void recurr(int[] info, int n, int[] tmp, int max){
        if(n == 0){
            calc_score(info, tmp);
            return;
        }
        for(int i=0; i<=max; i++){
            tmp[i]++;
            recurr(info, n-1, tmp, i);
            tmp[i]--;
        }
        
    }
    
    public int[] solution(int n, int[] info) {
        
        int[] tmp = new int[11];
        
        recurr(info, n, tmp, 10);
        
        if(max_value == 0){
            int[] a = new int[1];
            a[0] = -1;
            return a;
        }
        
        System.out.println(max_value);
        return answer;
    }
}