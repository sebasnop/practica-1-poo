package gestorAplicacion;
import java.io.Serializable;

public class Arbitro implements Serializable{
	
	private String nombre;
	private int salario;
	
	public Arbitro(String nombre, int salario) {
		this.nombre = nombre;
		this.salario = salario;
	}
	
	public Arbitro (String nombre) {
		this(nombre, 1000);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	
	// Falta implementación
	public int bonificacionSalario() {
		return 0;
	}

}
