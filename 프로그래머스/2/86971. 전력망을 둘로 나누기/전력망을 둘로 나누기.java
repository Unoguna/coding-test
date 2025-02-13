class Solution {
    
    int count = 0;
    
    public void func(int[][]wires, boolean[] check, int num){
        
        for(int i=0; i<wires.length; i++){
            if(check[i]){
                if(wires[i][0] == num){
                    check[i] = false;
                    count++;
                    func(wires, check, wires[i][1]);
                }
                else if(wires[i][1] == num){
                    check[i] = false;
                    count++;
                    func(wires, check, wires[i][0]);
                }
                check[i] = true;
            }
        }
    }
    
    public int solution(int n, int[][] wires) {
        int answer = 200;
        boolean[] check = new boolean[wires.length];
        for(int i=0; i<check.length; i++) check[i]=true;
        
        for(int i=0; i<wires.length; i++){
            int num1 = wires[i][0];
            int num2 = wires[i][1];
            check[i] = false;
            count = 0;
            func(wires, check, num1);
            
            int diff = 2 * count + 1 - check.length;
            int left = diff > 0 ? diff : -diff;
            
            answer = answer > left ? left : answer;
            check[i] = true;
        }
        
        return answer;
    }
}