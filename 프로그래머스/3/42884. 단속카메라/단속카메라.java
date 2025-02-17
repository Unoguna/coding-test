import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int min = 300000;
        for(int i=0; i<routes.length; i++){
            if(routes[i][0] <= min){
                if(routes[i][1] < min)
                    min = routes[i][1];
            }
            else{
                min = routes[i][1];
                answer++;
            }
            
        }
        return answer + 1;
    }
}