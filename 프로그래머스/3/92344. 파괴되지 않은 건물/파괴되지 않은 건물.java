class Solution {    
    public static int solution(int[][] board, int[][] skill) {

        int answer = 0;
        int N = board.length + 1;
        int M = board[0].length + 1;
        int[][] sum = new int[N][M];
        
        for(int[] sk : skill){
            int type = sk[0];
            int r1 = sk[1]; int c1 = sk[2];
            int r2 = sk[3]; int c2 = sk[4];
            int degree = sk[5];
            
            if(type == 1) degree *= -1;
            sum[r1][c1] += degree;
            sum[r1][c2+1] += degree * -1;
            sum[r2+1][c1] += degree * -1;
            sum[r2+1][c2+1] += degree;
        }
        
        for(int i=0; i<N; i++){
            for(int j=1; j<M; j++){
                sum[i][j] += sum[i][j-1];
            }
        }
        for(int j=0; j<M; j++){
            for(int i=1; i<N; i++){
                sum[i][j] += sum[i-1][j];
            }
        }
        
        for(int i=0; i<N-1; i++){
            for(int j=0; j<M-1; j++){
                if(board[i][j] + sum[i][j] > 0) answer++;
            }
        }
        return answer;
    }
 
}