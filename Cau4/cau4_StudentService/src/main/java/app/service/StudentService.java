package app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import app.dto.StudentDto;
import app.entity.Student;
@Service
public interface StudentService {
	StudentDto getOneStudent(String id);
	List<Student> getAllStudent();
	Student addStudent(Student stu);
	
}
