package com.greatlearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.entity.Student;
import com.greatlearning.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository repository;

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Student findById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public void save(Student student) {

		repository.save(student);

	}

	@Override
	public void deleteById(int id) {

		repository.deleteById(id);

	}

}
