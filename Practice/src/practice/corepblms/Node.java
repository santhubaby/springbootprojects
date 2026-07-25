package practice.corepblms;

public class Node{
	
	
	protected int value;
    protected Node next;
    protected  int size;
    public Node()
    {
        size=size+1;
    }
    
    
    public Node(int value )
    {
        this.value=value;
    }
    public Node(int value,Node n)
    {
        this.value=value;
        this.next=n;
    }
    @Override
    public String toString() {
        return String.valueOf(value);
    }

   

    
	public static void main(String[] args) {
		System.out.println("Hello World");
		Customlinkedlist linkedlist=new Customlinkedlist();
		Mergelinkedlists mgl=new Mergelinkedlists();
		Removeduplicatesll rmd=new Removeduplicatesll();
		Halfreversell hfr=new Halfreversell();
		//linkedlist.insertfirst(1);
		//linkedlist.insertfirst(2);
		linkedlist.insertlast(1);
		linkedlist.insertlast(2);
		linkedlist.insertlast(3);
		linkedlist.insertlast(4);
		linkedlist.insertlast(5);
		linkedlist.insertlast(6);
		linkedlist.insertlast(7);
		linkedlist.insertlast(8);
		//linkedlist.insertmiddle(5,2);
		
		Customlinkedlist first=new Customlinkedlist ();
		Customlinkedlist  second=new Customlinkedlist ();
		first.insertlast(1);
		first.insertlast(1);
		first.insertlast(1);
		first.insertlast(2);
		first.insertlast(2);
		first.insertlast(3);
		first.insertlast(3);
		first.insertlast(3);
		//first.insertmiddle(8,2);
		second.insertlast(1);
		second.insertlast(3);
		second.insertfirst(9);
		second.insertlast(13);
		//System.out.println(first);
		//System.out.println(second);
		Customlinkedlist ne=rmd.removeduplicates(first);
		//Customlinkedlist  ans= mgl.merge(first, second);
		//System.out.println(ans);
		//ans.display();
		//System.out.println(ne);
		System.out.println(linkedlist);

		System.out.println(hfr.reversehalf(linkedlist,2,4));
		
		
		
	
		
		
	}
}
