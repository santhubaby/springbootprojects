package practice.corepblms;

public class Binarysearchleftmost {

	public  static int leftmost(int a[], int target) {
	int l=0;
	int r=a.length-1;
	
	
	while(l<=r)
	{   
		int mid= (l+r)/2;
		if(a[mid]==target)
			{
			r=mid-1;
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
	
	
	if(a[l] !=target)
	{
		return -1;
	}
	return l;
	}


  public static void main(String[] args) {
	  

		int a[] = new int[] {2,4,6,6,7,8,9};
	    System.out.println(Binarysearchleftmost.leftmost(a,6));
}
}
