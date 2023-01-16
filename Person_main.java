package com.ty.one_to_one_uni.dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



public class Person_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Aadhar_card aadharcard=new Aadhar_card();
		aadharcard.setAid(1);
		aadharcard.setName("satish");
		aadharcard.setAddress("vartur");
		
		Person person=new Person();
		person.setId(2);
		person.setName("rahul");
		person.setPhone(277373747);
		person.setAddress("nagawara");
		person.setAadharcard(aadharcard);
		
		entityTransaction.begin();
		entityManager.persist(aadharcard);
		entityManager.persist(person);
		entityTransaction.commit();
	}

}
