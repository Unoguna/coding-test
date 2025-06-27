class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        int Y = wallpaper.length;
        int X = wallpaper[0].length();
        
        int min_x = X;
        int min_y = Y;
        
        int max_x = 0;
        int max_y = 0;
        
        for(int i=0; i<Y; i++){
            for(int j = 0; j<X; j++){
                if(wallpaper[i].charAt(j) == '#'){
                    min_x = min_x < j ? min_x : j;
                    min_y = min_y < i ? min_y : i;
                    max_x = max_x > j ? max_x : j;
                    max_y = max_y > i ? max_y : i;
                }
            }
        }
        
        answer[0] = min_y;
        answer[1] = min_x;
        answer[2] = max_y + 1;
        answer[3] = max_x + 1;
        
        return answer;
    }
}