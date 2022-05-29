package gestorAplicacion;

public class Arbitro {
	public static String [] arbitros = {"Howard Webb","Pierluigi Collina","Nestor Pitana","Felix Brycht"};
	
	private String nombre;
	private int salario;
	private int partidosPitados;
	private Partido partido;
	
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	public int getPartidosPitados() {
		return partidosPitados;
	}
	public void setPartidosPitados(int partidosPitados) {
		this.partidosPitados = partidosPitados;
	}
	
	public int bonificacionSalario() {
		return 0;
	}
	
	

}
