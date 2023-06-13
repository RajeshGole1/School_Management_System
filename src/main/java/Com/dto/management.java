package Com.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class management {
@Id
private int id;
private String email;
private String password;

@OneToMany
private List<Teacher> teacher;

@OneToMany
private List<Student> student;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public List<Teacher> getTeacher() {
	return teacher;
}

public void setTeacher(List<Teacher> teacher) {
	this.teacher = teacher;
}

public List<Student> getStudent() {
	return student;
}

public void setStudent(List<Student> student) {
	this.student = student;
}

}
