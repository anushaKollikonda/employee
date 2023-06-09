package com.org.emplo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class EmpController {
	
	@Autowired
	EmpService s;
	
	@RequestMapping(value={"/addEmp"},method = RequestMethod.POST)
    public ResponseEntity<?>  addEmp(@RequestBody Employee employee)
    {
      return    null;
    }

}
