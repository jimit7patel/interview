/*https://community.topcoder.com/stat?c=problem_statement&pm=4504&rd=6537*/

public String getOutput(String[] threads, String[] slices) {
   StringBuffer ret = new StringBuffer();
   int[] pc = new int[threads.length];
   for (int i = 0; i < slices.length; i++) {
      String[] toks = slices[i].split(" ");
      int threadNum = Integer.parseInt(toks[0]), time = Integer.parseInt(toks[1]);
      for (int j = 0; j < time; j++) {
         ret.append(threads[threadNum].charAt(pc[threadNum]));
         pc[threadNum] = (pc[threadNum] + 1) % threads[threadNum].length();
      }
   }
   return ret+"";
}
