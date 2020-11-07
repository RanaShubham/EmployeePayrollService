package com.bridgelabz.employeepayrolltest;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.employepayrollservice.EmployeePayrollData;
import com.bridgelabz.employepayrollservice.EmployeePayrollService;

import static com.bridgelabz.employepayrollservice.EmployeePayrollService.IOService.FILE_IO;;

public class EmployeePayrollServiceTest 
{
	@Test
	public void given3Employees_whenWrittenToFile_shouldMatchEmployeeEntries()
	{
		EmployeePayrollData[] arraysOfEmps = {
				new EmployeePayrollData(1, "Shubham", 100000.0),
				new EmployeePayrollData(2, "Rajat", 500000.0),
				new EmployeePayrollData(3, "Mayank", 700000.0)
		};
		
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(Arrays.asList(arraysOfEmps));
		employeePayrollService.writeEmployeePayrollData(FILE_IO);
		employeePayrollService.print(FILE_IO);
		
		long entries = employeePayrollService.countEntries(FILE_IO);
		Assert.assertEquals(3, entries);
	}
	
	@Test
	public void givenFile_OnReadingFromFile_shoullMatchEmployeeCOunt()
	{
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		long entries = employeePayrollService.readEmployeePayrollData(FILE_IO);
		Assert.assertEquals(3, entries);
	}
}
