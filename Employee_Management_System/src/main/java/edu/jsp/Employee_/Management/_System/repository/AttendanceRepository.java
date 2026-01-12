package edu.jsp.Employee_.Management._System.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.jsp.Employee_.Management._System.entity.Attendance;

@Repository 
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
	
	@Query(value = "SELECT a FROM Attendance a " +
		       "WHERE a.employee.id = ?1 " +
		       "AND a.date BETWEEN ?2 AND ?3")
List<Attendance> findByEmployeeIdAndDateBetween(Long empId,LocalDate st, LocalDate end );

}
