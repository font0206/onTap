package app.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {
	private String id;
	private String name;
	private int age;
	private MentorDto mentor;
}
