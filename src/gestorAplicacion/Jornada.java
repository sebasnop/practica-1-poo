package gestorAplicacion;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Jornada {
	
	private int numero;
	private List<Partido> partidos;
	private Date fecha;
	
	public Jornada (int numero, List<Partido> partidos) {
		this.numero = numero;
		this.partidos = partidos;
	}
	
	
	// Getters y setters

	public List<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	// Metodos
	
	public String mostrarFecha() {
		
		Date fecha = getFecha();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		
		String diaTexto  = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
		String mesTexto  = Integer.toString(calendar.get(Calendar.MONTH));
		String anioTexto = Integer.toString(calendar.get(Calendar.YEAR));
		
		return "Dia " + diaTexto + ", mes " + mesTexto + " del " + anioTexto;
	}
	
}
