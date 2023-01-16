package com.ty.one_to_one_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mysql.cj.Query;
import com.ty.one_to_one_uni.dto.Aadhar_card;
import com.ty.one_to_one_uni.dto.Person;

public class Persondao {

	public EntityManager geEntityManager()
	{
		EntityManagerFactory enManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=enManagerFactory.createEntityManager();
		return entityManager;
	}
	
	public void saveperson(Person person)
	{
		EntityManager entityManager=geEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(person.getAadharcard());
		entityTransaction.commit();
	}
	
	public void updatePerson(Person person)
	{
		EntityManager entityManager=geEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(person);
		entityManager.merge(person.getAadharcard());
		entityTransaction.commit();
	}
	public void deletePerson(int id)
	{
		EntityManager entityManager=geEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Person person=entityManager.find(Person.class, id);
		if(person!=null)		
		{			
			entityTransaction.begin();
			Aadhar_card card=person.getAadharcard();
			entityManager.remove(person);
			//entityManager.remove(person.getAadharcard());
			entityTransaction.commit();
		}
		
		
	}
	public Person getdetails(int id)
	{
		EntityManager entityManager=geEntityManager();
		Person person=entityManager.find(Person.class, id);
		return person;
	}
	public List<Person> getDetailsPerson()
	{
		EntityManager entityManager=geEntityManager();
		javax.persistence.Query query=entityManager.createQuery("select a from Person a");
		List<Person> list =query.getResultList();
		return list;
		
	}
	
}
	

