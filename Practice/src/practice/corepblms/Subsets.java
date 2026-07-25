package practice.corepblms;

import java.util.Arrays;
import java.util.Stack;

public class Subsets {
	
	public  static void printsubsets(int[] a, Stack<Integer> ans, int i)
	{
		if(i==a.length) {
			
			System.out.println((ans));
			return;
			}
		
		ans.push(a[i]);
		printsubsets(a,ans,i+1);
		
		ans.pop();
		printsubsets(a,ans,i+1);

		
	}
	
	public static void main(String[] args)
	{
		int[] arr= {1,2,3};
		Stack<Integer> ans=new Stack<Integer>();
		printsubsets(arr,ans,0);	
		
	
	}
}
