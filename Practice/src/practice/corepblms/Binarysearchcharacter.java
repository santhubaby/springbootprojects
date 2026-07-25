package practice.corepblms;

public class Binarysearchcharacter {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ch[] =  {'c','e','g','k','y'};
		int l=0;
		int r=ch.length-1;
		
		char target='h';
		while(l<=r)
		{   
			int mid= (l+(r))/2;
			
			if(ch[mid]>target)   
			{
				r=mid-1;
			}
			else
			{
				l=mid+1;
			}
			    
		}
		if(r<0)
		{
			System.out.println(-1);

		}
		else {
			System.out.println(ch[r]);

		}

}
}
