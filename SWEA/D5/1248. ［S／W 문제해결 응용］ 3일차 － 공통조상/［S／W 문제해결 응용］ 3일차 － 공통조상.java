
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static int V;
    public static int E;
    
    public static int A;
    public static int B;
    
    public static int outputIdx;
    public static int outputNum;
    
    static class Node
    {
        int idx;
        int parentIdx;
        int leftIdx;
        int rightIdx;
        int flag;
        
        Node(int idx){
            this.idx = idx;
            this.parentIdx = -1;
            this.leftIdx = -1;
            this.rightIdx = -1;
            this.flag = 0;
        }
    }
    
    public static void calc(Node node[], int idx){
        Node currNode = node[idx];
        
        if(currNode.flag == 1) return;
        
        outputNum++;
        currNode.flag = 1;
        
        if(currNode.leftIdx != -1){
            calc(node, currNode.leftIdx);
        } 
        if(currNode.rightIdx != -1){
            calc(node, currNode.rightIdx);
        }
    }
    
    public static void recur(Node node[], int idx){
        calc(node, idx);
        if(node[B].flag != 1){
            int nextIdx = node[idx].parentIdx;
            outputIdx = nextIdx;
            recur(node, nextIdx);
        }
    }
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			V = sc.nextInt();
            E = sc.nextInt();
            A = sc.nextInt();
            B = sc.nextInt();
            
            outputNum = 0;
            outputIdx = A;
            
            Node[] node = new Node[V + 1];
            
            
            for(int i=0; i<V+1; i++){
                node[i] = new Node(i);
            }
            
            for(int i=0; i<E; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                
                if(node[a].leftIdx == -1){
                    node[a].leftIdx = b;
                } else {
                    node[a].rightIdx = b;
                }
                
                node[b].parentIdx = a;
            }
            
            recur(node, A);
            
            System.out.println("#" + test_case + " " + outputIdx + " " + outputNum); 
		}
	}
}