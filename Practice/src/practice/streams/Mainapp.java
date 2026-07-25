package practice.streams;

import java.util.Arrays;
import java.util.Base64;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Mainapp {
	
	public static void main(String[] args)
	{
		Employee e1= new Employee("santhu",26,3000.00,"MANAGER","rajam",10000.0);
		Employee e2= new Employee("shruthi",23,1000.00,"HR","guntur",10000.0);
		Employee e3= new Employee("smitha",24,6000.00,"HR","vskp",60000.0);
		Employee e4= new Employee("sandhya",25,5000.00,"MANAGER","rjy",50000.0);
		Employee e5= new Employee("aadhya",25,5000.00,"HR","godavari",100000);
		
		List<Employee> lst=Arrays.asList(e1,e2,e3,e4,e5);
		
		List<Employee> emps= lst.stream().sorted(Comparator.comparingDouble(Employee::getEmpsal)).collect(Collectors.toList());
		List<Employee> empsreverse= lst.stream().sorted(Comparator.comparingDouble(Employee::getEmpsal).reversed()).collect(Collectors.toList());

		//empsreverse.forEach(i->System.out.println(i));
		
		double d= lst.stream().filter(e->e.getEmpdep()=="MANAGER").mapToDouble(e->e.getEmpsal()).max().getAsDouble();
		
		//System.out.println(d);
		
		Map<String,Long> emps1 = lst.stream().collect(Collectors.groupingBy(e->e.getEmpdep(),Collectors.counting()));
		//System.out.println(emps1);
	/***	for(Entry<String, Long> entry:emps1.entrySet())
		{
			System.out.println(entry.getKey() + "-" + entry.getValue() );
		}
***/
		
		List<Employee> empsorder= lst.stream().filter(e->e.getEmpcity()=="rajam" && e.getEmpdep()=="HR").sorted(Comparator.comparing(Employee::getEmpname)).collect(Collectors.toList());
		//empsorder.forEach(i->System.out.println(i));
     List<Integer> nums= Arrays.asList(9,2,4,5,1,6,8,9,3);
     List<Integer> lsteven=nums.stream().filter(n->n%2==0).collect(Collectors.toList());
     
     //lsteven.forEach(i->System.out.println(i));
		int sum=nums.stream().mapToInt(n->n).sum();
		//System.out.println(sum);
		int max=nums.stream().mapToInt(n->n).max().getAsInt();
		//System.out.println(max);
		//List<Integer> nums = Arrays.asList(5, 2, 9, 1);

		Optional<Integer> max1 = nums.stream()
		                            .max(Integer::compareTo);
/***
		if (max1.isPresent()) {
		    System.out.println("Max value: " + max1.get());
		} else {
		    System.out.println("No elements in stream");
		}
		//List<Integer> nums = Arrays.asList(5, 2, 9, 1);

		Optional<Integer> min = nums.stream()
		                            .min(Integer::compareTo);

		if (min.isPresent()) {
		    System.out.println("Max value: " + min.get());
		} else {
		    System.out.println("No elements in stream");
		}
		***/
		int n=4;
		long count=nums.stream().filter(i-> i>n).count();
		//System.out.println(count);
		List<String> strings=Arrays.asList("santhu","manisha","ramya","chaitu","sai");
		List<String> lststr= strings.stream().map(s->s.toUpperCase()).collect(Collectors.toList());
		//lststr.forEach(i->System.out.println(i));
		List<Integer> lst1= nums.stream().sorted().collect(Collectors.toList());
		//lst1.forEach(i->System.out.println(i));
		List<Integer> lst2= nums.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		//lst2.forEach(i->System.out.println(i));
		String s="saannsthuu";
		//Optional<Character> ch= s.chars().mapToObj(c->(char)c).distinct().findFirst();
		//System.out.println(ch);
		
		//HashMap<Character,Integer> freq= new HashMap<Character,Integer>();
		Map<Character,Long> map1=s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,Collectors.counting()));
		Optional<Character> ch= s.chars().mapToObj(c->(char)c).filter(c->map1.get(c)==1).findFirst();
		//System.out.println(ch.orElse(null));

		Optional<Integer> n1= nums.stream().sorted(Comparator.reverseOrder()).distinct().skip(1).findFirst();
		//System.out.println(n1.orElse(null));
        Map<Boolean, List<Integer>> l1= nums.stream().collect(Collectors.partitioningBy(k->k%2==0 ?true :false));
        Map<String, List<Integer>> l2= nums.stream().collect(Collectors.groupingBy(k->k%2==0 ? "even" : "odd"));

		//System.out.println(l1);
		//System.out.println(l2);

		String s1="saaanntheu";
		Map<Character,Long> map2= s1.chars().mapToObj(c-> (char)c).collect(Collectors.groupingBy(c->c,Collectors.counting()));
		//System.out.println(map2);
		/***for(Entry<Character,Long> entry1:map2.entrySet())
		{
			System.out.println(entry1.getKey() + "-" + entry1.getValue());

		}***/
		
		double d1= nums.stream().mapToDouble(t->t).average().getAsDouble();
		
		//System.out.println(d1);
		
		String sent= "i am santhu and i am currently preparin for the interview";
		
		String[] words= sent.split(" ");
		
		String s3= Arrays.stream(words).sorted(Comparator.reverseOrder()).findFirst().get();
		
		Integer s4= Arrays.stream(words).map(String::length).sorted(Comparator.reverseOrder()).findFirst().get();
		//Arrays.stream(words).map(String::length).forEach(i->System.out.println(i));
		//System.out.println(s4);
		String s5= Arrays.stream(words).sorted(Comparator.comparing(String::length).reversed()).findFirst().get();
        Optional<String> s6= Arrays.stream(words).max(Comparator.comparingInt(String::length));
     /***   if(s6.isPresent())
        {
    		System.out.println(s6.get());

        }***/
	String s7= Arrays.stream(words).sorted((String::compareTo)).findFirst().get();
	//System.out.println(s7);
	String s8= Arrays.stream(words).sorted((g1,g2)->Integer.compare(g2.length(),g1.length())).findFirst().get();
	//System.out.println(s8);

	//String str=Arrays.stream(words).map(t->new StringBuilder(t).reverse().toString()).collect(Collectors.joining(" "));
    //System.out.println(str);
		
	/*** Map<String, String> stats = lst.stream()
	            .collect(Collectors.toMap(
	                e -> e.empcity,
	                e -> e.citypopulation <=10000 ? "small"
	                     : (e.citypopulation == 50000 ? "medium"
	                     : (e.citypopulation > 50000 ? "high"
	                     : "other"))
	            ));
	 
	 stats.forEach((k,v)-> System.out.println(k + "-" + v));
    	***/
	
	Map<String,String> stat=lst.stream().collect(Collectors.groupingBy(
			
			e-> 
			e.citypopulation<=10000? "small"
					:(e.citypopulation==50000 ?"medium"
					:(e.citypopulation>50000? "high":"other")),
					Collectors.mapping(e->e.empcity,Collectors.joining(","))
				));
	// stat.forEach((k,v)-> System.out.println(k + "-" + v));
	
	//String base64Secret = Base64.getEncoder().encodeToString(hexStringToByteArray("357638792F423F4428472B4B6250655368566D597133743677397A2443264629"));
	//System.out.println(base64Secret);

	
	}
	

}
