package app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Student;
import app.repository.StudentRepository;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository repo;
	@Override
	public Student getOneStudent(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Student addStudent(Student stu) {
		// TODO Auto-generated method stub
		return repo.save(stu);
	}

}
