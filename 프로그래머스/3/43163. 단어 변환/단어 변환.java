import java.util.*;

class Solution {
    
    public boolean oneDiff(String s1, String s2){
        int cnt = 0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i))
                cnt++;
        }
        if(cnt == 1) return true;
        else return false;
    }
    
    public class State{
        public String word;
        public int count;
        
        State(String word, int count){
            this.word = new String(word);
            this.count = count;
        }
        
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Queue<State> q = new LinkedList<>();
        q.add(new State(begin, 0));
        
        int[] check = new int[words.length];
        
        while(!q.isEmpty()){
            State curr = q.poll();
            String currStr = new String(curr.word);
            if(currStr.equals(target)) return curr.count;
            for(int i=0; i<words.length; i++){
                if(check[i] != 1 && oneDiff(currStr, words[i])){
                    check[i] = 1;
                    q.add(new State(words[i], curr.count + 1));
                }
            }
        }
        
        return 0;
    }
}