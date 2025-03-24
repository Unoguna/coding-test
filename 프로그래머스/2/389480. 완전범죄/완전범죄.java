import java.util.*;

class Solution {    
    public int solution(int[][] info, int n, int m) {
        int answer = 0;
        
        Arrays.sort(info, (o1, o2) -> {
            int num1 = o1[0] * o2[1];
            int num2 = o1[1] * o2[0];
            
            if(num1 == num2){
                return Integer.compare(o2[0], o1[0]);
            }else{
                return Integer.compare(num2, num1);
            }
        });
        
        for(int i=0; i<info.length; i++){
            System.out.println(info[i][0] + " " + info[i][1]);
        }
        
        int a_cost = 0;
        int b_cost = 0;
        int idx = 0;
        while(idx < info.length){
            if(b_cost + info[idx][1] < m){
                b_cost += info[idx][1];
                idx++;
            }
            else{
                a_cost += info[idx][0];
                idx++;
            }
        }
        if(a_cost >= n) return -1;
        else return a_cost;
    }
}