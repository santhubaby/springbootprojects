package practice.corepblms;

public class Halfreversell {

	
	public Customlinkedlist reversehalf(Customlinkedlist ls,int left,int right) {
		
		Node prev=null;
		Node current=ls.head;
		if(left==right)
		{
			return ls;
		}
		for(int i=0;current!=null && i<left;i++)
		
		{
			prev=current;
			current=current.next;
		}
		
		Node last=prev;
		Node newend=current;
		
		for(int i=0;i<right-left+1; i++)
		{
			Node next=current.next;
			current.next=prev;
			prev=current;
			current=next;
			
		}
		last.next=prev;
		newend.next=current;
		
		return ls;
		
	}
}
