import java.util.*;

class Solution {
    
    long l_pow(long num, int times){
        long ret = 1;
        for(int i=0; i<times; i++){
            ret *= num;
        }
        return ret;
    }
    
    long convert(String str){
        long cnt = 0;
        for(int i=0; i<str.length(); i++){
            long pow = l_pow(26L, str.length() - i - 1);
            cnt += pow * (str.charAt(i) - 'a' + 1);
        }
        return cnt;
    }
    
    String reverse(long idx){
        String str = "";
        while(idx != 0){
            idx--;
            str += (char)('a' + idx%26);
            idx /= 26;
        }
        return str;
    }
    
    public String solution(long n, String[] bans) {
        String answer = "";
        long cnt = 0L;
        Arrays.sort(bans,(o1, o2) -> {
            if(o1.length() == o2.length()){
                return o1.compareTo(o2);
            }
            else{
                return o1.length() - o2.length();
            }
        });
        for(int i=0; i<bans.length; i++){
            String str = new String(bans[i]);
            long idx = convert(str);
            //System.out.println(idx);
            if(idx <= n + cnt) cnt++;
        }
        
        answer = reverse(n + cnt);
        String rev = "";
        
        for(int i=answer.length()-1; i>=0; i--){
            rev += answer.charAt(i);
        }
        
        return rev;
    }
}