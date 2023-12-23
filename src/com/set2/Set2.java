package com.set2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Set2 {

	public static void main(String[] args) {

		Employee emp = new Employee("sai", "HR", 45000, "Male", LocalDate.of(2000, 5, 05));
		Employee emp2 = new Employee("krishna", "Accounting", 45000, "Male", LocalDate.of(2002, 2, 02));
		Employee emp3 = new Employee("Anusha", "IT", 60000, "Female", LocalDate.of(2009, 9, 23));
		Employee emp4 = new Employee("Ashok", "IT", 50000, "Male", LocalDate.of(2003, 5, 20));

		List<Employee> emps = new ArrayList<Employee>();
		emps.add(emp);
		emps.add(emp2);
		emps.add(emp3);
		emps.add(emp4);
		
	//male and female
		
		long male =  emps.stream().filter(e->e.getGender().equalsIgnoreCase("Male")).count();
		long female = emps.stream().filter(e->e.getGender().equalsIgnoreCase("Female")).count();
//		System.out.println(male);
//		System.out.println(female);
		
		//print the departments
		List<String> list = emps.stream().map(e->e.getDepartment()).distinct().toList();
		//System.out.println(list);
		
		//maximum salary employee
		Employee emp1 =emps.stream().max(Comparator.comparingDouble(Employee::getSalary)).get();
		//System.out.println(emp1);
		
		//min salary employee
		Employee em = emps.stream().min(Comparator.comparingDouble(Employee::getSalary)).get();
		System.out.println(em);
		
		  //joined after 2000
		
		List<Employee> list2 = emps.stream().filter(e->e.getJoiningDate().getYear() > 2000).toList();
		System.out.println(list2);
		
		
		 //count the Employee in each department
		
		Map<String, Long> collect = emps.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
		System.out.println(collect);
		
		//average salary of each department
		
		Map<String, Double> collect2 = emps.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(collect2);
		
		//most senior it employee 
		
		Employee e1 = emps.stream().min(Comparator.comparing(Employee::getJoiningDate)).get();
		System.out.println(e1);
		
		//male and female in it department
		
		Map<String, Long> collect3 = emps.stream().filter(e->e.getDepartment().equalsIgnoreCase("IT")).collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));

		System.out.println(collect3);
		
		//average salary of male and female
		
		Map<String, Double> collect4 = emps.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(collect);
		
		//total sum and average salary
		DoubleSummaryStatistics summaryStatistics = emps.stream().map(n->n.getSalary()).mapToDouble(n->n).summaryStatistics();
		System.out.println(summaryStatistics);
		
		//sort the employees
		
		
		List<Employee> list4 = emps.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).toList();
		System.out.println(list4);
		
		//top 3 employee
		List<Employee> list5 = emps.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).limit(3).toList();
		System.out.println(list5);
		
		

		
		
	}

}
