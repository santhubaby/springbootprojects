package practice.corepblms;

import java.util.Arrays;

public class Quicksort {
	
	public static  int[] quicksort(int[] a, int start ,int end)
	{
		if(start<end)
		{
			int pivotindex=partition(a,start,end);
			quicksort(a,start, pivotindex-1);
			quicksort(a,pivotindex+1,end);

		}
		
		return a;
	}
	
	public static int partition(int[] a,int start, int end)
	
	{  
		int index=start-1;
		int pivot=a[end];
		int temp=0;
		int tem=0;
		for(int j=start;j<end;j++)
		{
			if(a[j]<pivot)
			{
				index=index+1;
				temp=a[j];
				a[j]=a[index];
				a[index]=temp;
			}
		}
		
		index=index+1;
		tem=a[end];
		a[end]=a[index];
		a[index]=tem;
		
		return index;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr= {41,55,2,1,6,7,3};
		System.out.println(Arrays.toString(quicksort(arr,0,arr.length-1)));

	}

}
