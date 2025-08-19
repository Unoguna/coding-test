class Solution {
    
    void convert(int[][] map, int[] arr){
        
        for(int i=0; i<arr.length; i++){
            int num = arr[i];
            for(int j=0; j<arr.length; j++){
                int idx = arr.length - j - 1;
                map[i][idx] = num % 2;
                num /= 2;
            }
        }
    }
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        int[][] map1 = new int[n][n];
        int[][] map2 = new int[n][n];
        
        convert(map1, arr1);
        convert(map2, arr2);
        
        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++){
                if(map1[i][j] == 0 && map2[i][j] == 0)
                    sb.append(" ");
                else
                    sb.append("#"); 
            }
            answer[i] = sb.toString();
        }
 
        return answer;
    }
}