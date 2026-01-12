package edu.jsp.Employee_.Management._System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.Employee_.Management._System.entity.Employee;
import edu.jsp.Employee_.Management._System.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	  private EmployeeService service;
	  
	  //save the data 
	  @PostMapping
	  public Employee saveEmployee(@RequestBody Employee e)
	  {
		  return service.saveEmployee(e);
	  } 
	  
	  //get Employee by id
	  @GetMapping("/{id}")
	  public Employee findById(@PathVariable Long id)
	  {
		  return service.findById(id);
	  }
	  
	  //get all employee
	  @GetMapping
	  public List<Employee> findAll()
	  {
		  return service.findAll();
	  }
	  
	//delete employee
	  @DeleteMapping("/{id}")
	  public String deleteById(@PathVariable Long id) 
	  {
		  return service.deleteById(id);
	  }
	  
	  //update the data
	  @PutMapping("/{id}")
	  public String updateDetails(@PathVariable Long id,@RequestBody Employee e)
	  {
		  return service.updateDetails(id, e);
	  }

}
