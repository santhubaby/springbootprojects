package practice.corepblms;

public class Binarysearchrightmost {

	public  static int rightmost(int a[], int target) {
	int l=0;
	int r=a.length-1;
	
	
	while(l<=r)
	{   
		int mid= (l+r)/2;
		if(a[mid]==target)
			{
			l=mid+1;
			}
		if(a[mid]<target)   
		{
			l=mid+1;
		}
		if(a[mid]>target)
		{
			r=mid-1;
		}
		    
	}
	
	if(r<0)
	{
		return -1;
	}
	
	
	
	
	return r;
	}


  public static void main(String[] args) {
	  

		int a[] = new int[] {2,4,6,6,7,8,9};
	    System.out.println(Binarysearchrightmost.rightmost(a,6));
}
}
