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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //List<Integer> myList = new ArrayList<>();
        ListNode prehead = new ListNode(-1);
        
        ListNode l1 = list1;
        ListNode l2 = list2;
        
        ListNode prev = prehead;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                prev = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                prev = l2;
                l2 = l2.next;
            }
        }
        
        prev.next = l1 == null ? l2 : l1;
        
        return prehead.next;
    }
}