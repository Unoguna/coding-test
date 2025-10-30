class Solution {
    
    int move(int[][] matrix, int y1, int x1, int y2, int x2){
        
        int min = Integer.MAX_VALUE;
        
        int num1 = matrix[y1][x1];
        int num2 = matrix[y1][x2];
        int num3 = matrix[y2][x2];
        int num4 = matrix[y2][x1];
        
        min = Math.min(min,num1);
        min = Math.min(min,num2);
        min = Math.min(min,num3);
        min = Math.min(min,num4);
        

        for(int x = x2; x > x1 + 1; x--){
            min = Math.min(min, matrix[y1][x-1]);
            matrix[y1][x] = matrix[y1][x-1];
        }

        for(int y = y2; y > y1 + 1; y--){
            min = Math.min(min, matrix[y - 1][x2]);
            matrix[y][x2] = matrix[y - 1][x2];
        }
        
        for(int x = x1; x < x2 - 1; x++){
            min = Math.min(min, matrix[y2][x+1]);
            matrix[y2][x] = matrix[y2][x+1];
        }
        
        for(int y = y1; y < y2 - 1; y++){
            min = Math.min(min, matrix[y+1][x1]);
            matrix[y][x1] = matrix[y+1][x1];
        }
        
        matrix[y1][x1+1] = num1;
        matrix[y1+1][x2] = num2;
        matrix[y2][x2-1] = num3;
        matrix[y2-1][x1] = num4;
        
        return min;
        
    }
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int queriesLength = queries.length;
        int[] answer = new int[queriesLength];
        int[][] matrix = new int[rows][columns];
        int num = 1; 
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                matrix[i][j] = num++;
            }
        }
        for(int i = 0; i < queriesLength; i++){
            answer[i] = move(matrix, queries[i][0]-1, queries[i][1]-1, queries[i][2]-1, queries[i][3]-1);
        }
        return answer;
    }
}