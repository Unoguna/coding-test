import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        LinkedList <Integer> list = new LinkedList<>();
        
        for(int food : ingredient){
            list.add(food);
            
            if(list.size() < 4) continue;
            int idx = list.size() - 1;
            if(list.get(idx) == 1 && list.get(idx-1) == 3 && list.get(idx-2) == 2 && list.get(idx-3) == 1){
                answer++;
                list.remove(idx);
                list.remove(idx-1);
                list.remove(idx-2);
                list.remove(idx-3);
            }
        }
        
        return answer;
    }
}