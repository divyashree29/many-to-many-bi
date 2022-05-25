package com.ty.many_to_many_bi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestsaveCourseStudent {

	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Student student = new Student();
		student.setName("Deepa");
		student.setAge(22);
		
		Student student1 = new Student();
		student1.setName("Divya");
		student1.setAge(25);
		
		Course course = new Course();
		course.setName("java");
		course.setDuration(8);
		
		Course course1 = new Course();
		course1.setName("HTML");
		course1.setDuration(7);
		
		List<Student> students1 = new ArrayList<Student>();
		students1.add(student1);
		students1.add(student);
		
		List<Course> courses = new ArrayList<Course>();
		courses.add(course);
		courses.add(course1);
		
		student.setCourse(courses);
		course.setStudent(students1);
		course1.setStudent(students1);
		entityTransaction.begin();
		entityManager.persist(student);
		entityManager.persist(student1);
		entityManager.persist(course);
		entityManager.persist(course1);
		entityTransaction.commit();
		System.out.println("------------------sorry------------------------------");
	}
}
