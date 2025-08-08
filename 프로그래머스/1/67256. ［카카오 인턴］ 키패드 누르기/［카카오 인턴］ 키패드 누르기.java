class Solution {
    
    class Hand{
        int x;
        int y;
        Hand(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    String location(int num){
        if(calc_x(num) == 0) return "left";
        else if(calc_x(num) == 2) return "right";
        else return "middle";
    }
    
    int calc_x(int num){
        return num % 3;
    }
    
    int calc_y(int num){
        return num / 3;
    }
    
    int calc(int x1, int y1, int x2, int y2){
        int output = 0;
        output += x1 > x2 ? x1 - x2 : x2 - x1;
        output += y1 > y2 ? y1 - y2 : y2 - y1;
        return output;
    }
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        
        Hand right = new Hand(2, 3);
        Hand left = new Hand(0, 3);
        
        for(int number : numbers){
            number--;
            if(number == -1) number = 10;
            switch(location(number)) {
                case "left" :
                    sb.append("L");
                    left.x = calc_x(number);
                    left.y = calc_y(number);
                    break;
                case "right" :
                    sb.append("R");
                    right.x = calc_x(number);
                    right.y = calc_y(number);
                    break;
                case "middle" :
                    int right_length = calc(right.x, right.y, calc_x(number), calc_y(number));
                    int left_length =  calc(left.x, left.y, calc_x(number), calc_y(number));
                
                    
                    if(right_length < left_length) {
                        sb.append("R");
                        right.x = calc_x(number);
                        right.y = calc_y(number);
                    }
                    else if(right_length > left_length) {
                        sb.append("L");
                        left.x = calc_x(number);
                        left.y = calc_y(number);
                    }
                    else{
                        if(hand.equals("right")){
                            sb.append("R");
                            right.x = calc_x(number);
                            right.y = calc_y(number);
                        }
                        else {
                            sb.append("L");
                            left.x = calc_x(number);
                            left.y = calc_y(number);
                        }
                    }           
            }
        }
        answer = sb.toString();
        return answer;
    }
}