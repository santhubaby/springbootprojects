package practice.streams;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stringreverse {
	public static void main(String[] args) {
		String s="iam santhu currently preparingforexam";
		String s1=s.chars().mapToObj(n->String.valueOf((char)n)).sorted(Comparator.reverseOrder()).collect(Collectors.joining(""));
  System.out.println(s1);
  
  String s2= IntStream.range(0, s.length()).mapToObj(n->String.valueOf(s.charAt(s.length()-n-1))).collect(Collectors.joining(""));
  System.out.println(s2);
}
}
