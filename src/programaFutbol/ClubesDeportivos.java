package programaFutbol;



public  abstract class ClubesDeportivos {
	
	private String nombre;
	private String ubicacion;
	private String Estadisticas;
	
	
	
	@Override
	public boolean equals(Object o) {
		return this.nombre.equals(((ClubesDeportivos)o).nombre);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getEstadisticas() {
		return Estadisticas;
	}
	public void setEstadisticas(String estadisticas) {
		Estadisticas = estadisticas;
	}
	
	
	

}
