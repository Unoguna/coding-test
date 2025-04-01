class Solution {
    
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    
    int check(String[] place){
        for(int y=0; y<5; y++){
            for(int x=0; x<5; x++){
                if(place[y].charAt(x) != 'P') continue;
                for(int idx1=0; idx1<4; idx1++){
                    int next_x1 = x + dx[idx1];
                    int next_y1 = y + dy[idx1];
                    if(next_x1 >= 0 && next_y1 >= 0 && next_x1 <=4 && next_y1 <= 4){
                        char c1 = place[next_y1].charAt(next_x1);
                        if(c1 == 'P'){
                            //System.out.println(next_y1 + " 1 " + next_x1);
                            return 0;
                        }
                        else if(c1 != 'X'){
                            for(int idx2=0; idx2<4; idx2++){
                                int next_x2 = next_x1 + dx[idx2];
                                int next_y2 = next_y1 + dy[idx2];
                                if(next_x2 == x && next_y2 == y) continue;
                                if(next_x2 >= 0 && next_y2 >= 0 && next_x2 <=4 && next_y2 <= 4){
                                    char c2 = place[next_y2].charAt(next_x2);
                                    if(c2 == 'P') {
                                        //System.out.println(next_y2 + " 2 " + next_x2);
                                        return 0;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return 1;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i=0; i<places.length; i++){
            answer[i] = check(places[i]);
        }
        
        
        return answer;
    }
}