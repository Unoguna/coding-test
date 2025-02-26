import java.util.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        ArrayList<int[]> arr = new ArrayList<>();
        int idx = 0;
        for(int i1=1; i1 <= n-4; i1++){
            for(int i2 = i1+1; i2<=n-3; i2++){
                for(int i3 = i2+1; i3<=n-2; i3++){
                    for(int i4 = i3 + 1; i4<=n-1; i4++){
                        for(int i5 = i4 + 1; i5<=n; i5++){
                            int[] arr1 = {i1,i2,i3,i4,i5};
                            
                            int flag = 0;
                            for(int i=0; i<q.length; i++){
                                int check = 0;
                                for(int j=0; j<5; j++){
                                    for(int k=0; k<5; k++){
                                        if(q[i][j] == arr1[k]) check++;
                                    }
                                }
                                if(check != ans[i]){
                                    flag = 1;
                                    break;
                                }
                            }
                            
                            if(flag == 0)
                                arr.add(arr1);
                            else flag = 0;
                        }
                    }
                }
            }
        }
        
        
        
        return arr.size();
    }
}