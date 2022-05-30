package gestorAplicacion;

public class Jugador {
	private  String nombre;
	private String posicion;
	private  int valorMercado;
	public Jugador(String nombre, String posicion, int valorMercado) {
		super();
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
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public int getValorMercado() {
		return valorMercado;
	}
	public void setValorMercado(int valorMercado) {
		this.valorMercado = valorMercado;
	}
	//Hello

}
