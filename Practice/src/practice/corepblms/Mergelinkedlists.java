package practice.corepblms;



public class Mergelinkedlists  {

	
	
	Customlinkedlist ans =new Customlinkedlist();
	public  Customlinkedlist merge(Customlinkedlist first,Customlinkedlist second)
	{
		Node f=first.head;
		Node s=second.head;
		
		while(f!=null && s!=null)
		{
			if(f.value<s.value)
			{
				ans.insertlast(f.value);
				f=f.next;
			}
			else
			{
				ans.insertlast(s.value);
				s=s.next;
			}
		}
		while(f!=null)
		{
			ans.insertlast(f.value);
			f=f.next;
		}
		while(s!=null)
		{
			ans.insertlast(s.value);
			s=s.next;
		}
		
		return ans;
	}
	
	 @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        Node temp = ans.head; // start from the head of the list
	        while (temp != null) {
	            sb.append(temp.value);
	            if (temp.next != null) {
	                sb.append(" -> ");
	            }
	            temp = temp.next;
	        }
	        return sb.toString();
	    }
}
