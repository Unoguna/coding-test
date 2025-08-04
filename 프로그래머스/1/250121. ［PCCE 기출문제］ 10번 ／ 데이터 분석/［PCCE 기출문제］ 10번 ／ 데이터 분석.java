import java.util.*;

class Solution {
    
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        ArrayList<int[]> list = new ArrayList<>();
        
        int ext_idx=0;
        int sort_idx=0;
        
        if(ext.equals("code")) ext_idx = 0;
        if(ext.equals("date")) ext_idx = 1;
        if(ext.equals("maximum")) ext_idx = 2;
        if(ext.equals("remain")) ext_idx = 3;
        
        if(sort_by.equals("code")) sort_idx = 0;
        if(sort_by.equals("date")) sort_idx = 1;
        if(sort_by.equals("maximum")) sort_idx = 2;
        if(sort_by.equals("remain")) sort_idx = 3;
        
        for(int i=0; i<data.length; i++){
            if(data[i][ext_idx] < val_ext){
                list.add(data[i]);
            }
        }
        
        final int idx = sort_idx;
        
        list.sort((o1, o2) ->
                  o1[idx] - o2[idx]           
        );
        
        int[][] answer = new int[list.size()][4];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        
        return answer;
    }
}