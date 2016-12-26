/* https://community.topcoder.com/stat?c=problem_statement&pm=3005&rd=5858 */

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;
 
public class LargestCircle
{
 
  
  private boolean doesNotIntersectAny(char[][] grid, int cr, int cc, int radius, int nr, int nc)
  {
    int[] inout = {0, 0, 0, 0};
    int radiusSq = radius*radius;
    int cornerR, cornerC;
    
    for (int i = 0; i < nr; i++)
    {
      for (int j = 0; j < nc; j++)
      {
        if (grid[i][j] == '.') continue;
        cornerR = i; cornerC = j;
        inout[0] = radiusSq - ((cornerR-cr)*(cornerR-cr)+(cornerC-cc)*(cornerC-cc));      
        cornerR = i; cornerC = j+1;
        inout[1] = radiusSq - ((cornerR-cr)*(cornerR-cr)+(cornerC-cc)*(cornerC-cc));  
        cornerR = i+1; cornerC = j+1;
        inout[2] = radiusSq - ((cornerR-cr)*(cornerR-cr)+(cornerC-cc)*(cornerC-cc));  
        cornerR = i+1; cornerC = j;
        inout[3] = radiusSq - ((cornerR-cr)*(cornerR-cr)+(cornerC-cc)*(cornerC-cc));
        if (!((inout[0] <= 0 && inout[1] <= 0 && inout[2] <= 0 && inout[3] <= 0) ||
              (inout[0] >= 0 && inout[1] >= 0 && inout[2] >= 0 && inout[3] >= 0)))
          return false;
      }
    }
    return true;
  }
  public int radius(String[] gridStr)
  {
    int nr = gridStr.length;
    int nc = gridStr[0].length();
    char[][] grid = new char[nr][nc];
    for (int i = 0; i < nr; i++)
    {
      gridStr[i].getChars(0, nc, grid[i], 0);
    }
    int maxr = 0;
    for (int i = 0; i <= nr; i++)
    {
      for (int j = 0; j <= nc; j++)
      {
        int radius = maxr+1;
        while (i>=radius && (nr-i)>=radius && j>=radius && (nc-j)>=radius)
        {
          if (doesNotIntersectAny(grid, i, j, radius, nr, nc))
          {
            maxr = radius;
            //System.out.println(""+i+" "+j+" "+radius+" "+nr+" "+nc);
          }
          radius++;
        }        
      }
    }
    return maxr;
  }
