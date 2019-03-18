package leetCode;

public class MinStack2 {

    private Node head;

    private class Node{
        int val;
        int min;
        Node next;

        private Node(int val, int min){
            this.val = val;
            this.min = min;
            next = null;
        }

        private Node(int val, int min, Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public int top() {
        return head.val;
    }

    public void push(int x){
        if(head == null){
            head = new Node(x, x);
        } else {
            // 对这一步的理解不够，链表需要复习
            head = new Node(x, Math.min(x, head.min), head);
        }
    }

    public void pop(){
        head = head.next;
    }

    public int getMin(){
        return head.min;
    }
}
