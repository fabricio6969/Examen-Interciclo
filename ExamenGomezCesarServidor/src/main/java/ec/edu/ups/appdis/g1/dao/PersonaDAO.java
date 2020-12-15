package ec.edu.ups.appdis.g1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.g1.modelo.Persona;

@Stateless
public class PersonaDAO {
	
	@Inject
	private Connection con;
	
	//@Inject
	private EntityManager em;
	
	public boolean insert(Persona entity) throws SQLException {
		String sql = "INSERT INTO Persona (nombre, apellido, email, estado"
				+"VALUES(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, entity.getNombre());
		ps.setString(2, entity.getApellido());
		ps.setString(3, entity.getEmail());
		ps.setString(4, entity.getEstado());
		ps.executeUpdate();
		ps.close();
		return true;		
	}
	public boolean insertJPA(Persona entity) throws SQLException {
		em.persist(entity);
		return true;
		
	}
	
	public boolean updateJPA(Persona entity) {
		em.merge(entity);
		return true;
	}
	
	public Persona readJPA(int id)  {
		Persona persona = em.find(Persona.class, id);
		return persona;		
	}
	
	public boolean deleteJPA(int id) throws SQLException {
		Persona persona = this.readJPA(id);
		em.remove(persona);
		return true;		
	}
	public List<Persona> getPersona(){
		String jpql = "SELECT p FROM Persona c WHERE id = ?";
		Query q = em.createQuery(jpql, Persona.class);
		q.setParameter(1, 1);
		return (List<Persona>) q.getResultList();
	}
	
	
}
