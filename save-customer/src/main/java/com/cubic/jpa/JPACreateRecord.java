package com.cubic.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cubic.jpa.entity.CustomerEntity;

public class JPACreateRecord {

	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction et = null;
		
		try{
			//OracleUnit is from the persistence file...
			emf = Persistence.createEntityManagerFactory("OracleUnit");
			em = emf.createEntityManager();
			System.out.println("connection established");
			et = em.getTransaction();
			et.begin();
			//To store to db
			CustomerEntity entity = createCustomerEntity();
			//when the whole of below method is refactored,
				/*
				CustomerEntity entity = new CustomerEntity();
				entity.setFirstName("James");
				entity.setLastName("Bond");
				entity.setSsn("333-22-4444");
				*/
			//private static void createCustomerEntity(){} method is created
			
			System.out.println("Before insert "+ entity);
			em.persist(entity);
			//to save to db, commit is must
			et.commit();
			System.out.println("After insert "+ entity);
		}
		catch(Exception e){
			e.printStackTrace();
			if(et != null)
				et.setRollbackOnly();
		}
		finally{
			if(em!= null){
				em.close();
			}
			if(emf!= null){
				em.close();
			}
		}
	}

	private static CustomerEntity createCustomerEntity() {
		CustomerEntity entity = new CustomerEntity();
		entity.setFirstName("Bruce");
		entity.setLastName("Wayne");
		entity.setSsn("000-22-4444");
		return entity;
	}
	

	
}
