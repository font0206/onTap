package app.service;

import java.util.List;

import app.entity.Student;

public interface StudentService {
	Student getOneStudent(String id);
	List<Student> getAllStudent();
	Student addStudent(Student stu);
	
}
