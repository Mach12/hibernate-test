package fr.intech.s5.tp.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import fr.intech.s5.tp.hibernate.entity.Client;
import fr.intech.s5.tp.hibernate.entity.Compte;

public class DAO {
	SessionFactory factory;
	
	public DAO() {
		factory = new Configuration()
				.configure()
				.buildSessionFactory();
	}
	
	public void close() {
		factory.close();
	}
	
	public <T> Long ajout(T entity) {
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		Long retour = (Long) session.save(entity);
		tx.commit();
		session.close();
		
		return retour;
	}
	
	public Client getClient(Long idClient) {
		Session session = factory.openSession();
		
		Client entity = session.get(Client.class, idClient);
		return entity;
	}
	
	public Compte getCompte(Long numeroCompte) {
		Session session = factory.openSession();
		
		Compte entity = session.get(Compte.class, numeroCompte);
		return entity;
	}
}
