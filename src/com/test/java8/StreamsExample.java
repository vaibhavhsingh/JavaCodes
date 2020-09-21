package com.test.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.test.pojo.Employee;

public class StreamsExample {

	public static void main(String args[]) {
		List<Employee> empList = employeeList();

		System.out.println("\nPrinting Employees...");
		System.out.println("-----------------------------------------");
		printEmployeeList(empList);

		System.out.println("\nSorting by Age...");
		System.out.println("-----------------------------------------");
		sortByAge(empList);

		System.out.println("\nSorting by Salary...");
		System.out.println("-----------------------------------------");
		sortBySalary(empList);

		System.out.println("\nFiltering employees by Salary > 2000000...");
		System.out.println("-----------------------------------------");
		filterEmployees(empList);

		System.out.println("\nGrouping employees by Age...");
		System.out.println("-----------------------------------------");
		groupByAge(empList);
	}

	public static List<Employee> employeeList() {
		List<Employee> employeeList = new ArrayList<>();

		employeeList.add(new Employee("Vaibhav", "Singh", 2400000L, 31));
		employeeList.add(new Employee("Kshipra", "Singh", 1250000L, 28));
		employeeList.add(new Employee("Garima", "Singh", 750000L, 29));
		employeeList.add(new Employee("Gitima", "Singh", 950000L, 29));
		employeeList.add(new Employee("Manoj", "Kumar", 2450000L, 35));
		employeeList.add(new Employee("Harsh", "Kapoor", 1903038L, 35));

		return employeeList;
	}

	public static void printEmployeeList(List<Employee> employeeList) {
		employeeList.forEach((e) -> System.out.println(e));
	}

	public static void printEmployeeList(Stream<Employee> employeeList) {
		employeeList.forEach((e) -> System.out.println(e));
	}

	public static void sortByAge(List<Employee> employeeList) {
		Collections.sort(employeeList, (e1, e2) -> {
			return e1.getAge() - e2.getAge();
		});

		printEmployeeList(employeeList);
	}

	public static void sortBySalary(List<Employee> employeeList) {
		Collections.sort(employeeList, (e1, e2) -> {
			return e1.getSalary().intValue() - e2.getSalary().intValue();
		});
		printEmployeeList(employeeList);
	}

	public static void filterEmployees(List<Employee> employeeList) {
		Stream<Employee> streams = employeeList.stream().filter(e -> e.getSalary() > 2000000);

		printEmployeeList(streams);
	}

	public static void groupByAge(List<Employee> employeeList) {
		Map<Integer, List<Employee>> groupByAge = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getAge));

		System.out.println(groupByAge);
		groupByAge.entrySet().forEach((e) -> printEmployeeList(e.getValue()));
	}
}
