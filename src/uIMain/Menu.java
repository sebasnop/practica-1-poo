package uIMain;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import java.util.Scanner;

import gestorAplicacion.Arbitro;
import gestorAplicacion.Comparador;
import gestorAplicacion.EquipoFutbol;
import gestorAplicacion.Fixture;
import gestorAplicacion.Jugador;
import gestorAplicacion.Liga;
import gestorAplicacion.Partido;
import gestorAplicacion.PartidoJugado;
import gestorAplicacion.Jugador.Posicion;



public class Menu {
	
	static Scanner scanner = new Scanner(System.in);

	static Liga liga = new Liga(4);
	
	public static void main(String[] args) {
		
		 
		 
		 
		 
		
		
		
		boolean salir = false;

		while(!salir) {
			
			System.out.println("----------------------");
			System.out.println("|        Menu De      |");
			System.out.println("|         La Liga     |");
			System.out.println("----------------------");
			System.out.println("");

			System.out.println("Cree Un Nuevo Equipo Y Anadalo A La Liga (presione 1)");
			System.out.println("Eliminar Un Equipo Existente (presione 2)");
			System.out.println("Mostrar las Estadisticas Por Equipo (presione 3)");
			System.out.println("Mostrar La Tabla De La Liga (presione 4)");
			System.out.println("Anadir un Partido Jugado (presione 5)");
			System.out.println("Mostrar Calendario y Encontrar un Partido (presione 6)");
			System.out.println("Consultar Mercado De Jugadores (presione 7)");
			System.out.println("Generar fixture (presione 8)");
			System.out.println("Salir (presione 9)");
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
				AnadirPartidoJugado();
				break;
			case 6:
				MostrarCalendario();
				break;
	
			case 7:
				MostrarMercado();
				break;
			
			case 8:
				GenerarFixture();
				break;
				
			case 9:
				salir=true;
				break;
				
	
	
			default:
				System.out.println("Comando Incorrecto");
	
			}
		}
	
	}
	
	private static void AnadirEquipo() {
    	
    	if ( liga.ligaCompleta() ) {
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
	

	
	private static void AnadirPartidoJugado(){
		 System.out.println("Ingrese una Fecha (formato mm-dd-yyyy): ");
	        String linea = scanner.nextLine();
	        Date date;
	        try {
	            date = new SimpleDateFormat("MM-dd-yyyy").parse(linea);
	        } catch (ParseException ex) {
	            System.out.println("Tienes que ingresar una fecha en formato  mm-dd-yyyy");
	            return;
	        }
	        
	        System.out.println("Ingrese el equipo Local: ");
	        linea = scanner.nextLine();
	        EquipoFutbol local = null;
	        EquipoFutbol equipo =liga.identificarEquipo(linea);
	        if (liga.equipoPertenece(equipo)) {
	        	local=equipo;
	        	
	        }
	        if (local==null) {
	        	 System.out.println("No esta ese equipo en la Liga");
	              return;
	          }
	        
	        System.out.println("Ingrese el equipo visitante: ");
	          linea = scanner.nextLine();
	          EquipoFutbol visitante = null;
		        EquipoFutbol equipo2 =liga.identificarEquipo(linea);
		        if (liga.equipoPertenece(equipo2)) {
		        	visitante=equipo2;
		        	
		        	
	        }
		        if (visitante == null) {
		              System.out.println("No esta ese equipo en la liga");
		              return;
		          }
		           
		           System.out.println("Ingrese goles del equipo local: ");
		           linea = scanner.nextLine();
		           int golesLocal = -1;
		             try {
		            	 golesLocal= Integer.parseInt(linea);                
		             } catch (Exception e) { 
		    }
		         if (golesLocal == -1) {
		             System.out.println("tienes que ingresar un numero de goles");
		             return;
		         }
		         
		         System.out.println("Ingrese goles  del equipo visitante: ");
		           linea = scanner.nextLine();
		           int golesVisitante = -1;
		             try {
		            	 golesVisitante= Integer.parseInt(linea);                
		             } catch (Exception e) { 
		    }
		         if (golesVisitante == -1) {
		             System.out.println("tienes que ingresar un numero de goles");
		             return;
		         }
		         
		         Partido partido = new PartidoJugado();
		         partido.setFecha(date);
		         partido.setEquipoLocal(local);
		         partido.setEquipoVisitante(visitante);
		         ((PartidoJugado) partido).setGolesLocal(golesLocal);
		         ((PartidoJugado) partido).setGolesVisitante(golesVisitante);
		         liga.getPartidos().add(partido);
		         local.setGolesAnotados(local.getGolesAnotados()+golesLocal);
		         visitante.setGolesAnotados(visitante.getGolesAnotados()+golesVisitante);
		         local.setGolesRecibidos(local.getGolesRecibidos()+golesVisitante);
		         visitante.setGolesRecibidos(visitante.getGolesRecibidos()+golesLocal);
		         local.setPartidosJugados(local.getPartidosJugados()+1);
		         visitante.setPartidosJugados(visitante.getPartidosJugados()+1);
		         
		         if (golesLocal> golesVisitante) {            
		             local.setPuntos(local.getPuntos()+3);
		             local.setVictorias(local.getVictorias()+1);
		             visitante.setDerrotas(visitante.getDerrotas()+1);
		         }
		         
		         else if (golesLocal< golesVisitante) {            
		             visitante.setPuntos(visitante.getPuntos()+3);
		             visitante.setVictorias(visitante.getVictorias()+1);
		             local.setDerrotas(local.getDerrotas()+1);
		         }
		         else {
		             local.setPuntos(local.getPuntos()+1);
		             visitante.setPuntos(visitante.getPuntos()+1);
		             local.setEmpates(local.getEmpates()+1);
		             visitante.setEmpates(visitante.getEmpates()+1);
		         }      
		    } 
		         
	        
	        
	
	
	
	 private static void MostrarCalendario() {
	    	System.out.println("Ingrese un anio: ");
	    	String linea = scanner.nextLine();
	    	int Y= -7777;
	    	try {
	    		Y=Integer.parseInt(linea);
	    	} catch (Exception e) {
	    			
	  }
	    	if (Y== -7777) {
	    		System.out.println("Tienes que ingresar un anio");
	    		return;	
	    		
	    	}
	    	
	    	System.out.println("Ingrese un mes: ");
	    	 linea = scanner.nextLine();
	    	int M= 0;
	    	try {
	    		M=Integer.parseInt(linea);
	    	} catch (Exception e) {
	    			
	  }
	    	if (M== 0) {
	    		System.out.println("Tienes que ingresar un mes");
	    		return;	
	    		
	    	}
	    
	    	String [] meses= {
	   "",// mes 0 no existe
	   "Enero","Febrero","Marzo",
	   "Abril","Mayo","Junio",
	   "Julio","Agosto","Septiembre",
	   "Octubre","Noviembre","Diciembre"};
	    	
	    	
	    	int [] dias= { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	    	
	    	
	    	if (M==2 &&  isLeapYear(Y)) dias [M]=29;
	    	
	    	System.out.println("    "+ meses[M] + " " +Y);
	    	System.out.println("D  Lu  Ma  M  J  V  S");
	    	
	    	int  d= dia(M,1,Y);
	    	String espacio = "";
	    	
	    	for(int i =0; i< d; i++)
	    		System.out.print("   ");
	    	for (int i=1; i<= dias[M]; i++) {
	    		if (i<10)
	    			System.out.print(i +"  ");
	    		
	    		else
	    			System.out.print(i+" ");
	    		
	    		if(((i+d) % 7==0) || (i== dias[M])) System.out.println();
	    		
	    		
	    		
	    	}
	    	
	    	System.out.println("Ingrese un dia: ");
	    	linea = scanner.nextLine();
	    	int D =0;
	    	
	    	try {
	    		D=Integer.parseInt(linea);
	    	}	catch(Exception e) {
	    
	    	}
	    if (D==0 || dias[M] < D) {
	    	System.out.println("Tienes que ingresas un dia del mes");
	    	return;
	    }
	    	
	    Calendar cal = Calendar.getInstance();
	    cal.set(Y, M-1, D);
	       for (Partido p : liga.getPartidos()) {
	           Calendar cal2 = Calendar.getInstance();
	           cal2.setTime(p.getFecha());
	            if (cal.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) || cal.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR)) {
	                System.out.println(p.getEquipoLocal().getNombre()+ " "+((PartidoJugado) p).getGolesLocal() + " : "+ ((PartidoJugado) p).getGolesVisitante()+ " "+((PartidoJugado) p).getEquipoVisitante().getNombre());
	            }
	       }   
	  }
	    
	    public  static int dia(int M, int D, int Y) {
	        int y = Y - (14 - M) / 12;
	        int x = y + y/4 - y/100 + y/400;
	        int m = M + 12 * ((14-M) / 12) - 2;
	        int d = (D + x + (31*m)/12) % 7;
	        return d;
	    }
	    
	    public  static boolean isLeapYear(int year) {
	        
	        if ((year % 4 ==0) && (year % 100 !=0 )) return true;
	        if (year % 400 == 0) return true;
	        return false;  
}
	    
	    
	    private static void MostrarMercado() {
	    	System.out.println("Ingrese el nombre del equipo para consultar presupuesto");
	    	String linea = scanner.nextLine();
	    	
	    	int presupuesto=0;
	    	EquipoFutbol equipo =liga.identificarEquipo(linea);
	        if (liga.equipoPertenece(equipo)) {
	        	presupuesto=equipo.getPresupuesto();
	        	
	        }
	    			
	    	System.out.println("Ingrese la posicion del jugador");
	    	 linea = scanner.nextLine();
	    	 //for (Jugador jugador:liga.getJugadoresEnVenta()) {
	    		 //try {
	    		 //if(Posicion.valueOf(linea).equals(linea));
	    		 
	    			 
	    		 
	    			//liga.getJugadoresDisponibles().add(jugador.getNombre());
	    		// System.out.println(Posicion.valueOf(linea));
	    		// }
	    	//catch(IllegalArgumentException e) {
	    			//System.out.println("Comando invalido");
	    			
	    		//}
	    		 
	    		 
	    	 }
	    		//System.out.println("Los jugadores que estan disponibles son "+liga.getJugadoresDisponibles());	
	    		//return;
	    	//}
	    	
	    //}

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
	
	private static void MostrarTablaLiga(){
		
		LinkedList<EquipoFutbol> equipos = liga.getEquipos();
   	 
		Collections.sort(equipos, new Comparador());
		for(EquipoFutbol equipo : equipos) {
			System.out.println("Equipo: " + equipo.getNombre()+" Puntos: "+ equipo.getPuntos()+" Diferencia de Gol: "+ (equipo.getGolesAnotados()-equipo.getGolesRecibidos()));
		}
	}
	
	private static void GenerarFixture() {
		List<List<Fixture>> jornadas = liga.generarFixture();
		for(int i=0; i<jornadas.size(); i++){
		    System.out.println("Jornada " + (i+1));
		    List<Fixture> round = jornadas.get(i);
		    for(Fixture fixture: round){
		        System.out.println(fixture.getEquipoLocal().getNombre() + " vs " + fixture.getEquipoVisitante().getNombre() + 
		        					" " + fixture.getFecha() + " " + fixture.getArbitro());
		    }
		    System.out.println("");
		}
	}
	

}