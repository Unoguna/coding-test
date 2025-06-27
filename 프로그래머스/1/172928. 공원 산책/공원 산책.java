class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        int park_x;
        int park_y;
        
        int curr_x=0;
        int curr_y=0;
        
        park_x = park[0].length();
        park_y = park.length;
        
        for(int i=0; i<park_y; i++){
            for(int j=0; j<park_x; j++){
                if(park[i].charAt(j) == 'S'){
                    curr_x = j;
                    curr_y = i;
                }
            }
        }
        
        for(String route : routes){
            String[] input = route.split(" ");
            String op = new String(input[0]);
            int n = Integer.parseInt(input[1]);
            
            int next_y = curr_y;
            int next_x = curr_x;
            
            
            switch(op){
                case "N" :
                    for(int i=0; i<n; i++){
                        next_y--;
                        if(next_y < 0 || park[next_y].charAt(next_x) == 'X') break;
                        else if(i == n-1) curr_y = next_y;
                    }
                    break;
                case "S":
                    for(int i=0; i<n; i++){
                        next_y++;
                        if(next_y >= park_y || park[next_y].charAt(next_x) == 'X') break;
                        else if(i == n-1) curr_y = next_y;
                    }
                    break;
                case "W":
                    for(int i=0; i<n; i++){
                        next_x--;
                        if(next_x < 0 || park[next_y].charAt(next_x) == 'X') break;
                        else if(i == n-1) curr_x = next_x;
                    }
                    break;
                case "E":
                    for(int i=0; i<n; i++){
                        next_x++;
                        if(next_x >= park_x || park[next_y].charAt(next_x) == 'X') break;
                        else if(i == n-1) curr_x = next_x;
                    }
                    break;
            }  
            
            
        }
        
        answer[0] = curr_y;
        answer[1] = curr_x;
        return answer;
    }
}