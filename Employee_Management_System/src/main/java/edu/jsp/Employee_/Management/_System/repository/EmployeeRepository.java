package edu.jsp.Employee_.Management._System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.jsp.Employee_.Management._System.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	   //save(e)
	   //findByid(id)
	   //findAll
		//deleteById(id)

}
