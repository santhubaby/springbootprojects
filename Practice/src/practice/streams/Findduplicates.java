package practice.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Findduplicates {
	
	public static int count(int n, int[] a)
	{ 
		int c=0;
		// TODO Auto-generated method stub
		for(int i=0;i<a.length;i++)
		{
			if(a[i]==n)
           {
	         c++;
           }
		
		}
		return c;
	
	}
	public static void main(String[] args)
	{

		int[] a= new int[] {1,2,2,3,4,6,6};
	Set<Integer> lst=Arrays.stream(a).boxed().filter(n->Findduplicates.count(n,a)>1).collect(Collectors.toSet());
	
	double avg = Arrays.stream(a).filter(n->n%2==0).average().getAsDouble();
	//System.out.println(lst);
	
	System.out.println(avg);
	
}
}

/***
 * import java.util.*;
import java.util.stream.*;

public class Findduplicates {
    public static void main(String[] args) {
        int[] a = {1,2,2,3,4,6,6};

        // Build frequency map
        Map<Integer, Long> freq = Arrays.stream(a)
                                        .boxed()
                                        .collect(Collectors.groupingBy(
                                            n -> n, Collectors.counting()));

        // Collect only duplicates
        List<Integer> lst = Arrays.stream(a)
                                  .boxed()
                                  .filter(n -> freq.get(n) > 1)
                                  .collect(Collectors.toList());

        System.out.println(lst); // [2, 2, 6, 6]
    }
}
***/
