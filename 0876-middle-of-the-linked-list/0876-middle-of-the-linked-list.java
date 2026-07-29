/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode s=head;
        List<Integer>list=new ArrayList<>();
        while(s!=null){
            list.add(s.val);
            s=s.next;
        }
        int n=list.size();
        int midindex=Math.abs(n/2);
        List<Integer>res=new ArrayList<>();
        for(int i=midindex;i<n;i++){
            res.add(list.get(i));
        }
        ListNode head1=null;
        ListNode tail=null;
        for(int i:res){
            ListNode k=new ListNode(i);
            if(head1==null){
                head1=k;
                tail=k;
            }
            else{
                tail.next=k;
                tail=k;
            }
        }
        return head1;
    }
}