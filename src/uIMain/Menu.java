package uIMain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import gestorAplicacion.Comparador;
import gestorAplicacion.EquipoFutbol;
import gestorAplicacion.Liga;



public class Menu {
	
	static Scanner scanner = new Scanner(System.in);

	static Liga liga = new Liga(4);
	
	public static void main(String[] args) {
		
		boolean salir = false;

		while(!salir) {
			System.out.println("Menu De La Liga: ");
			System.out.println("Cree Un Nuevo Equipo Y A�adalo A La Liga (presione 1)");
			System.out.println("Eliminar Un Equipo Existente (presione 2)");
			System.out.println("Mostrar las Estadisticas Por Equipo (presione 3)");
			System.out.println("Mostrar La Tabla De La Liga (presione 4)");
			System.out.println("A�adir un Partido Jugado (presione 5)");
			System.out.println("Mostrar Calendario y Encontrar un Partido (presione 6)");
			System.out.println("Consultar Mercado De Jugadores (presione 7)");
			String linea = scanner.nextLine();
			int comando = 0;
			try {
				comando = Integer.parseInt(linea);
			} catch (Exception e) {
			}
	
			switch(comando) {
			case 1 :
				AnadirEquipo();
				break;
			case 2 :
				EliminarEquipo();
				break;
			case 3 :
				MostrarEstadisticas();
				break;
			case 4 :
				MostrarTablaLiga();
				break;
			case 5:
				//AnadirPartidoJugado();
				break;
			case 6:
				//MostrarCalendario();
				break;
	
			case 7:
				//MostrarMercado();
				break;
				
			case 8:
				salir=true;
				break;
				
	
	
			default:
				System.out.println("Comando Incorrecto");
	
			}
		}
	
	}
	
	private static void AnadirEquipo() {
    	
    	if ( liga.noCabenEquipos() ) {
    		System.out.println("No se puede agregar mas equipos a la Liga");
    		return;
    	}
    	
    	EquipoFutbol equipo = new EquipoFutbol();
    	
    	System.out.println("Ingrese el nombre Del equipo");
    	String linea = scanner.nextLine();
    	equipo.setNombre(linea);
    	
    	if ( liga.equipoPertenece(equipo) ) {
    		System.out.println("Este Equipo ya esta en la liga");
    		return;
    	}
    	
    	System.out.println("Ingrese la ubicacion del equipo");
    	linea = scanner.nextLine();
    	equipo.setUbicacion(linea);
    	
    	System.out.println("Ingrese presupuesto del equipo mayor a 0");
    	linea = scanner.nextLine();
    	 
    	 try {
    		 
    		 equipo.setPresupuesto(Integer.parseInt(linea)) ;
         
    	 } catch (Exception e) {
    		 
    		 System.out.println("tienes que ingresar un presupuesto valido");
    		 return;
         
         }
    	 
    	 liga.anadirEquipo(equipo);
    	 
	}
	
	private static void EliminarEquipo() {
		System.out.println("Ingrese el nombre del equipo");
		String linea = scanner.nextLine();
		
		EquipoFutbol equipo = liga.identificarEquipo(linea);
		
		if ( liga.equipoPertenece(equipo) ) {
			liga.eliminarEquipo(equipo);
			System.out.println("Equipo " + equipo.getNombre() + " eliminado");
		} else {
			System.out.println("Ese equipo no esta en la liga");
		}
		
	}
	
	private static void MostrarEstadisticas() {
        
        System.out.println("Ingrese el nombre del equipo: ");
        String linea = scanner.nextLine();
        
        EquipoFutbol equipo = liga.identificarEquipo(linea);
        
        if ( liga.equipoPertenece(equipo) ) {
        	System.out.println("Equipo " + equipo.getNombre()+ " Partidos Ganados: " + equipo.getVictorias());
            System.out.println("Equipo " + equipo.getNombre()+ " Partidos Jugados: " + equipo.getDerrotas());
            System.out.println("Equipo " + equipo.getNombre()+ " Partidos Empatados: " + equipo.getEmpates());
            System.out.println("Equipo " + equipo.getNombre()+ " Goles Anotados: " + equipo.getGolesAnotados());
            System.out.println("Equipo " + equipo.getNombre()+ " Goles Recibidos: " + equipo.getGolesRecibidos());
            System.out.println("Equipo " + equipo.getNombre()+ " Puntos: " + equipo.getPuntos());
            System.out.println("Equipo " + equipo.getNombre()+ " Partidos Jugados: " + equipo.getPartidosJugados());
            return;
        }
        
        System.out.println("Ese equipo no esta en la liga");
    }
	
	private static void MostrarTablaLiga() {
		
		ArrayList<EquipoFutbol> equipos = liga.getEquipos();
   	 
		Collections.sort(equipos, new Comparador());
		for(EquipoFutbol equipo : equipos) {
			System.out.println("Equipo: " + equipo.getNombre()+" Puntos: "+ equipo.getPuntos()+" Diferencia de Gol: "+ (equipo.getGolesAnotados()-equipo.getGolesRecibidos()));
		}
	}
	
}