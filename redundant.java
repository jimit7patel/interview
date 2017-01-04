/*find # of redundant of a given length */

import java.util.*;
import java.lang.*;
import java.io.*;

class Network{
public int howMany(int length, int x[]) {
   if (length == 1) return 0;
   if(x[length]!=0) return x[length];
   int ret = 0;
   for (int sub = 1; sub < length; sub++) 
      if (length % sub == 0)
      //# of Non-Redundant = Total - Redundant
      	 
         ret += (1 << sub) - howMany(sub,x);
   x[length]=ret;
   return ret;
}
public static void main (String args[])throws java.lang.Exception{
	int x[] = new int[11];
   for(int i=0;i<11;i++)
    System.out.println("Output is"+new Network().howMany(i,x));
}    
}
