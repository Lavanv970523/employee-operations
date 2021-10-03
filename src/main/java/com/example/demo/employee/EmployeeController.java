package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeCrudRepository empRepository;

	@PostMapping("employees")
	public void addEmployee(@RequestBody Employee employee) {
		empRepository.save(employee);
//		employeeService.addEmployee(employee);
	}

	@GetMapping("employees")
	public void getEmployees() {
		employeeService.getEmployees();
	}

	@GetMapping("employees/{id}")
	public void getEmployeeById(@PathVariable Integer id) {
		employeeService.getEmployeeById(id);
	}

	@PutMapping("employees/{id}")
	public void updateEmployees(@PathVariable Integer id, @RequestBody Employee employee) {
		employeeService.updateEmployees(employee, id);
	}

	@DeleteMapping("employees/{id}")
	public void deleteEmployee(@PathVariable Integer id) {
		employeeService.deleteEmployee(id);
	}

}
