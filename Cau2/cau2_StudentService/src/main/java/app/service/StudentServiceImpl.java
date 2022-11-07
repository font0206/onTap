package app.service;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import app.dto.MentorDto;
import app.dto.StudentDto;
import app.entity.Student;
import app.repository.StudentRepository;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository repo;
	@Autowired
	private RestTemplate restTemplate;
	@Override
	public StudentDto getOneStudent(String id) {
		HttpHeaders headers = new HttpHeaders();
		
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<String> entity = new HttpEntity<String>(headers);
		Student stu = repo.findById(id).get();
		String mentorId = stu.getMentorId();
		MentorDto mentorDto = restTemplate.exchange("http://localhost:4001/mentors"
	    		  .concat("/")
	    		  .concat(mentorId),
	    		  	HttpMethod.GET, 
					 entity, 
					 MentorDto.class
					).getBody();
		StudentDto stuDto = StudentDto.builder()
				.id(stu.getId())
				.name(stu.getName())
				.age(stu.getAge())
				.mentor(mentorDto)
				.build();
		
		return stuDto;
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
