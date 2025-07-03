import java.io.*;
import java.util.Stack;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> input = new Stack<>();
        Stack<Integer> stack= new Stack<>();    //스택 생성

        // 1<= N <= 500000
        int N = Integer.parseInt(br.readLine());

        int[] tower = new int[N];
        int[] answer = new int[N];

        String[] str = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            tower[i] =  Integer.parseInt(str[i]); //해당 idx의 tower의 높이
            input.add(i);
        }

        int receiverIdx = N - 1;
        while(!input.isEmpty()){

            if(stack.isEmpty()) {
                stack.add(input.pop());
                receiverIdx--;
            }

            int idx = stack.peek();

            if(receiverIdx < 0){
                answer[idx] = 0;
                stack.pop();
                continue;
            }

            if(tower[idx] <= tower[receiverIdx]){
                answer[idx] = receiverIdx + 1;
                stack.pop();
            }
            else{
                stack.add(input.pop());
                receiverIdx--;
            }
        }


        for(int num : answer)
            System.out.print(num + " ");
    }
}
