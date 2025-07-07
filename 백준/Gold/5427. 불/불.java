import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Location {
        int x;
        int y;

        boolean fire;

        Location(int y, int x, boolean fire){
            this.y = y;
            this.x = x;
            this.fire = fire;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 1<= N <= 100
        int N = Integer.parseInt(br.readLine());


        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for(int tc=0; tc<N; tc++){
            String[] str = br.readLine().split(" ");
            Queue<Location> queue = new LinkedList<>();

            //1 <= x,y <= 1000
            int X = Integer.parseInt(str[0]);
            int Y = Integer.parseInt(str[1]);

            int start_x = 0;
            int start_y = 0;

            String[][] input = new String[Y][X];
            int[][] matrix = new int[Y][X];

            for(int i=0; i<Y; i++){
                String s = br.readLine();

                for(int j=0; j<X; j++){
                    input[i][j] = Character.toString(s.charAt(j));
                    matrix[i][j] = 10000000;
                    if(input[i][j].equals("#")) matrix[i][j] = -1;
                    else if(input[i][j].equals("*")){
                        queue.add(new Location(i, j, true));
                        matrix[i][j] = 0;
                    }
                    else if(input[i][j].equals("@")){
                        start_y = i;
                        start_x = j;
                        matrix[i][j] = 0;
                    }
                }
            }

            queue.add(new Location(start_y, start_x, false));

            int answer = 0;
            while(!queue.isEmpty()){
                Location l = queue.poll();
                int curr_y = l.y;
                int curr_x = l.x;
                boolean fire = l.fire;

                for(int d=0; d<4; d++){
                    int next_y = curr_y + dy[d];
                    int next_x = curr_x + dx[d];

                    if(next_y >= 0 && next_y < Y && next_x >= 0 && next_x < X){
                        if(matrix[next_y][next_x] > matrix[curr_y][curr_x] + 1){
                            matrix[next_y][next_x] = matrix[curr_y][curr_x] + 1;
                            queue.add(new Location(next_y, next_x, fire));
                        }
                    }
                    else{
                        if(!fire){
                            answer = matrix[curr_y][curr_x] + 1;
                            while(!queue.isEmpty()){
                                queue.poll();
                            }
                            break;
                        }
                    }
                }
            }

            if(answer == 0){
                sb.append("IMPOSSIBLE\n");
            }
            else{
                sb.append(answer + "\n");
            }
        }
        System.out.println(sb.toString());

        br.close();
    }
}
