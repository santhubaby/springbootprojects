package practice.corepblms;

import java.util.Arrays;

public class Bubblesort {
	
	public  int[] printbubblesort(int[] a)
	{
		int temp=0;
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a.length-1;j++)
			{
				if(a[j+1]<a[j])
				{
					temp=a[j+1];
					a[j+1]=a[j];
					a[j]=temp;
				}
			}
		  
		}
		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		int[] arr= {5,14,3,12,1};
		Bubblesort bsort= new Bubblesort();
		System.out.println(Arrays.toString(bsort.printbubblesort(arr)));
		

	}

}
