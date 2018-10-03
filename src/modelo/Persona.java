package modelo;

public class Persona {
	private String nombre;
	private String cedula;
	private String direccion;
	private int    telefono;
	
	public Persona(String nombre,String cedula,String direccion,int telefono) {
		this.cedula=cedula;
		this.direccion=direccion;
		this.nombre=nombre;
		this.telefono=telefono;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	
}
