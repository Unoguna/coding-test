import java.util.*;

class Solution {
    
    class Status{
        int time;
        boolean store;
        int total_time = 0;
        
        Status(int time, boolean store){
            this.time = time;
            this.store = store;
        }
    }
    
    int convert(String str){
        String[] s = str.split(":");
        int h = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        
        return h * 60 + m;
    }
    
    public int[] solution(int[] fees, String[] records) {        
        HashMap<String, Status> map = new HashMap<>();
        
        for(String record : records){
            
            String[] str = record.split(" ");
            
            
            if(map.containsKey(str[1])){
                Status stat = map.get(str[1]);
                if(stat.store){
                    stat.total_time += convert(str[0]) - stat.time;
                    stat.store = false;
                }
                else{
                    stat.time = convert(str[0]);
                    stat.store = true;
                }
            }
            else{
                map.put(str[1], new Status(convert(str[0]), true));
            }
        }
        
        String[] car = new String[map.keySet().size()];
        int[] answer = new int[car.length];
        int idx = 0;
        for(String str : map.keySet()){
            car[idx++] = str;
        }
        Arrays.sort(car);
        
        for(int i=0; i<car.length; i++){
            String carName = car[i];
            Status s = map.get(carName);
            int time = 0;
            time += s.total_time;
            if(s.store){
                time += convert("23:59") - s.time;
            }
            answer[i] += fees[1];
            int time1;
            time = 0 > time - fees[0] ? 0 : time - fees[0];
            if(time%fees[2] == 0){
                time = time / fees[2];
            }
            else{
                time = time / fees[2];
                time++;
            }
            answer[i] += time * fees[3];
        }
        
        return answer;
    }
}