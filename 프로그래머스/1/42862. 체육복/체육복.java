import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        int[] check = new int[n+2];
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i : reserve) check[i] = 1;
        
        for(int i : lost){
            if(check[i] == 1){
                answer++;
                check[i] = 2;
            }
        }
        
        for(int i : lost){
            if(check[i] == 2){
                check[i]=0;
            }
            else if(check[i-1] == 1){
                answer++;
                check[i-1] = 0;
            }
            else if(check[i+1] == 1){
                answer++;
                check[i+1] = 0;
            }
        }
        
        return answer;
    }
}