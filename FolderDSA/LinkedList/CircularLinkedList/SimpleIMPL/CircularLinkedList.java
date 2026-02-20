package DSALinkedList;

public class CircularLinkedList {
 CNode head;
  
 CircularLinkedList(){
	 head=null;
 }
  
 void insertAtBegging(String data) {
	 CNode newNode= new CNode(data);
	  if(head== null) {
		  newNode.next=newNode; // the new node points to  it's self because it head and tail
		  head=newNode;
		  return;
	  }
	  CNode temp =head; // irriterate to the node that the next is head because the last node points to head
	  while(temp.next!=head) {
		  temp=temp.next;
	  }
	  temp.next=newNode;
	  newNode.next=head;
	  head=newNode;
 }
 
 void insertAtEnd(String data) {
	 CNode newNode = new CNode(data);
	 if(head==null) {
		 newNode.next=newNode; //pointing to itself because it will be the head
		 head=newNode;
		 return;
		 
	 }
	 CNode temp= head;
	 while(temp.next!=head) {
		 temp=temp.next;
	 }
	 
	 temp.next=newNode;
	 newNode.next=head;
 }
 
 void deleteFromBegging() {
	 if(head==null) {
		 return;
	 }
	 
	 if(head.next==head) {
		 head=null;
		 return;
	 }
	 
	 CNode temp= head;
	 while(temp.next!=head) {
		 temp=temp.next;
	 }
	 
	 temp.next=head.next;
	 head=temp.next;
 }
 
  void cdisplay() {
	  if (head==null) {
		  return;
	  }
	  CNode temp = head;
	  
	  do {
		  System.out.print(temp.data+"====>");
		  temp=temp.next;
	  }while(temp!=null);
	  System.out.println("Back to head");
  }
 
}
