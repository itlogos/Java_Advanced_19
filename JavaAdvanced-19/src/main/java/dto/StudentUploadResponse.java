package dto;

import java.util.Base64;

import domain.Student;

public class StudentUploadResponse {

	private String name;
	private String surname;
	private int age;
	private String base64Image;

	public StudentUploadResponse(String name, String surname, int age, String base64Image) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.base64Image = base64Image;
	}

	public StudentUploadResponse(Student student) {
		this.name = student.getFirstName();
		this.surname = student.getLastName();
		this.age = student.getAge();
		this.base64Image = Base64.getEncoder().encodeToString(student.getPhoto().getData());

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
}
