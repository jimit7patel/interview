/* The question can be found here.
https://community.topcoder.com/stat?c=problem_statement&pm=2915&rd=5853
*/
/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{	
	int findMinimum(String a, String b){
		int xa = a.charAt(0) - 'a';
		int xb = b.charAt(0) - 'a';
		int ya = (a.charAt(1) - '0') - 1;
		int yb = (b.charAt(1) - '0') - 1;
		
		int dist[][]=new int[8][8];
		
		/*Intialize the distance array with -1*/
		for (int i=0; i <8;i++){
			for (int j=0;j<8;j++){
				dist[i][j]=-1;
			}
		}
		int kJump[][] ={{-2,-1},{-2,1},{2,-1},{2,1},{-1,-2},{1,-2},{-1,2},{1,2}};
		dist[xa][ya]=0;
		
		if(a==b){
			return dist[xa][ya];
		}
		Queue<String> queue = new LinkedList<String>();
		queue.add(Integer.toString(xa)+Integer.toString(ya));
		while(!queue.isEmpty()){
			String x = queue.poll();
			xa = x.charAt(0) - '0';
			ya = x.charAt(1) - '0';
			
			for (int i=0; i<8;i++){
				int xaa = xa + kJump[i][0];
				int yaa = ya + kJump[i][1];
				if (xaa<8 && xaa>=0 && yaa<8 && yaa>=0 ){ //&& dist[xaa][yaa] == -1
					dist[xaa][yaa]=dist[xa][ya]+1;
					if(xaa==xb && yaa==yb){
						return dist[xaa][yaa];	
					}
					queue.add(Integer.toString(xaa)+Integer.toString(yaa));
				}
			}
			 
			
		}
		
		return -1;
	}
	
	public int fastKnight(String knight, String queen, String rook){
		
		int mdistance = Math.min(findMinimum(knight, queen),findMinimum(knight, rook)) + findMinimum(queen, rook);
		return mdistance;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Ideone id = new Ideone();
		int d = id.fastKnight("b1","c3","a3");
		System.out.println("d" +d);
	}
}
