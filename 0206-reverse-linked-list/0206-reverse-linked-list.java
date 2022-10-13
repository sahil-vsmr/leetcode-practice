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
        ListNode prevNode;
        ListNode nextNode;
        if (currentNode != null) {
            prevNode = currentNode; //1
            currentNode = currentNode.next; //2
            prevNode.next = null;
            while (currentNode != null) {
                nextNode = currentNode.next; //3
                currentNode.next = prevNode; //1
                prevNode = currentNode;
                currentNode = nextNode;
                //System.out.println("")
            }
            return prevNode;    
        } else {
            return head;
        }
        
    }
}