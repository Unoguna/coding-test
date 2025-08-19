class Solution {
    
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        String[] map1 = new String[n];
        String[] map2 = new String[n];
        
        for(int i=0; i<n; i++){
            map1[i] = Integer.toBinaryString(arr1[i]);
            while (map1[i].length() < n) map1[i] = "0" + map1[i];
            
            map2[i] = Integer.toBinaryString(arr2[i]);
            while (map2[i].length() < n) map2[i] = "0" + map2[i];
        }
        
        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++){
                if(map1[i].charAt(j) == '0' && map2[i].charAt(j) == '0') sb.append(" ");
                else sb.append("#");
            }
            answer[i] = sb.toString();
        }

        return answer;
    }
}