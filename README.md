# employee
this is the logic , that i have implemented i that api, i dont have database in my lapi. i m unable to connect to sql server
package com.coreJava;, i tried today also 

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class empSalary {

	public static void main
	(String[] args) {
		String l= "2022-04-01";
		String doj="2022-06-15";
		long salary = 300000;
		long totalSalary=0;
		double cess= 0;
	 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate calCulationStart = LocalDate.parse(l, formatter);
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
		
	}
		
	
}
