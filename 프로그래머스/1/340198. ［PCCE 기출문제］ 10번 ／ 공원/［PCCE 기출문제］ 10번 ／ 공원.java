class Solution {
    
    int max = Integer.MAX_VALUE;
    
    boolean find2(String[][] park, int mat, int i, int j){
        for(int y = i; y< i + mat; y++){
            for(int x = j ; x < j + mat; x++){
                if(!park[y][x].equals("-1")) return false;
            }
        }
        return true;
    }
    
    boolean find(String[][] park, int mat){
        if(mat > max) return false;
        
        for(int i=0; i<park.length - mat + 1; i++){
            for(int j=0; j<park[0].length - mat + 1; j++){
                if(find2(park, mat, i, j)) return true;
            }
        }
        
        if(max > mat) max = mat;
        
        return false;
    }
       
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        
        for(int mat : mats){
            if(find(park, mat)) {
                answer = mat > answer ? mat : answer;
            }
        }
 
        return answer;
    }
}