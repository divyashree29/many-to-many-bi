package com.ty.many_to_many_bi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class TestSavePersonCab {
	
    public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Person person = new Person();
		
		person.setName("Divya");
		person.setAge(25);
		person.setEmail("div@gmail.com");
		
		Person person1 = new Person();
		
		person1.setName("Rani");
		person1.setAge(23);
		person1.setEmail("rani@gmail.com");
		
		List<Person> persons = new ArrayList<Person>();
		persons.add(person);
		persons.add(person1);
		
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
		Cab cab = new Cab();
		cab.setDrivername("priya");
		cab.setCost(950.00);
		cab.setPersons(persons);
		
		
		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(person1);
		entityManager.persist(cab);
		entityTransaction.commit();	
	}
}
