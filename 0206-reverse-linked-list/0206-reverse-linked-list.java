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
    public ListNode reverseList(ListNode head) {
        ListNode currentNode = head;
        ListNode prevNode = null;
        ListNode nextNode;
        while (currentNode != null) {
            nextNode = currentNode.next; //3
            currentNode.next = prevNode; //1
            prevNode = currentNode;
            currentNode = nextNode;
            //System.out.println("")
        }
        return prevNode;
    }
}