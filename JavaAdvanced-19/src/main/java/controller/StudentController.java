package controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import domain.Photo;
import domain.Student;
import dto.StudentUploadResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/register")
	public StudentUploadResponse registerStudent(@RequestParam("photo") MultipartFile file, HttpServletRequest req,
			HttpServletResponse response) throws IOException, ServletException {
		String name = req.getParameter("name");
		String surname = req.getParameter("surname");
		int age = Integer.parseInt(req.getParameter("age"));

		String photoName = StringUtils.cleanPath(file.getOriginalFilename());
		String type = file.getContentType();
		byte[] data = file.getBytes();

		Photo photo = new Photo(photoName, type, data);

		Student student = new Student(name, surname, age, photo);
		photo.setStudent(student);
		student.setPhoto(photo);
		studentService.save(student);

		StudentUploadResponse studentUploadResponse = new StudentUploadResponse(student);

		return studentUploadResponse;
	}
}
