package practice.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App1 {
	
	public static void main(String[] args) {
		
		
		int[] arr =new int[] { 2,3,6,7,4,5};
		int target  =8;
		
		List<Stream<int[]>> mapped = IntStream.range(0, arr.length)
			    .boxed()
			    .map(i -> IntStream.range(i + 1, arr.length)
			                       .filter(j -> arr[i] + arr[j] == target)
			                       .mapToObj(j -> new int[]{i, j}))
			    .toList();

			//System.out.println(mapped);
			List<int[]> flatMapped = IntStream.range(0, arr.length)
				    .boxed()
				    .flatMap(i -> IntStream.range(i + 1, arr.length)
				                           .filter(j -> arr[i] + arr[j] == target)
				                           .mapToObj(j -> new int[]{i, j}))
				    .toList();

				//System.out.println(flatMapped);
				//[[I@37a71e93, [I@7e6cbb7a]--->tostring representation of int[] object
		//flatMapped.forEach(pair -> System.out.println(Arrays.toString(pair)));
			mapped.forEach(pair -> System.out.println((pair)));

			flatMapped.forEach(pair -> System.out.println(Arrays.toString(pair)));


		

		
	}

}
