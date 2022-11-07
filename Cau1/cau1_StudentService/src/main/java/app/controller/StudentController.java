package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dto.StudentDto;
import app.entity.Student;
import app.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService service;
	
	@GetMapping()
	public List<Student> getAll(){
		return service.getAllStudent();
	}
	@GetMapping("/{id}")
	public StudentDto getOne(@PathVariable String id) {
		return service.getOneStudent(id);
	}
	@PostMapping()
	public Student addStu(@RequestBody Student stu) {
		return service.addStudent(stu);
	}
}
