package com.Solution.in.contrllr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Solution.in.model.Employee;
import com.Solution.in.repostry.EmployeeRepository;
@CrossOrigin(origins= {"http://localhost:3000"})
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository repo;
	
	@GetMapping("/employees")
	public List<Employee>getAllEmployees(){
		return repo.findAll();
	}
	// create employees rest api
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return repo.save(employee);
	}
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
	    try {
	        // Check if the employee exists
	        if (!repo.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }

	        // Delete the employee
	        repo.deleteById(id);

	        return ResponseEntity.ok().build();
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}
}

