package DSALinkedList;

public class DoublyLinkedList {
 DNode head;
 
 DoublyLinkedList(){
	 this.head=null;
 }
 
 void insertAtBeginning(int data) {
	 DNode newNode= new DNode(data); // the node to insert 
	 
	 if(head!=null) { //if there is a node 
		 head.prev=newNode;
	 }
	 newNode.next=head; 
	 head=newNode; //change the head to be the  newNode created
 }
 
 void insertAtEnd(int data) {
	 DNode newNode= new DNode(data);
	 if(head==null) {
		 head=newNode;
		 return;
	 }
	  
	 DNode temp =head;// temp= temporaly
	 while(temp.next !=null){ // irriterate to reach the node at the end
		 temp=temp.next;
	 }
	 temp.next=newNode;
	 newNode.prev=temp;
 }
 	void deteteFromBeginning() {
 		if (head==null) {
 			return;
 		}
 		head=head.next;
 		if(head!=null) {
 			head.prev=null;
 		}
 	}
 	 
 	void deleteFromEnd() {
 		if(head==null) {
 			return;
 		}
 		if(head.next==null) {
 			head=null;
 			return;
 		}
 		
 		DNode temp=head;// whenever we have to irriterate we must have a temporary head=temp;
 		while(temp.next!=null) {
 				temp=temp.next;
 		}
 		temp.prev.next=null;//update the next of the prev Node to null juu tunadelete at the end
 	}
  
 	void displayForward() {
 		DNode temp= head;
 		while(temp!=null) {
 			System.out.print(temp.data+"===>");
 			temp=temp.next;
 		}
 		System.out.println("Null");
 	}
}
