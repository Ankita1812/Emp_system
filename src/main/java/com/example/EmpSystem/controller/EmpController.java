package com.example.EmpSystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.EmpSystem.entity.Employee;
import com.example.EmpSystem.service.EmpService;
@Controller
public class EmpController {

	@Autowired
	private EmpService service;
	
	
	@GetMapping("/")
	public String home(Model m) {
		List<Employee> emp=service.getAllEmployee();
		
		m.addAttribute("emp", emp);
		
		return "index";
	}
	
	@GetMapping("/addemp")
	public String addEmpForm(){
		return "add_emp";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e,HttpSession session) {
		System.out.println(e);
		session.setAttribute("msg", "Employee Added Successfully...");
		service.addEmp(e);
		return "redirect:/";
	}
	@GetMapping("/edit/{id}")
	public String editEmp(@PathVariable int id,Model m)
	{
		Employee e=service.getEmpByID(id);
		m.addAttribute("emp", e);
		return "edit";
		
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e,HttpSession session)
	{
		service.addEmp(e);
		session.setAttribute("msg", "Emp data updated successfully....");
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id,HttpSession session)
	{
		service.deleteEmp(id);
		session.setAttribute("msg", "Emp data deleted successfully....");
		return "redirect:/";
		
	}
	
}
