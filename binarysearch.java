/* package whatever; // don't place package name! */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
class Ideone {
// @include
public static int bsearch(int t, List<Integer> A) {
if(A == null || A.size()==0){
	return -1;
}
int start = 0, end = A.size()-1;
int m = start + (end-start)/2;
while(start<end && t!=A.get(m)) {
	if(t<A.get(m)){
		end = m-1;
	}
	else{
		start = m+1;
	}
	m = start + (end-start)/2;
	
}
if(t==A.get(m)){
	return m;
}
else return -1;
}
// @exclude
 
private static void simpleTest() {
List<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3));
assert(0 == bsearch(1, A));
assert(1 == bsearch(2, A));
assert(2 == bsearch(3, A));
A = new ArrayList<Integer>(Arrays.asList(2, 2, 2));
assert(0 <= bsearch(2, A) && bsearch(2, A) <= 2);
assert(-1 == bsearch(3, A));
assert(-1 == bsearch(0, A));
}
 
public static void main(String[] args) {
simpleTest();
List<Integer> A
= new ArrayList<>(Arrays.asList(1, 2, 2, 2, 2, 3, 3, 3, 5, 6, 10, 100));
System.out.println("output"+bsearch(1, A));
System.out.println("output"+bsearch(2, A));
System.out.println("output"+bsearch(3, A));
System.out.println("output"+bsearch(4, A));
assert(0 == bsearch(1, A));
assert(1 <= bsearch(2, A) && bsearch(2, A) <= 4);
assert(5 <= bsearch(3, A));
assert(-1 == bsearch(4, A));
}
}
