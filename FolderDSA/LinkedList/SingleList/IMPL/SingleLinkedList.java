package DSALinkedList;



public class SingleLinkedList {
	class Node {
			int data;
			Node next;

				Node(int data){
				this.data=data;
				this.next=null;
				}
			}
	
 Node head;//must store reference to the head because in single linked we start to the head then next node
 
 SingleLinkedList(){
	 head=null; //initialized to null because we don't  know the address yet, it will be update once the data is inserted
 }
 
 public void insertAtBegining(int data) {
	 Node newNode= new Node(data); //create a node that I want to insert
	 newNode.next=head; //Kuskuma ile node ilikuwa head
	 head= newNode; // kufanya ile node tumeweka sai ikuwe head
 }
 
 public void insertAtEnd(int data) {
	 Node newNode=new Node(data);
	 
	 if(head==null) {
		 head=newNode;
		 return;
	 }
	 
	 Node temp=head; //create a temporaly node to help to iterate
	 while(temp.next!=null) {
		 temp=temp.next; // if temp sio null, unaupdate temp to next value untill temp itakuwa null juu hio ndio itakuwa tail(end)
	 }	
	 temp.next=newNode; // hio last node tuko next yake ikuwe newNode(hio value utaweka)
 }
 
 		void deleteFromBeginnig() {
 			if (head==null) {
 				System.out.println("List is empty");
 				return;
 			}
 			head=head.next;
 		}
 		
 		void deleteFromEnd() {
 			if(head==null) {
 				System.out.println("List is empty");
 				return;
 			}
 			
 			if(head.next==null) {
 				head=null;
 				return;
 			}
 			
 			Node temp = head;
 			 
 			while(temp.next.next!=null) {
 				temp=temp.next;
 			}
 			temp.next=null;
 		}
 
 		
 		boolean search(int key) {
 			Node temp=head;
 			 while(temp!=null) {
 				 if(temp.data==key) {
 					 return true;
 				 }
 				 temp=temp.next;
 			 }
 			 return false;
 		}
 		
 		void display() {
 			Node temp=head;
 			while(temp!=null) {
 				System.out.print(temp.data+" --> ");
 				temp=temp.next;
 			}
 			System.out.println("Null");
 		}
 		
 		public static void main(String[] args) {
 			
 			SingleLinkedList list=new SingleLinkedList();
 			list.insertAtBegining(5);
 			list.insertAtEnd(8);
 			list.insertAtEnd(9);
 			list.insertAtEnd(10);
 			list.display();
 			list.deleteFromBeginnig();
 			list.display();
 			list.deleteFromEnd();
 			list.display();
 			System.out.println(list.search(9));
 			System.out.println(list.search(10));
 		}
 		
}
