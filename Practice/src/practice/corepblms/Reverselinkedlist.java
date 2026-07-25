package practice.corepblms;



public class Reverselinkedlist  {
	
	public Node reverse(Customlinkedlist first) {
	
	Node curr=first.head;
	Node prev=null;
	
	while(curr!=null)
	{
		Node nextnode=curr.next;
		
		curr.next=prev;
		
		prev =curr;
		
		curr=nextnode;
	}
	
	first.head=prev;
	
	return first.head;
	
	}
	
}
