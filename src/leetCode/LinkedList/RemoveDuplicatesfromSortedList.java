package leetCode.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class RemoveDuplicatesfromSortedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {

        ListNode temp = head;

        while(temp.next != null && temp.next.next != null){
            if(temp.val == temp.next.val){
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return temp;
    }


}
