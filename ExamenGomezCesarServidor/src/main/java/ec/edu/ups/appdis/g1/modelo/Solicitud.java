package ec.edu.ups.appdis.g1.modelo;

public class Solicitud {
	private Persona personaRemite;
	private String direccionRecogida;
	private String direccionEntrega;
	private Persona personaReceptor;
	public Persona getPersonaRemite() {
		return personaRemite;
	}
	public void setPersonaRemite(Persona personaRemite) {
		this.personaRemite = personaRemite;
	}
	public String getDireccionRecogida() {
		return direccionRecogida;
	}
	public void setDireccionRecogida(String direccionRecogida) {
		this.direccionRecogida = direccionRecogida;
	}
	public String getDireccionEntrega() {
		return direccionEntrega;
	}
	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}
	public Persona getPersonaReceptor() {
		return personaReceptor;
	}
	public void setPersonaReceptor(Persona personaReceptor) {
		this.personaReceptor = personaReceptor;
	}
	@Override
	public String toString() {
		return "Solicitud [personaRemite=" + personaRemite + ", direccionRecogida=" + direccionRecogida
				+ ", direccionEntrega=" + direccionEntrega + ", personaReceptor=" + personaReceptor + "]";
	}
}
