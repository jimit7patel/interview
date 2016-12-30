/* https://community.topcoder.com/stat?c=problem_statement&pm=1889&rd=4709 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.HashSet;


class Solution {
  public boolean isIdenticalHashSet (ArrayList h1, ArrayList h2) {
    if ( h1.size() != h2.size() ) {
        return false;
    }
    ArrayList clone1 = new ArrayList (h1); // just use h2 if you don't need to save the original h2
    ArrayList clone2 = new ArrayList (h2); // just use h2 if you don't need to save the original h2
    Iterator it = clone1.iterator();
    Iterator it2 = clone2.iterator();
    while (it.hasNext() ){
    	int t = (int)it.next();
    	int t2 = (int)it2.next();
    	//System.out.println("h1"+t+"h2"+t2);
        if (t!=t2){
            return false;
        }
    }
    return true; 
}  
 

public long combos(int width, int height, String[] nums){
 long d[][]=new long [width+1][height+1];
ArrayList<ArrayList> s = new ArrayList<ArrayList>();
 for(int a=0;a<=width;a++){
 	for(int b=0;b<=height;b++){
 		d[a][b]=0;
 		//c[a][b]=0;
 	}
 }



 
 for(String num:nums){
 	
 	StringTokenizer st = new StringTokenizer(num);
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      ArrayList t = new ArrayList();
      t.add(Math.min(x1,x2));
      t.add(Math.min(y1,y2));
      t.add(Math.max(x1,x2));
      t.add(Math.max(y1,y2));
      s.add(t);
      
 }

 d[0][0]=1;


 for(int b =0;b<=height;b++){
 	for(int a=0;a<=width;a++){
 		if(a+1<=width){
 			//System.out.println("aray"+d[a][b]);
	 		ArrayList t = new ArrayList();
	 		int check = 1;
	 		t.add(a);
	      	t.add(b);
	      	t.add(a+1);
	      	t.add(b);
	      	for(ArrayList sa:s){
	      		//System.out.println("aray"+sa);
	 			if(isIdenticalHashSet(sa,t)){
	 				check=0;
	 				break;
	 			}
	 			
	 		}
	 		if(check==1){
	 			d[a+1][b]=d[a+1][b]+d[a][b];
	 			
	 		}
 		}
 		if(b+1<=height){
	 		ArrayList t1 = new ArrayList();
	 		int check = 1;
	 		t1.add(a);
	      	t1.add(b);
	      	t1.add(a);
	      	t1.add(b+1);
	      	for(ArrayList sa:s){
	 			if(isIdenticalHashSet(sa,t1) ){
	 				check =0;
	 				break;
	 			
	 				
	 			}
	 		}
	 		if(check==1){
	 				d[a][b+1]=d[a][b+1]+d[a][b];
	 		}
 		}
 	}
 }
 return d[width][height];
}

    public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Solution id = new Solution();
		String nums[]={};
		long s = id.combos(35,31,nums);
		System.out.println("s"+s);
	}
    
}
