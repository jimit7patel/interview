/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return Integer.compare(l1.val,l2.val);
            }
        }
 */
public class Solution {
    class testcompare implements Comparator<ListNode>{
	    @Override
        public int compare(ListNode a, ListNode b){
            return Integer.compare(a.val,b.val);
        }
    }

   
    public ListNode mergeKLists(ListNode[] lists) {
         if(lists == null || lists.length==0){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length,new testcompare());
       
        ListNode head = new ListNode(0);
        ListNode result = head;
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null)
                pq.add(lists[i]);
        }
        while(!pq.isEmpty()){
            ListNode tmp = pq.poll();
            if(tmp.next != null)
                pq.add(tmp.next);
            result.next=tmp;
            result = result.next;
            
        }
        return head.next;
        
    }
}
