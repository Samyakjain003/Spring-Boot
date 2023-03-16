package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService){
		this.employeeService=employeeService;
	}
	// add mapping for "/list"
	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		List<Employee> theEmployees=employeeService.findAll();
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		Employee employee=new Employee();
		theModel.addAttribute("employee",employee);
		return "employees/employee-form";
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){

		Employee employee=employeeService.findById(theId);
		theModel.addAttribute("employee",employee);
		return "employees/employee-form";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId, Model theModel){

		employeeService.deleteById(theId);
		return "redirect:/employees/list";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee){
		employeeService.save(employee);

		return "redirect:/employees/list";
	}
}









