import java.util.*;

class Solution {
    
    public int answer = 0;
    public int length;
    
    public HashMap<Integer, Integer> map = new HashMap<>(); 
    
    public boolean isPrime(int num){
        if(num == 0 || num == 1)
            return false;
        int check=2;
        while(check * check <= num){
            if(num%check == 0)
                return false;
            check++;
        }
        return true;
    }
    
    public int pow(int a, int b){
        int answer = 1;
        for(int i=0; i<b; i++){
            answer *= a;
        }
        return answer;
    }
    
    public void DFS(boolean[] check, int[] num, int time, int sum){
        time++;
        map.put(sum,1);
        if(time == length)
            return;
        
        for(int i=0; i<num.length; i++){
            if(check[i]){
                check[i] = false;
                DFS(check, num, time, sum + num[i] * pow(10, time));
                check[i] = true;
            }
        }
        return;
        
    }
    
    public int solution(String numbers) {
        
        boolean[] check = new boolean[numbers.length()];
        length = numbers.length();
        for(int i=0; i<numbers.length(); i++)
            check[i] = true;
        
        int[] num = new int[numbers.length()];
        
        for(int i=0; i<numbers.length(); i++){
            num[i] = numbers.charAt(i) - '0';
        }
        
        DFS(check, num, -1, 0);
        
        for(int i : map.keySet()){
            if(isPrime(i))
                answer++;
        }
        
        return answer;
    }
}