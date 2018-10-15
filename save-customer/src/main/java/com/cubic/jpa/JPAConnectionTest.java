package com.cubic.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAConnectionTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try{
			//OracleUnit is from the persistence file...
			emf = Persistence.createEntityManagerFactory("OracleUnit");
			em = emf.createEntityManager();
			System.out.println("connection established");
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
