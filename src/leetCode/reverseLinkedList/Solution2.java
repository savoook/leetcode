package leetCode.reverseLinkedList;

import leetCode.elements.ListNode;

//      1->3->2->5->null
//null<-1<-3<-2<-5<-null
class Solution2 {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head!=null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
