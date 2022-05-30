package gestorAplicacion;



public  abstract class ClubDeportivo {
	
	private String nombre;
	private String ubicacion;
	
	@Override
	public boolean equals(Object o) {
		return this.nombre.equals(((ClubDeportivo)o).nombre);
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

}