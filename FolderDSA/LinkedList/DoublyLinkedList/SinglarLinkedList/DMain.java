package DSALinkedList;

public class DMain {
 public static void main(String[] args) {
	 DoublyLinkedList list= new DoublyLinkedList();
	 list.insertAtBeginning(2);
	 list.insertAtEnd(8);
	 list.displayForward();
	 list.insertAtEnd(4);
	 list.displayForward();
	 list.deteteFromBeginning();
	 list.displayForward();
 }
}
