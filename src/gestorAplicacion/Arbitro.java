package gestorAplicacion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Arbitro implements Serializable{
	
	// Para seleccionar arbitros aleatoriamente
	static Random rand = new Random();
	
	public static ArrayList<Arbitro> federacionArbitros = 
			new ArrayList <Arbitro> (
					Arrays.asList(
					new Arbitro("Howard Webb"), new Arbitro("Pierluigi Collina"), 
					new Arbitro("Nestor Pitana"), new Arbitro("Felix Brycht")
					)
			);
	
	private String nombre;
	private int salario;
	private int partidos;
	
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
	
	public int getPartidos() {
		return partidos;
	}
	public void setPartidos(int partidos) {
		this.partidos = partidos;
	}
	
	// Falta implementación
	// Puede ser con la cantidad de partidos pitados, me lo habias propuesto antes
	public int bonificacionSalario() {
		return 0;
	}
	
	public static Arbitro escogerAleatoriamente(){
		int indiceAleatorio = rand.nextInt(federacionArbitros.size());
		Arbitro a = federacionArbitros.get(indiceAleatorio);
		//a.setPartidos(a.getPartidos()+1);
        return a;
	}
	
	public static ArrayList<Arbitro> ListaAleatoreaArbitro(){
		ArrayList<Arbitro> arbitrosRandomizer =new ArrayList<>(federacionArbitros);
		 ArrayList<Arbitro> arbitrosAleatorio =new ArrayList<>();
		 Collections.shuffle(arbitrosRandomizer);
		 arbitrosAleatorio.addAll(arbitrosRandomizer);
		 return arbitrosAleatorio;

		
	}
	 
	@Override
	public String toString() {
		return nombre;
	}
	
}
