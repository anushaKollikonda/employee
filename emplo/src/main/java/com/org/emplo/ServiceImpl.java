package com.org.emplo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("EmpService")
public class ServiceImpl implements EmpService{
	@Autowired
	Repo repo;
	
	@Autowired
	SalaryRepo sr;

	@Override
	public ResponseEntity<?> addEmp(Employee employee) {
		ResponseEntity r =null;
		String message ="";
		
		// phone numbers are separted by commas 
		 if(employee.getPhoneNo().contains(",")) {
			 String[] no=employee.getPhoneNo().split(",");
			 for(String numbers : no) {
				 if(numbers.length()==10) {
					 
				 }else {
					 message="please check the number";
				 }
				 
			 }
		 }
		 else {
			 if(employee.getPhoneNo().length()!=10) {
				 message ="pls check the number";
				 
			 }
		 }
		
		 if(!employee.getGmail().endsWith(".com")) {
			message ="pls check the email address " ;
		 }
			 
		 if(message.isEmpty()) {
			   repo.save(employee);
			   r = new ResponseEntity("added successfully", HttpStatus.OK);
		 }else {
			 r =new ResponseEntity(message,HttpStatus.BAD_REQUEST);
	
		 }
		
	return  r;
	
	}
	
//	public List<Taxpojo> employeeList(){
//		List<Taxpojo> li = new ArrayList<>();
//		List<Employee> e= repo.findAll();
//		String april= "01-04-2022";
//		String  march="31-03-2022";
//		
//		  for(Employee emp : e) {
//			  List<Salary> sa = sr.findByEmpIdAndCrDateBetween(emp.getId(),april,march);
//			      long totalAmount =0;
//			       for(Salary moSalary : sa) {
//			    	   totalAmount = totalAmount+moSalary.getSalary();
//			       }
//			       
//			       if()
//			  
//			  
//		  }
//		
//		return li;
//		
//		
//	}
	
 public List<Taxpojo> l(){
	 List<Taxpojo> tp = new ArrayList<>();
	 List<Employee> empList = repo.findAll();
	  for(Employee emp : empList) {
		  Taxpojo pojo= new Taxpojo();
		  String  aprilStartDate="2022-04-01"; 
			String doj=emp.getDoj();
			long salary = emp.getSalary();
			long totalSalary=0;
			double cess= 0;
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate calCulationStart = LocalDate.parse(aprilStartDate, formatter);
	        System.out.println(calCulationStart);
	      LocalDate joiningDate= LocalDate.parse(doj, formatter);
	       long daysDiff = ChronoUnit.DAYS.between(calCulationStart,joiningDate);
	       System.out.println(daysDiff);
		if(daysDiff<0) {
			totalSalary= 12*salary;
		
				
			}else {
				 long onedaySalary = salary/30;
				 totalSalary =12*salary;
				long  minusalary =onedaySalary * daysDiff;
				totalSalary = totalSalary-minusalary;
				 
			}
			System.out.println(totalSalary);
			double tax=0;
			if(totalSalary<=250000) {
				
			}else {
				if(totalSalary>250000 && totalSalary<=500000) {
					tax =  0.05*totalSalary;
				}else {
					if(totalSalary>500000 && totalSalary<1000000){
						tax = 0.1 * totalSalary;
						
					}else {
						tax =0.2 * totalSalary;
					}
				}
					
				
			}
			if(totalSalary>2500000) {
				cess =0.02 * totalSalary;
			}
			System.out.println(tax);
			System.out.println(cess);
			
			pojo.setCess(cess);
			pojo.setEmpid(emp.getId());
			pojo.setFirstName(emp.getFirstName());
			pojo.setLastName(emp.getLastName());
			pojo.setTax(tax);
			pojo.setTotalSalary(totalSalary);
			
			tp.add(pojo);
		}
		  
	 
	  
	 
	 
	 return tp;
 }
}
