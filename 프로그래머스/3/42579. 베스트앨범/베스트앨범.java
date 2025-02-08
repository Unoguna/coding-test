import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {       
        
        HashMap<String, Integer> map = new HashMap<String,Integer>();
        
        for(int i=0; i<genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<String> keys = new ArrayList<>(map.keySet());
        
        Collections.sort(keys, (v2, v1) -> (map.get(v1).compareTo(map.get(v2))));
        
        List<Integer> list = new ArrayList<>();
        
        for(String genre : keys){
            int first = 0;
            int first_idx = -1;
            int second = 0;
            int second_idx = -1;
            for(int i=0; i<genres.length; i++){
                if(genres[i].equals(genre)){
                    int num = plays[i];
                    if(num > first){
                        second = first;
                        first = num;
                        second_idx = first_idx;
                        first_idx = i;
                    }
                    else if(num > second){
                        second = num;
                        second_idx = i;
                    }
                        
                } 
            }
            list.add(first_idx);
            if(second_idx != -1)
                list.add(second_idx);
        }
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}