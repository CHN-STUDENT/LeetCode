class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int x=0; //该位
        int y=0; //进位，默认进位为0
        int a,b; //节点的值
        //使用尾插法插入数据
        ListNode head=new ListNode(0); //头节点
        head.next=null;
        ListNode prev=head; //上个节点
        while (l1!=null||l2!=null) {
			//l1或l2只要有一个不为空就继续循环
            if(l1==null) {
                a=0; //为了防止一个节点为空，另外一个节点不为空，因此令该节点的值为0
            } else {
                a=l1.val; //取该节点的值
                l1=l1.next; //进入下一个节点
            }
            if(l2==null) {
                b=0;
            } else {
                b=l2.val;
                l2=l2.next;
            }
            x=(a+b+y)%10; //这是该位
            y=(a+b+y)/10; //这是进位
            prev.next=new ListNode(x); //上个节点指向该节点
            prev.next.next=null; //该节点指向为空
            prev=prev.next; //该节点变为上个节点，为下一次准备
        }
        if(y!=0){ //存在有进位，插入链表
            prev.next=new ListNode(y);
            prev.next.next=null; //该节点指向为空
        }
        return head.next;
    }
}