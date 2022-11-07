package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Mentor;
@Repository
public interface MentorRepository extends JpaRepository<Mentor, String> {

}
