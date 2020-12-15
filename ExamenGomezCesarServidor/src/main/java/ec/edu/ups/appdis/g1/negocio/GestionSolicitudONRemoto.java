package ec.edu.ups.appdis.g1.negocio;

import java.sql.SQLException;

import javax.ejb.Remote;

import ec.edu.ups.appdis.g1.modelo.Solicitud;

@Remote
public interface GestionSolicitudONRemoto {

	public boolean registrarSolicitud(Solicitud solicitud) throws SQLException;
	
}
