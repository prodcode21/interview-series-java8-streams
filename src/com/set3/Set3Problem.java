package com.set3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Set3Problem {

	public static void main(String[] args) {

		String str = "prodtechchannel";

		List<String> arr = Arrays.asList(str.split(""));

		//System.out.println(arr);
		//print the keys whose value greater than 1
		 Map<String, Long> collect = arr.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(collect);
		
		List<String> list = arr.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(n->{return n.getValue() > 1;})
		.map(Map.Entry::getKey).toList();
		//System.out.println(list);
		
		//print the keys whose value equal 1
		
		String string = arr.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(n->{return n.getValue() == 1;})
		.map(Map.Entry::getKey).findFirst().get();
		System.out.println(string);
	
		
		
	}

}
