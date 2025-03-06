class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int box_y = (num-1)/w + 1;
        int box_x;
        if(box_y%2 == 1){
            box_x = (num-1)%w;
        }
        else{
            box_x = w - (num-1)%w - 1;
        }
        
        int top_y = (n-1)/w + 1;
        int top_x;
        if(top_y%2 == 1){
            top_x = (n-1)%w;
        }
        else{
            top_x = w - (n-1)%w - 1;
        }
        
        answer = top_y - box_y + 1;
        if(top_x < box_x && top_y%2==1) answer--;
        if(top_x > box_x && top_y%2==0) answer--;
        
        return answer;
    }
}