package service;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Student;
import repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public void save(Student student) {
		studentRepository.save(student);
	}
	
	public Student readById(String id) throws FileNotFoundException {
		return studentRepository.findById(id).orElseThrow(() -> new FileNotFoundException("There is no student with id = "+ id));
	}
}
