package ec.edu.ups.appdis.g1.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.g1.modelo.Solicitud;

@Stateless
public class SolicitudDAO {
	@Inject
	private Connection con;
	
	//@Inject
	private EntityManager em;
	
	public boolean insertJPA(Solicitud entity) throws SQLException {
		em.persist(entity);
		return true;
		
	}
	
	public boolean updateJPA(Solicitud entity) {
		em.merge(entity);
		return true;
	}
	
	public Solicitud readJPA(int id)  {
		Solicitud Solicitud = em.find(Solicitud.class, id);
		return Solicitud;		
	}
	
	public boolean deleteJPA(int id) throws SQLException {
		Solicitud Solicitud = this.readJPA(id);
		em.remove(Solicitud);
		return true;		
	}
	public List<Solicitud> getSolicitud(){
		String jpql = "SELECT s FROM Solicitud s WHERE id = ?";
		Query q = em.createQuery(jpql, Solicitud.class);
		q.setParameter(1, 1);
		return (List<Solicitud>) q.getResultList();
	}
}
