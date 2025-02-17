class Solution {
    
    public void BFS(int i, int[][] computers, int[] check){
        for(int j=0; j<computers.length; j++){
            if(computers[i][j] == 1 && check[j] == 0){
                check[j] = 1;
                BFS(j, computers, check);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int[] check = new int[computers.length];
        int answer = 0;
        
        for(int i=0; i<n; i++){
            if(check[i] == 0){
                answer++;
                check[i] = 1;
                BFS(i, computers, check);
            }
        }
        
        return answer;
    }
}