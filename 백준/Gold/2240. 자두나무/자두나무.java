
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] TW = (br.readLine()).split(" ");
        int T = Integer.parseInt(TW[0]);
        int W = Integer.parseInt(TW[1]);

        int[][] dp = new int[W + 1][T + 1];

        for(int t = 1; t <= T; t++){
            int drop_idx = Integer.parseInt(br.readLine());

            if(drop_idx == 1) dp[0][t] = dp[0][t - 1] + 1;
            else dp[0][t] = dp[0][t-1];

            int idx=Math.min(t, W);

            for(int w = 1; w <= idx; w++){
                if(drop_idx == 1){
                    if(w%2 == 0){
                        dp[w][t] = Math.max(dp[w][t-1], dp[w-1][t-1]) + 1;
                    }
                    else{
                        dp[w][t] = Math.max(dp[w][t-1], dp[w-1][t-1]);
                    }
                }
                else{
                    if(w%2 == 1){
                        dp[w][t] = Math.max(dp[w][t-1], dp[w-1][t-1]) + 1;
                    }
                    else{
                        dp[w][t] = Math.max(dp[w][t-1], dp[w-1][t-1]);
                    }
                }
            }
        }

        int answer = 0;
        for(int w=0; w<W+1; w++){
            answer = Math.max(answer, dp[w][T]);
        }

        System.out.println(answer);
    }
}
