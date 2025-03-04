class Solution {
    
    int[] dy = {0,0,1,-1};
    int[] dx = {1,-1,0,0};
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        char item[][] = new char[storage.length][storage[0].length()];
        int arr[][] = new int[storage.length][storage[0].length()];
        //0->아이템 존재 + 접근X, 1->아이템 존재+접근가능, 2->아이템X+접근X, 3->아이템X+접근가능
        
        
        for(int i=0; i<storage.length; i++){
            for(int j=0; j<storage[0].length(); j++){
                item[i][j] = storage[i].charAt(j);
                if(i == 0 || j == 0 || i == storage.length-1 || j == storage[i].length() - 1) arr[i][j] = 1;
            }
        }
        
        // for(int i=0; i<storage.length; i++){
        //     for(int j=0; j<storage[0].length(); j++){
        //         System.out.print(arr[i][j]);
        //     }
        //     System.out.println();
        // }
        
        for(String request : requests){
            char ch = request.charAt(0);
            
            if(request.length() == 1){
                for(int i=0; i<storage.length; i++){
                    for(int j=0; j<storage[0].length(); j++){
                        if(item[i][j] == ch && arr[i][j] == 1){
                            arr[i][j] = 3;
                        }
                    }
                }    
            }
            if(request.length() == 2){
                for(int i=0; i<storage.length; i++){
                    for(int j=0; j<storage[0].length(); j++){
                        if(item[i][j] == ch){
                            if(arr[i][j] == 1) arr[i][j] = 3;
                            if(arr[i][j] == 0) arr[i][j] = 2;
                        }
                    }
                }   
            }
            
            for(int r=0; r<3; r++){
                for(int i=0; i<storage.length; i++){
                    for(int j=0; j<storage[0].length(); j++){
                        if(arr[i][j] == 3){
                            for(int k=0; k<4; k++){
                                int y_idx = i+dy[k];
                                int x_idx = j+dx[k];   
                                if(y_idx>=0 && x_idx>=0 && y_idx < storage.length && x_idx<storage[0].length()){
                                    if(arr[y_idx][x_idx] == 0) arr[y_idx][x_idx] = 1;
                                    if(arr[y_idx][x_idx] == 2) arr[y_idx][x_idx] = 3;      
                                }
                            }
                        }
                    }
                }
            }
        }
        
        for(int i=0; i<storage.length; i++){
            for(int j=0; j<storage[0].length(); j++){
                if(arr[i][j] == 1 || arr[i][j] == 0) answer++;
            }
        }
        
        return answer;
    }
}