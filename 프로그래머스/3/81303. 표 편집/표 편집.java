import java.util.*;

class Solution {
    
    Stack<Node> deleteIdx = new Stack<>();
    
    class Node{
        // boolean first;
        // boolean end;
        boolean delete;
        
        Node upNode;
        Node downNode;
        int idx;
        
        Node(int idx){
            // this.first = idx == 0 ? true : false;
            // this.end = idx == n-1 ? true : false;
            this.delete = false;
            
            this.upNode = null;
            this.idx = idx;
            this.downNode = null;
        }
    }
    
    Node execute(Node currNode, String cmd){
        
        if(cmd.length() >= 3){
            int num = Integer.parseInt(cmd.split(" ")[1]);
            if(cmd.charAt(0) == 'U'){
                for(int i=0; i<num; i++){
                    currNode = currNode.upNode;
                }
            }
            else{
                for(int i=0; i<num; i++){
                    currNode = currNode.downNode;
                }
            }
        }
        else{
            if(cmd.charAt(0) == 'C'){
                Node upNode = currNode.upNode;
                Node downNode = currNode.downNode;
                
                currNode.delete = true;
                deleteIdx.push(currNode);
                
                if(currNode.upNode != null) upNode.downNode = downNode;                         
                
                if(currNode.downNode != null) {
                    downNode.upNode = upNode;
                    currNode = downNode;
                }
                else {
                    currNode = upNode;
                }
            }
            else{
                Node undoNode = deleteIdx.pop();
                undoNode.delete = false;
                
                Node upNode = undoNode.upNode;
                Node downNode = undoNode.downNode;
                
                if(undoNode.upNode != null) upNode.downNode = undoNode;
                
                if(undoNode.downNode != null) downNode.upNode = undoNode;
                
            }
        }
        return currNode;
    }
    
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        
        Node[] nodes = new Node[n];
        
        for(int i=0; i<n; i++){
            nodes[i] = new Node(i);
        }
        nodes[0].downNode = nodes[1];
        for(int i=1; i<n-1; i++){
            nodes[i].upNode = nodes[i-1];
            nodes[i].downNode = nodes[i+1];
        }
        nodes[n-1].upNode = nodes[n-2];
        
        Node currNode = nodes[k];
        
        for(String str : cmd){
            currNode = execute(currNode, str);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            if(nodes[i].delete) sb.append('X');
            else sb.append('O');
        }
 
        return sb.toString();
    }
}