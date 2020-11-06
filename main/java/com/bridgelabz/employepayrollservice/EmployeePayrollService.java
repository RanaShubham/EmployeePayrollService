package com.bridgelabz.employepayrollservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {

	public enum IOService {CONSOLE_IO, FILE_IO, DB_IO, REST_IO}
	private List <EmployeePayrollData> employeePayrollList = new ArrayList<>();
	
	public EmployeePayrollService()
	{}
	
	public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList)
	{
		this.employeePayrollList = employeePayrollList;
	}
	
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

	public void writeEmployeePayrollData() 
	{
		System.out.println("\n Writing employee data "+employeePayrollList);
	}

	public void writeEmployeePayrollData(IOService ioService) 
	{
		if(ioService.equals(IOService.CONSOLE_IO))
			System.out.println("\nWriting employee pay roll roaster to console\n"+employeePayrollList);
		else if(ioService.equals(IOService.FILE_IO))
			new EmployeePayrollFileIOService().writeData(employeePayrollList);
	}

	public void print(IOService ioservice) 
	{
		if(ioservice.equals(IOService.FILE_IO))
			new EmployeePayrollFileIOService().printData();
	}

	public long countEntries(IOService ioservice) 
	{
		if(ioservice.equals(IOService.FILE_IO))
			return new EmployeePayrollFileIOService().countEntries();
		else
			return (Long) null;
	}
}
