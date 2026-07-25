package practice.corepblms;
//import practice.corepblms;

public class Customlinkedlist {
	
	public Node head;
	int size;
	 public void insertfirst(int n){
	        
	        Node node =new Node(n);
	        if(head==null)
	        {
	            
	            head=node;
	            return;
	            
	        }
	        else {
	        	node.next=head;
	        	head=node;
	        }
	    }
	    
	    public  void insertlast(int n)
	    {
	        Node node=new Node(n);
	        
	        if(head==null)
	        {
	            
	            head=node;
	            return;
	            
	        }
	        
	        Node temp=head;
	        while(temp.next!=null)
	        
	        {
	            temp=temp.next;
	            
	        }
	        
	        temp.next=node;
	        
	        
	         }
	    
	    public  void insertmiddle(int n,int j)
	    {
	    	Node node =new Node(n);
	        if(head==null)
	        {
	            
	            head=node;
	            return;
	        }
	        else {
	            Node temp=head;
	            if(j==0)
	            {
	            	insertfirst(n);
	            	return;
	            }
	            else if(j==size)
	            {
	            	insertlast(n);
	            	return;
	            }
	            else
	            {
	            	for(int i=0;i<j-1;i++)
	            	{
	            		temp=temp.next;
	            	}

	            	node.next=temp.next;
	                temp.next=node;
	                
	            	
	            }

	        }
	    }
	    
		public  int length()
		{
			Node temp=head;
			int count=0;
			if(head==null)
			{
				return 0;
			}
			
			while(temp!=null)
			{
				temp=temp.next;
				count=count+1;
			}
			
			return count;
		}
		
		public int search(int key)
		{
			Node temp=head;
			int index=0;
			if(head==null)
			{
				System.out.println("no elements empty");
				return -1;
			}
			else {
				while(temp!=null)
				{
					if(temp.value==key)
					{
						
						return index;
					}
					
					
					temp=temp.next;
					index=index+1;
					
				}
				
				return -1;
				
			}
			
			
		}
		
		public   boolean iscycle() {
			Node fast=head;
			Node slow= head;
			
			while(slow!=null && fast!=null && fast.next!=null) {
				
				slow=slow.next;
				fast=fast.next.next;
				
				if(slow==fast)
				{
					return true;
				}
			}
			
			
			
			return false;
		}
		
		public  int  cyclelength() {
			Node fast=head;
			Node slow= head;
			
			while(slow!=null && fast!=null && fast.next!=null) {
				
				slow=slow.next;
				fast=fast.next.next;
				
				if(slow==fast)
				{
					int cyclelen=1;

					slow=slow.next;
					
					while(slow!=fast)
					{
						slow=slow.next;
						cyclelen=cyclelen+1;


					}
					
					return cyclelen;
				
				}
				
			}
			
		    return 0;
		}
		
		

	    public void display(){
	        Node temp=head;
	        while(temp!=null)
	        {
	            System.out.print(temp.value+ "----->");
	            temp=temp.next;
	        }
	    }

	    public void  deleteatstart()
	    {
	    	if(head==null)
	    	{
	    		System.out.println("no elements");
	    		return;
	    	}
	    	head=head.next;
	    }
	    
	    public  void deleteatend() {
	    	Node temp=head;
	    	
	    	if(head==null)
	    	{
	    		System.out.println("no elements");
	            return;
	    	}
	    	
	    	if(head.next==null)
	    	{
	    		head=null;
	    		return;
	    	}
	    	if(temp.next.next==null)
	    	{
	    		temp.next=null;
	    	}
	    	if(length()>2)
	    	{
	    		while(temp.next.next!=null) {
	        		
	        		temp=temp.next;
	        		
	        	}
	        	
	        	temp.next=null;
	    	}
	    	
	    }
	    public  void deleteatindex(int index)
	    {
	    	Node temp=head;
	    	
	    	if(head==null)
	    	{
	    		
	    		System.out.println("no elements");
	            return;
	    		
	    	}
	    	
	    	if(index==0)
	    	{
	    		deleteatstart();
	    	}
	    	
	    	if(index>=1)
	    	{
	    		for(int i=0;i<index-1;i++)
	    		{
	    			temp=temp.next;
	    		}
	    		temp.next=temp.next.next;
	    		
	    	}
	    }
	    
	    @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        Node temp = head; // start from the head of the list
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
