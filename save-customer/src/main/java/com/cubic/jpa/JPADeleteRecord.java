package com.cubic.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cubic.jpa.entity.CustomerEntity;

public class JPADeleteRecord {

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
			final CustomerEntity entity = em.find(CustomerEntity.class, new Long(1003));
			System.out.println("Before insert "+ entity);
			em.remove(entity);
			et.commit();
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
}
