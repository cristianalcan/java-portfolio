package practicaunidad5;

public class persona {
	private String nombre;
	private String apellido;
	private String dni;
	private String fechaNacimiento;
	public persona(String nombre, String apellido, String dni, String fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getDni() {
		return dni;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	@Override
	public String toString() {
		return "persona [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", fechaNacimiento="
				+ fechaNacimiento + "]";
	}
	
	

}
