import java.util.*;

class Solution {
    
    class User{
        String name;
        List<Integer> report;
        
        User(String name){
            this.name = name;
            report = new ArrayList<>();
        }
    }
    
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        ArrayList<User> user = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String id : id_list){
            user.add(new User(id));
            map.put(id, user.size() - 1);
        }
        
        int[][] check = new int[user.size()][user.size()];
        
        for(String rep : report){
            String[] s1 = rep.split(" ");
            
            int idx0 = map.get(s1[0]);
            int idx1 = map.get(s1[1]);
            
            if(check[idx0][idx1] == 0){
                user.get(idx1).report.add(idx0);
                check[idx0][idx1] = 1;
            }
            
        }
        
        for(int i=0; i<user.size(); i++){
            User u = user.get(i);
            if(u.report.size() >= k){
                for(int idx : u.report){
                    answer[idx]++;
                }
            }
        }
        
        return answer;
    }
}