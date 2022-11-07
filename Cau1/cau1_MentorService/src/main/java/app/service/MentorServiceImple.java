package app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Mentor;
import app.repository.MentorRepository;
@Service
@Transactional
public class MentorServiceImple implements MentorService {
	@Autowired
	private MentorRepository repo;
	@Override
	public Mentor getOneMentor(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public List<Mentor> getAllMentor() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Mentor addMentor(Mentor mentor) {
		// TODO Auto-generated method stub
		return repo.save(mentor);
	}

}
