package ec.edu.ups.appdis.g1.negocio;

import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.appdis.g1.dao.PersonaDAO;
import ec.edu.ups.appdis.g1.dao.SolicitudDAO;
import ec.edu.ups.appdis.g1.modelo.Persona;
import ec.edu.ups.appdis.g1.modelo.Solicitud;

@Stateless
public class GestionSolicitudON {
	@Inject
	private SolicitudDAO daoSolicitud;
	@Inject
	private PersonaDAO daoPersona;
	
	public boolean registrarSolicitud(Solicitud solicitud) throws SQLException {
		Persona personaRemitente = solicitud.getPersonaRemite();
		Persona personaReceptor = solicitud.getPersonaReceptor();
		if(daoPersona.readJPA(personaRemitente.getId())!=null && daoPersona.readJPA(personaReceptor.getId())!=null) {
			daoPersona.updateJPA(personaReceptor);	
			daoPersona.updateJPA(personaRemitente);
		}else {
			daoPersona.insertJPA(personaRemitente);
			daoPersona.insertJPA(personaReceptor);
		}
		daoSolicitud.insertJPA(solicitud);
			return true;	
		}
	
}
