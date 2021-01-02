package com.audi.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.audi.entity.Employee;

public class Main {

	public static void main(String[] args) {
		Employee employee=new Employee();
		employee.setName("Ethan Hunt");
		employee.setDepartment("Mechanical");
		employee.setAge(35);
		
		Employee employee2=new Employee();
		employee2.setName("Jack Ryan");
		employee2.setDepartment("Electrical");
		employee2.setAge(32);
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Emp_Test");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		//CREATE ENTITY
		entityTransaction.begin();
		entityManager.persist(employee);
		entityManager.persist(employee2);
		entityTransaction.commit();
		//The employees are saved with Ids-1 and 2
		
		//FIND ENTITY
		Employee employee3=entityManager.find(Employee.class, 1);
		System.out.println(employee3);
		
		//UPDATE AND ENTITY
		Employee employee4=entityManager.find(Employee.class, 2);
		System.out.println(employee4);
		entityTransaction.begin();
		employee4.setDepartment("Electical New");
		employee4.setName("Jack Ryan New");
		entityTransaction.commit();
		System.out.println("After Update\n"+employee4);
		
		//DELETE AN ENTITY
		entityTransaction.begin();
		Employee employee5=entityManager.find(Employee.class, 2);
		entityManager.remove(employee5);
		entityTransaction.commit();
		
		
		
		entityManagerFactory.close();
		
		System.out.println("Done");

	}

}
