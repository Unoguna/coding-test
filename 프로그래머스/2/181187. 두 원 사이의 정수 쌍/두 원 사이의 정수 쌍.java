import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        answer += (long)(r2 - r1 + 1) * 4;
        
        for(int i=1; i<r2; i++){
            
            // long tmp1 = (long)Math.pow(r2,2);
            // long tmp2 = (long)Math.pow(i,2);
            long tmp1 = (long)r2 * r2;
            long tmp2 = (long)i * i;
            
            long top = (long)Math.floor(Math.sqrt(tmp1 - tmp2));
            answer += top * 4;
        }
        
        for(int i=1; i<r1; i++){
            long tmp1 = (long)Math.pow(r1,2);
            long tmp2 = (long)Math.pow(i,2);
            
            long top = (long)Math.ceil(Math.sqrt(tmp1 - tmp2)) - 1;
            answer -= top * 4;
        }

        return answer;
    }
}