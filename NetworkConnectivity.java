import java.util.*;
import java.lang.*;
import java.io.*;

class Network{
public int dfs(int s, boolean nei[][], boolean vis[], int n){
	
    vis[s]=true;
    int ret=0;
    for(int i=1; i<=n;i++){
        if(nei[s][i]){
            if(!vis[i]){
                ret = 1;
                
                ret+=dfs(i,nei,vis,n);
            }
        }
    }
    return ret;
}
public int bfs(int s, boolean nei[][], boolean vis[], int n){
	Queue<Integer> queue = new LinkedList<Integer>();
    vis[s]=true;
    queue.add(s);
    int ret = 0;
    while(!queue.isEmpty()){
    	int t = queue.poll();
    	for(int i=1; i<=n;i++){
        	if(nei[t][i]){
            	if(!vis[i]){
                	queue.add(i);
                	vis[i]=true;
                	ret++;
            	}
        }	}
    }
    return ret;
}

public static void main (String args[])throws java.lang.Exception{
    Scanner scanner = new Scanner(System.in);
    
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int s = scanner.nextInt();
    boolean nei[][] = new boolean[n+1][n+1];
    boolean vis[]=new boolean[n];
    
   /* for (int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            nei[i][j]=false;
        }
    }*/
    
    for (int i=0; i<m; i++){
        int from = scanner.nextInt();
        int to = scanner.nextInt();
        nei[from][to]=true;
        nei[to][from]=true;
        //System.out.println("Output is"+from+to);
    }
    System.out.println("Output is"+new Network().bfs(s,nei,vis,n));
}    
}
