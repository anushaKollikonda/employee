package com.org.emplo;

import java.io.Serializable;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;



public interface SalaryRepo extends JpaRepository<Salary, Serializable> {

	List<Salary> findByEmpIdAndCrDateBetween(int id, String april, String march);


}
