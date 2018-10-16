package com.cubic.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cubic.jpa.entity.CustomerEntity;

public class JPAFindRecord {

	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction et = null;
		try{
			emf = Persistence.createEntityManagerFactory("OracleUnit");
			em = emf.createEntityManager();
			System.out.println("connection established");

			CustomerEntity entity = em.find(CustomerEntity.class, new Long(1001));

			System.out.println("Customer Entity "+ entity);
		}
		catch(Exception e){
			e.printStackTrace();
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
