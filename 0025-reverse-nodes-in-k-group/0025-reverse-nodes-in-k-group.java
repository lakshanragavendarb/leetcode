class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevWindow = dummy;
        ListNode current = head;
        while (current != null) {
            ListNode end = current;
            int count = 0;
            while (count < k && end != null) {
                end = end.next;
                count++;
            }
            if (count < k) {
                break; 
            }
            ListNode start = current;
            ListNode nextWindow = end;
            ListNode prev = null;
            current = start;
            while (current != nextWindow) {
                ListNode temp = current.next;
                current.next = prev;
                prev = current;
                current = temp;
            }
            prevWindow.next = prev;
            start.next = nextWindow;            
            prevWindow = start;
        }
        return dummy.next;
    }
}