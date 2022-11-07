package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Mentor;
import app.service.MentorService;

@RestController
@RequestMapping("/mentors")
public class MentorController {
	@Autowired
	private MentorService service;
	
	@GetMapping()
	public List<Mentor> getAll(){
		return service.getAllMentor();
	}
	
	@GetMapping("/{id}")
	public Mentor getOne(@PathVariable String id) {
		return service.getOneMentor(id);
	}
	
	@PostMapping()
	public Mentor addMentor(@RequestBody Mentor men) {
		return service.addMentor(men);
	}
}
