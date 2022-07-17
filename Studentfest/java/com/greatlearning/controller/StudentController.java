package com.greatlearning.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.entity.Student;
import com.greatlearning.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService service;

	@RequestMapping("/list")
	public String listStudents(Model model) {

		List<Student> students = service.findAll();
		model.addAttribute("Students", students);

		return "list-Students";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Student student = new Student();
		model.addAttribute("Student", student);

		return "showFormForAdd";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int id, Model model) {
		Student student = service.findById(id);
		model.addAttribute("Student", student);

		return "showFormForUpdate";
	}

	@PostMapping("/save")
	public String save(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("course") String course,
			@RequestParam("country") String country) {

		Student student;
		if (id != 0) {
			student = service.findById(id);
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setCountry(country);
			student.setCourse(course);
		} else {

			student = new Student(firstName, lastName, course, country);
		}
		service.save(student);
		return "redirect:/student/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int id) {
		service.deleteById(id);
		return "redirect:/student/list";

	}

	@RequestMapping("/403")
	public ModelAndView accessDeniedFunctionality(Principal principal)

	{
		ModelAndView modelAndView = new ModelAndView();
		if (principal != null) {

			modelAndView.addObject("Hello", principal.getName() + "You don't have permission to access this page");
		} else {

			modelAndView.addObject("Hello ,You don't have permission to access this page");
		}
		modelAndView.setViewName("403");

		return modelAndView;

	}
}
