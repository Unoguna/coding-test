class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int y_length = board.length;
        int x_length = board[0].length;
        
        String curr_color = board[h][w];
        
        
        if(h+1 < y_length && board[h][w].equals(board[h+1][w])) answer++;
        if(h-1 >= 0 && board[h][w].equals(board[h-1][w])) answer++;
        if(w+1 < x_length && board[h][w].equals(board[h][w+1])) answer++;
        if(w-1 >= 0 && board[h][w].equals(board[h][w-1])) answer++;
        
        return answer;
    }
}