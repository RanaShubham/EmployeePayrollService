package com.bridgelabz.employepayrollservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {

	public enum IOSerive {CONSOLE_IO, FILE_IO, DB_IO, REST_IO}
	private static List <EmployeePayrollData> employeePayrollList = new ArrayList<>();
	
	public EmployeePayrollService()
	{}
	
	public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList)
	{}
	
	public static void main(String[] args) 
	{
		ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
		
		Scanner consoleInputReader = new Scanner(System.in);
		employeePayrollService.readEmployeePayrollData(consoleInputReader);
		employeePayrollService.writeEmployeePayrollData();
	}
	private void readEmployeePayrollData(Scanner consoleInputReader) 
	{
		System.out.println("Enter employee id");
		int id = consoleInputReader.nextInt();
		System.out.println("Enter employee Name");
		String name = consoleInputReader.next();
		System.out.println("Enter employee Salary");
		double salary = consoleInputReader.nextDouble();
		
		employeePayrollList.add(new EmployeePayrollData(id, name, salary));
	}

	private void writeEmployeePayrollData() 
	{
		System.out.println("\n Writing employee data "+employeePayrollList);
	}
}
