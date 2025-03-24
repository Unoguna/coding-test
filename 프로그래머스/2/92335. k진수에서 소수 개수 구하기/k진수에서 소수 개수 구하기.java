class Solution {
    String convert(int n, int k){
        String answer = "";
        while(n >= k){
            answer += Integer.toString(n%k);
            n = n/k;
        }
        answer += Integer.toString(n);
        
        String answer1 = "";
        
        for(int i=answer.length()-1; i >= 0 ; i--){
            answer1 += answer.charAt(i);
        }
        
        return answer1;
    }
    
    boolean isPrime(Long num){
        Long tmp = num / 2L;
        if(num == 1L) return false;
        if(num == 2L) return true;
        
        for(Long i=2L; i<=Math.sqrt(num); i++){
            if(num%i == 0) return false;
        }
        
        return true;
    }
    
    
    int find(String num){
        int count = 0;
        String[] str = num.split("0");
        for(String s : str){
            if(s.length() != 0){  
                Long prime = Long.parseLong(s);
                if(isPrime(prime)) count++;
            }
        }
        return count;
    }
    
    public int solution(int n, int k) {
        int answer;
        
        String num = convert(n, k);
        answer = find(num);
        
        return answer;
    }
}