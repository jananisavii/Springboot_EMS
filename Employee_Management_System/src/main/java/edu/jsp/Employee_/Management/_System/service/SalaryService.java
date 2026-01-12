package edu.jsp.Employee_.Management._System.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.Employee_.Management._System.entity.Attendance;
import edu.jsp.Employee_.Management._System.entity.Employee;
import edu.jsp.Employee_.Management._System.repository.AttendanceRepository;
import edu.jsp.Employee_.Management._System.repository.EmployeeRepository;

@Service
public class SalaryService {
	
	@Autowired
    private AttendanceRepository attendRepo;
    
	@Autowired
    private EmployeeRepository empRepo;
	
	public double calculateSalary(Long empId, LocalDate st, LocalDate end)
	{
		if (!st.getMonth().equals(end.getMonth()) || st.getYear() != end.getYear()) {
		    return -1;
		}

		  Optional<Employee> o = empRepo.findById(empId);
		  if(o.isPresent())
		  {
			 List<Attendance> li = attendRepo.findByEmployeeIdAndDateBetween(empId, st, end);
			 
		     int count=0;
			 for(Attendance a:li) 
			 {    
				
				 if(a.getStatus().equalsIgnoreCase("absent"))
				 {
					 count++;
				 }
			 }
			Employee e = o.get();
			double monSal= e.getSalary();
			long totalDays = st.lengthOfMonth();
			double finalSal= monSal-(count*(monSal/totalDays));
			return finalSal;
			 
		  }
		  return -2;
	}

}
