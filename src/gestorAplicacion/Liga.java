package gestorAplicacion;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

import gestorAplicacion.Jugador.Posicion;

public class Liga implements Serializable{
	
	public static ArrayList<Arbitro> arbitros = new ArrayList <Arbitro> ();
	//{"Howard Webb","Pierluigi Collina","Nestor Pitana","Felix Brycht"};

	
	private final int numeroDeEquipos;
	private LinkedList<EquipoFutbol> equipos;
	private final Scanner scanner;
	private final ArrayList<Partido> partidos;
	private final ArrayList<Jugador> jugadoresEnVenta= new ArrayList(Arrays.asList(new Jugador("Maradona",Posicion.DL,10000000),new Jugador("Messi",Posicion.DL,20000000),new Jugador("Cristiano Ronaldo",Posicion.DL,20000000),new Jugador("Carles Puyol",Posicion.DF,5000000),new Jugador("Pepe",Posicion.DF,4500000),new Jugador("Rio Ferdinand",Posicion.DF,7000000),new Jugador("Keylor Navas",Posicion.PT,11000000),new Jugador("Manuel Neuer",Posicion.PT,15000000),new Jugador("Oliver Kahn",Posicion.PT,18000000)));
	private ArrayList<String> jugadoresDisponibles= new ArrayList();
	
	
	public Liga(int numeroDeEquipos) {
		this.numeroDeEquipos = numeroDeEquipos;
		equipos = new LinkedList<EquipoFutbol>();
		partidos = new ArrayList<Partido>();
		scanner = new Scanner(System.in);
	}
	
	public ArrayList<Partido> getPartidos() {
		return partidos;
	}
	
    public LinkedList<EquipoFutbol> getEquipos() {
		return equipos;
	}
    
    public boolean noCabenEquipos() {
    	if (getEquipos().size() == getNumeroDeEquipos()) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public boolean equipoPertenece(EquipoFutbol equipo) {
    	if (getEquipos().contains(equipo)) {
    		return true;
    	} else {
    		return false;
    	}
    }

	public int getNumeroDeEquipos() {
		return numeroDeEquipos;
	}

	public void anadirEquipo(EquipoFutbol equipo) {
    	equipos.add(equipo);
	}
	
	public void eliminarEquipo(EquipoFutbol equipo) {
		equipos.remove(equipo);
	}
	
	public EquipoFutbol identificarEquipo (String nombreEquipo) {
		for (EquipoFutbol equipo: equipos) {
			if (equipo.getNombre().equals(nombreEquipo)){
				return equipo;
			}
		}
		return null;
	}
			    
			    private void AnadirPartidoJugado(){
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
			          for(EquipoFutbol equipo : equipos){
			              if(equipo.getNombre().equals(linea))
			                  local = equipo;
			          }  
			          if (local == null) {
			              System.out.println("No esta ese equipo en la Liga");
			              return;
			          }
			          System.out.println("Ingrese el equipo visitante: ");
			          linea = scanner.nextLine();
			          EquipoFutbol visitante = null;
			           for(EquipoFutbol equipo : equipos){
			              if(equipo.getNombre().equals(linea))
			                  visitante = equipo;
			          }
			          //Random arbitroAleatorio= new Random();
			
			          //int arbitro =arbitroAleatorio.nextInt(4);
			          //System.out.println("El arbitro del partido fue: "+nombres[arbitro]+"\n");
			          
			        
			       
			          
			          
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
			         partidos.add(partido);
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
			    	
			    private void MostrarCalendario() {
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
			       for (Partido p : partidos) {
			           Calendar cal2 = Calendar.getInstance();
			           cal2.setTime(p.getFecha());
			            if (cal.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) || cal.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR)) {
			                //System.out.println(p.getEquipoA().getNombre()+ " "+p.getGolesA() + " : "+ p.getGolesB()+ " "+ p.getEquipoB().getNombre());
			            }
			       }   
			  }
			    
			    public int dia(int M, int D, int Y) {
			        int y = Y - (14 - M) / 12;
			        int x = y + y/4 - y/100 + y/400;
			        int m = M + 12 * ((14-M) / 12) - 2;
			        int d = (D + x + (31*m)/12) % 7;
			        return d;
			    }
			    
			    public boolean isLeapYear(int year) {
			        
			        if ((year % 4 ==0) && (year % 100 !=0 )) return true;
			        if (year % 400 == 0) return true;
			        return false;  
			    }
			    private void MostrarMercado() {
			    	System.out.println("Ingrese el nombre del equipo para consultar presupuesto");
			    	String linea = scanner.nextLine();
			    	
			    	int presupuesto=0;
			    	for(EquipoFutbol equipo: equipos) {
			    		if(equipo.getNombre().equals(linea))
			    			presupuesto=equipo.getPresupuesto();
			    		
			    	System.out.println("Ingrese la posición del jugador");
			    	 linea = scanner.nextLine();
			    	 for (Jugador jugador:jugadoresEnVenta) {
			    		 try {
			    		 if(Posicion.valueOf(linea).equals(linea));
			    		 
			    			 
			    		 
			    			jugadoresDisponibles.add(jugador.getNombre());
			    		 System.out.println(Posicion.valueOf(linea));
			    		 }
			    	catch(IllegalArgumentException e) {
			    			System.out.println("Comando invalido");
			    			
			    		}
			    		 
			    		 
			    	 }
			    		System.out.println("Los jugadores que estan disponibles son "+jugadoresDisponibles);	
			    		return;
			    	}
			    	
			    }
			    
			  
			    	
			}
			

	
