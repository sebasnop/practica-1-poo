package gestorAplicacion;
import java.io.Serializable;


public class Arbitro  implements Serializable{
	
	private String nombre;
	private int salario;
	
	
	public Arbitro(String nombre, int salario) {
		super();
		this.nombre = nombre;
		this.salario = salario;
	}
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	
	
	public int bonificacionSalario() {
		return 0;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
