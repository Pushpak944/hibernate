package com.ty.one_to_one_uni.controller;

import java.util.Scanner;

import com.ty.one_to_one_uni.dao.Persondao;
import com.ty.one_to_one_uni.dto.Aadhar_card;
import com.ty.one_to_one_uni.dto.Person;

import net.bytebuddy.agent.builder.AgentBuilder.DescriptionStrategy.Default;

public class PersonMain1 {

	public static void main(String[] args) {
		boolean flag=true;
		// TODO Auto-generated method stub
		do{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the choice ,\n 1 to insert all person,\n 2 to update all,\n 3 to delete all,\n 4 to getall person,\n 5 to get all person in list,\n 6 to exit");
		int choice=sc.nextInt(); 
		switch(choice){
		case 1:{
			System.out.println("Person details");
			System.out.println("Enter the id");
			int id=sc.nextInt();
			System.out.println("Enter the name");
			String name=sc.next();
			System.out.println("Enter the address");
			String address=sc.next();
			System.out.println("Enter the phone");
			long phone=sc.nextLong();
			Person person=new Person();
			person.setId(id);
			person.setAddress(address);
			person.setPhone(phone);
			person.setName(name);
			
			System.out.println("aadhar details");
			System.out.println("Enter the aid");
			int aid=sc.nextInt();
			System.out.println("Enter the address");
			String address1=sc.next();
			System.out.println("Enter the name");
			String name1=sc.next();
			Aadhar_card aadhar_card=new Aadhar_card();
			aadhar_card.setAid(aid);
			aadhar_card.setName(name1);
			aadhar_card.setAddress(address1);
			
			//sending all attributes from aadhar to person
			person.setAadharcard(aadhar_card);
			Persondao persondao=new Persondao();
			persondao.saveperson(person);
			
			break;
		}
		case 2:{
			System.out.println("Enter the id");
			int id=sc.nextInt();
			System.out.println("Enter the name");
			String name=sc.next();
			System.out.println("Enter the address");
			String address=sc.next();
			System.out.println("Enter the phone");
			long phone=sc.nextLong();
			Person person=new Person();
			person.setId(id);
			person.setAddress(address);
			person.setPhone(phone);
			person.setName(name);
			
			System.out.println("aadhar details");
			System.out.println("Enter the aid");
			int aid=sc.nextInt();
			System.out.println("Enter the address");
			String address1=sc.next();
			System.out.println("Enter the name");
			String name1=sc.next();
			Aadhar_card aadhar_card=new Aadhar_card();
			aadhar_card.setAid(aid);
			aadhar_card.setName(name1);
			aadhar_card.setAddress(address1);
			person.setAadharcard(aadhar_card);
			Persondao persondao=new Persondao();
			persondao.updatePerson(person);
			break;
		}
		case 3:
		{
			System.out.println("Enter the id");
			int id=sc.nextInt();
			Persondao persondao=new Persondao();
			persondao.deletePerson(id);
			break;
		}
		case 4:
		{
			System.out.println("Enter the id");
			int id=sc.nextInt();
			Persondao persondao=new Persondao();
		System.out.println(	persondao.getdetails(id));
			break;
		}
		case 5:
		{
			Persondao persondao=new Persondao();
			System.out.println(persondao.getDetailsPerson());
				break;
		}
		case 6:
		{
			flag=false;
			System.out.println("thank you");
		}
		
	}

}while(flag);
}
}