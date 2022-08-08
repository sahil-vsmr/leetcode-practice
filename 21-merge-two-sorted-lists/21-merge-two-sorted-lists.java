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
        List<Integer> myList = new ArrayList<>();
        
        ListNode head1 = list1;
        ListNode head2 = list2;
        
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                myList.add(head1.val);
                head1 = head1.next;
            } else {
                myList.add(head2.val);
                head2 = head2.next;
            }
        }
        
        while (head1 != null) {
            myList.add(head1.val);
            head1 = head1.next;
        }
        
        while (head2 != null) {
            myList.add(head2.val);
            head2 = head2.next;
        }
        
        ListNode result = new ListNode();
        ListNode node = result;
        for (int value: myList) {
            ListNode currentNode = new ListNode(value);
            currentNode.next = null;
            node.next = currentNode;
            node = currentNode;
        }
        return result.next;
    }
}