package app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import app.entity.Mentor;
import app.repository.MentorRepository;
@Service
@Transactional
public class MentorServiceImple implements MentorService {
	private static final String REDIS_CACHE_VALUE = "mentor";
	@Autowired
	private MentorRepository repo;
	
	 @Autowired
	    private RedisTemplate template;
	@Override
	public Mentor getOneMentor(String id) {
		Mentor mentor =  null;
		mentor = (Mentor) template.opsForHash().get(REDIS_CACHE_VALUE, id);
		if(mentor != null)
			return mentor;
		System.out.println("get from db...");
		mentor = repo.findById(id).get();
		if(mentor.getId()!= null)
			template.opsForHash().put(REDIS_CACHE_VALUE, mentor.getId(), mentor);
		return mentor;
	}

	@Override
	public List<Mentor> getAllMentor() {
		List<Mentor> ls =(List<Mentor>) template.opsForHash().values(REDIS_CACHE_VALUE);
		if(ls.size() > 0)
			return ls;
		ls = repo.findAll();
		if(ls.size() > 0) {
			Map<String, Mentor> map = new HashMap<>();
			for(Mentor p : ls) {
				map.put(p.getId(), p);
			}
			if(map.size() > 0)
				template.opsForHash().putAll(REDIS_CACHE_VALUE, map);
		}
			
		
		
		System.out.println("get from db");
		return repo.findAll();
	}

	@Override
	public Mentor addMentor(Mentor mentor) {
		template.opsForHash().put(REDIS_CACHE_VALUE, mentor.getId(), mentor);
		return repo.save(mentor);
	}

}
