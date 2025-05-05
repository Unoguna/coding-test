class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int length = s.length();
        
        int min = length;
        
        for(int i=1; i<=length/2; i++){
            int startIdx = 0;
            int endIdx = i;
            
            String convertedString = "";
            String tmp = s.substring(startIdx, endIdx);
            startIdx += i;
            endIdx += i;
            int count = 1;
            while(endIdx <= length){
                if(tmp.equals(s.substring(startIdx, endIdx))){
                    count++;
                }
                else{
                    if(count != 1){
                        convertedString += Integer.toString(count);
                        count = 1;
                    }
                    convertedString += tmp;
                    tmp = s.substring(startIdx, endIdx);
                }
                
                
                startIdx += i;
                endIdx += i;
            }
            
            if(count != 1){
                    convertedString += Integer.toString(count);
                    count = 1;
            }
            convertedString += tmp;
            
            convertedString += s.substring(startIdx, length);
            min = min < convertedString.length() ? min : convertedString.length();
        }
        
        return min;
    }
}