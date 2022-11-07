package app.controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
import io.github.resilience4j.retry.annotation.Retry;

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
	@Retry(name = "mentor")
	public StudentDto getOne(@PathVariable String id) {
		try {
	        System.out.println(Thread.currentThread().getName() + "...retry: "+"time wait  "+
	                LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
	        
	    } catch (Exception e){
	        System.out.println(e.getLocalizedMessage());
	    }
		return service.getOneStudent(id);
	}
	@PostMapping()
	public Student addStu(@RequestBody Student stu) {
		return service.addStudent(stu);
	}
}
