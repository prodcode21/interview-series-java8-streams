package com.set1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class Set1 {

	public static void main(String args[]) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 45, 46, 3, 44, 55, 49, 555);
		

		// printing sum of all numbers
		//1+2=3
		//3+3=6
		//6+45................
		
		int sum = numbers.stream().reduce((a,b)->a+b).get();

		//System.out.println(sum);
		
		//average of the numbers
		//transform == map --->Function interface
		
		double d =numbers.stream().mapToDouble(n->n).average().getAsDouble();
//		System.out.println(d);
		
		//even and odd
		
		//separate ==filter==condition
		
		List<Integer> list = numbers.stream().filter(n->n%2==0).toList();
		//System.out.println(list);
		
		//odd
		
		List<Integer> list2 = numbers.stream().filter(n->n%2!=0).toList();
//		System.out.println(list2);
		
		//starts with four
	
		List<String> list3 = numbers.stream().map(n->n.toString()).filter(n->n.startsWith("4")).toList();
		//System.out.println(list3);
		
		//skip
		
		List<Integer> list4 = numbers.stream().skip(2).toList();
		//System.out.println(list4);
		
		//statistics
		
		DoubleSummaryStatistics summaryStatistics = numbers.stream().mapToDouble(n->n).summaryStatistics();
		//System.out.println(summaryStatistics);
		
		//max and min
		
		Integer integer = numbers.stream().max(Comparator.comparing(Integer::valueOf)).get();
		//System.out.println(integer);
		
		Integer integer2 = numbers.stream().min(Comparable::compareTo).get();
		//System.out.println(integer2);
		
		
		//asc and desc
		
		 List<Integer> list5 = numbers.stream().sorted().toList();
		 //System.out.println(list5);
		 
		 //desc
		 
		 List<Integer> list6 = numbers.stream().sorted(Comparator.reverseOrder()).toList();
		 //System.out.println(list6);
		
		 
		 //second highest
		 
		Integer integer3 = numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println(integer);
		 
		//second lowest
		
		Integer integer4 = numbers.stream().sorted().skip(1).findFirst().get();
		
		System.out.println(integer2);
	}

}
