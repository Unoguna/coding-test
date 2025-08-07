import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        
        int[] x_num = new int[10];
        int[] y_num = new int[10];
        
        for(int i=0; i<X.length(); i++){
            x_num[Integer.parseInt(X.substring(i,i+1))]++;
        }
        for(int i=0; i<Y.length(); i++){
            y_num[Integer.parseInt(Y.substring(i,i+1))]++;
        }
        
        for(int i=9; i>=0 ;i--){
            int num = Math.min(x_num[i], y_num[i]);
            for(int j=0; j<num; j++){
                answer.append(Integer.toString(i));
            }
        }

        if(answer.toString().equals("")) return"-1";
        if(answer.toString().startsWith("0")) return "0";

        
        return answer.toString();
    }
}