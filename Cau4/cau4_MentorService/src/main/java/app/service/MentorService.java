package app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Mentor;

@Service
public interface MentorService {
	Mentor getOneMentor(String id);
	List<Mentor> getAllMentor();
	Mentor addMentor(Mentor mentor);
}
