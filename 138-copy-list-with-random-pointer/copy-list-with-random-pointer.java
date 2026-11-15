/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node deepcopy(Node head1){
        Node temp1=head1;
        Node dummy=new Node(-1);
        Node temp2=dummy;
        while(temp1!=null){
            Node t= new Node(temp1.val);
            temp2.next=t;
            temp2=t;
            temp1=temp1.next;
        }
        return dummy.next;
    }
    public void merge(Node head1,Node head2){
        Node dummy=new Node(-1);
        Node temp=dummy;
        Node temp1=head1;
        Node temp2=head2;
        while(temp2!=null){
            temp.next=temp1;
            temp1=temp1.next;
            temp=temp.next;

            temp.next=temp2;
            temp2=temp2.next;
            temp=temp.next;
        }
    }
    public void randomconnections(Node head1,Node head2){
        Node temp1=head1;
        Node temp2=head2;
        while(temp1!=null && temp2!=null){
            if( temp1.random==null) temp2.random=null;
            else{
                temp2.random=temp1.random.next;
            }
            temp1=temp1.next.next;
            if(temp2.next!=null) temp2=temp2.next.next;
        }
    }
    public void split(Node head1){
        Node dummy1=new Node(-1);
        Node dummy2=new Node(-1);
        Node temp1=dummy1;
        Node temp2=dummy2;
        Node temp=head1;
        while(temp!=null){
            temp1.next=temp;
            temp=temp.next;
            temp1=temp1.next;

            temp2.next=temp;
            temp=temp.next;
            temp2=temp2.next;
        }
        temp1.next=null;
    }
    

    public Node copyRandomList(Node head1) {
        //Step1:create a deep copy of og LL
        Node head2=deepcopy(head1);
        //Step2:merge the both og and deep copy LLs
        merge(head1,head2);
        //Step3:establish random pointer in deep copy LL
        randomconnections(head1,head2);
        //Step4:split the merged list into there original forms
        split(head1);
        return head2;
    }
}