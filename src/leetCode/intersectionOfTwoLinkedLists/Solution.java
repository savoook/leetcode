package leetCode.intersectionOfTwoLinkedLists;

import leetCode.elements.ListNode;

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = length(headA);
        int lengthB = length(headB);
        int diff = Math.abs(lengthA - lengthB);
        while (diff-- > 0) {
            if (lengthA > lengthB) {
                headA = headA.next;
            } else {
                headB = headB.next;
            }
        }
        for (; headA != null && headB != null; headA = headA.next, headB = headB.next)
            if (headA.equals(headB)) return headA;
        return null;
    }

    private int length(ListNode listNode) {
        if (listNode==null) return 0;
        int length = 0;
        while (listNode != null) {
            length++;
            listNode = listNode.next;
        }
        return length;
    }
}
