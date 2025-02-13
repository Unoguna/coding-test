class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int num1 = 0;
        int num2 = 0;
        
        for(int i=0; i<sizes.length; i++){
            int row = sizes[i][0];
            int col = sizes[i][1];
            int big = row > col ? row : col;
            int small = row < col ? row : col;
            num1 = num1 > big ? num1 : big;
            num2 = num2 > small ? num2 : small; 
        }
        answer = num1 * num2;
        return answer;
    }
}