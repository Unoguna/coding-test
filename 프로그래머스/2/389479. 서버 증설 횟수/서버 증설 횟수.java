class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] add_server = new int[players.length];
        
        int server_count = 0;
        for(int time=0; time<players.length; time++){
            if(time-k >=0){
                server_count -= add_server[time-k];
            }
            int limit = server_count * m + m - 1;
            if(players[time] > limit){
                int count = (players[time] - limit - 1) / m + 1;
                //System.out.println(time + " " + count);
                server_count += count;
                answer += count;
                add_server[time] = count;
            }
        }
        
        return answer;
    }
}