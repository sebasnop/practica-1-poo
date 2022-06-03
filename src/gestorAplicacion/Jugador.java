package gestorAplicacion;
import java.io.Serializable;

public class Jugador implements Serializable, IntegranteEquipo{
	
	private static final long serialVersionUID = 1L;
	
	public static enum Posicion {PT, DF, MC, DL};
	
	private String nombre;
	private Posicion posicion;
	private int valorMercado;
	private EquipoFutbol equipo;
	
	public Jugador(String nombre, Posicion posicion, int valorMercado) {
		this.nombre = nombre;
		this.posicion = posicion;
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
	
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
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
	
	public EquipoFutbol getEquipo() {
		return equipo;
	}
	public void setEquipo(EquipoFutbol equipo) {
		this.equipo = equipo;
	}

	@Override
	public String mostrar() {
		return this.getNombre() + ", posicion: " + this.getPosicion().toString() + ", precio: " + this.getValorMercado();
	}

}
