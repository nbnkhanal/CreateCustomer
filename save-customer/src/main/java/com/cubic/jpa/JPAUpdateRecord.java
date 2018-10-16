package com.cubic.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cubic.jpa.entity.CustomerEntity;

public class JPAUpdateRecord {

	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction et = null;
		
		try{
			emf = Persistence.createEntityManagerFactory("OracleUnit");
			em = emf.createEntityManager();
			System.out.println("connection established");
			et = em.getTransaction();
			et.begin();
			CustomerEntity entity = em.find(CustomerEntity.class, new Long(1001));
			System.out.println("Before insert "+ entity);
			entity.setFirstName("Natalie");
			em.persist(entity);
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
