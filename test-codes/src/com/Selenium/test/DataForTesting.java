package com.Selenium.test;

import org.testng.annotations.DataProvider;

public class DataForTesting {

	@DataProvider(name = "loginData")
	public Object[][] login() {
		Object[][] dataset = { 
				{ "nishant.singh.iem@gmail.com", "Nishant@123", "positive" },
				{ "nishant.singh.iem@gmail.com", "", "negative" },
				{ "abc", "xyz", "negative" },
				{"Akash@gmail.com","Akash@123","positive"},
				{"nishant.singhiem@gmail.com","Nishant@123","negative"}
				};
		return dataset;
	}

	@DataProvider(name="registerData")
	public Object[][] register()
	{
		Object [][]dataset= {
				{"Akash","Banerjee","9234567890","Akash@123","Akash@gmail.com","positive"},
				{"Nishant","Singh","1234","Nishant@123","Nishant@gmail.com","negative"},
				{"        ","kumar","9083258478","kumar@123","kumar@gmail.com","negative"},
				{"1234","kumar","9234567899","abcdef$23","rohit@gmail.com","negative"},
				{"abhijit$","kumar","9234348923","abhijit%100","abhijit@gmail.com","negative"},
				{"******","kumar","9287438923","kumar@123","kumar@gmail.com","negative"},
				{"abhishek23","kumar","8234596033","abhishek123","abhishek23@gmail.com","negative"},
				{"abhiraj","1234","8975348753","abhiraj#124","abhiraj@gmail.com","negative"},
				{"abhishek","kumar","723 567890","abhishek123","abhishek@gmail.com","negative"},
				{"abhinav","kumar","7A34567890","Abhinav123","abhinav@gmail.com","negative"}
			};
		return dataset;
	}
	@DataProvider(name="FilterByMarks")
	public Object[] filterByMarks()
	{
		Integer dataset[]= {0,1,6,10};
		return dataset;
	}
	@DataProvider(name="FilterBySubjectName")
	public String[] filterBySubject()
	{
		String []arr = {"PYTHON","JAVA","DBMS","CN","OS","cn","python"};
		return arr;
	}
	@DataProvider(name="FilterByStudentName")
	public String [] filterByStudent()
	{
		String arr[] = {"nishant","Nishant","akash","rishav"};
		return arr;
	}
	@DataProvider(name="ProfileTestData")
	public Object[][] profile()
	{
		Object [][]obj = {
				{"nishant.singh.iem@gmail.com","Nishant@123"},
				{"Akash@gmail.com","Akash@123"}
		} ;
		return obj;
	}
}