package practice.corepblms;



public class Removeduplicatesll {
	
	public Customlinkedlist removeduplicates(Customlinkedlist first) {
	
	Node temp=first.head;
	while(temp.next!=null) {
		
		if(temp.value==temp.next.value) {
			temp.next=temp.next.next;
		}
		else {
			temp=temp.next;

		}
	}
	 return first;
	}
	
	  
}
