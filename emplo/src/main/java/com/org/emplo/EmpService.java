package com.org.emplo;

import org.springframework.http.ResponseEntity;

public interface EmpService {

	public ResponseEntity<?> addEmp(Employee employee);

}
