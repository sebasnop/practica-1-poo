package programaFutbol;

public class Arbitro extends Partido {
	protected String [] nombres= {"Howard Webb","Pierluigi Collina","Nestor Pitana","Felix Brycht"};
	private int salario;
	private int partidosPitados;
	private Partido partido;
	
	
	
	public String[] getNombres() {
		return nombres;
	}
	public void setNombres(String[] nombres) {
		this.nombres = nombres;
	}
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
	public Partido getPartido() {
		return partido;
	}
	public void setPartido(Partido partido) {
		this.partido = partido;
	}
	public int bonificacionSalario() {
		
	}
	
	

}
