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
    public void reorderList(ListNode head) {
        ListNode slow=head;
         ListNode fast=head;    
        while(fast!=null && fast.next!=null)
{
    slow=slow.next;
    fast=fast.next.next;
}   
    ListNode sec=slow.next;
    slow.next=null;
    ListNode curr=sec;
    ListNode prev=null;
    while(curr!=null){
        ListNode nod=curr.next;
        curr.next=prev;
        prev=curr;
        curr=nod;
    }
    ListNode first=head.next;
    ListNode second=prev;
    ListNode current=head;
    while(second!=null){
        current.next=second;
        current=current.next;
        second=second.next;
        current.next=first;
        first=first.next;
        current=current.next;
    }
    }
}