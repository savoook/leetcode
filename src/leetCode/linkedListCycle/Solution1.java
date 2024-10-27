package leetCode.linkedListCycle;

import leetCode.elements.ListNode;

class Solution1 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode one = head;
        ListNode two = head.next;
        while (one != two) {
            if (two == null || two.next == null) {
                return false;
            }
            one = one.next;
            two = two.next.next;
        }
        return true;
    }
}
