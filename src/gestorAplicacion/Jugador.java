package gestorAplicacion;
import java.io.Serializable;

public class Jugador implements Serializable{
	
	public static enum Posicion {PT, DF, MC, DL};
	
	private String nombre;
	private Posicion posicion;
	private int valorMercado;
	public Jugador(String nombre, String posicion, int valorMercado) {
		this.nombre = nombre;
		this.posicion = Posicion.valueOf(posicion);
		this.valorMercado = valorMercado;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Posicion getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = Posicion.valueOf(posicion);
	}
	
	public int getValorMercado() {
		return valorMercado;
	}
	public void setValorMercado(int valorMercado) {
		this.valorMercado = valorMercado;
	}

}
