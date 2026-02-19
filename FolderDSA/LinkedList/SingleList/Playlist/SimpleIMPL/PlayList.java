package DSALinkedList;

public class PlayList {
 SongNode head;
 
 PlayList(){
	 this.head=null;
 }
 
 void  addSong(Song song) {
	 SongNode newNode= new SongNode(song);
	 if (head==null) {
		 head=newNode;
		 return;
	 }
	 
	 SongNode temp= head;
	 while(temp.next!=null) {
		 temp=temp.next;
	 }
	 temp.next=newNode;
 }
 
 void PlayAll() {
	 SongNode current=head;
	 while(current!=null) {
		playSong(current.song);
		 current=current.next;
	 }
	 System.out.println("End of Playlist");
 }
 
 void playSong(Song song) {
	 System.out.println("Playing:"+song.title+"| artist"+song.artist+"| duration:"+song.duration+" s");
	 try {
		 Thread.sleep(song.duration*1000L);
	 }catch(InterruptedException e){
		 System.out.println("play  interrupted");
	 }
 }
 
 void dissplay() {
		SongNode temp=head;
		while(temp!=null) {
			System.out.print(temp.song+" --> ");
			temp=temp.next;
		}
		System.out.println("Null");
	}
	
}
