package gestorAplicacion;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class GeneradorFixture {

    public List<List<Fixture>> getFixtures(Liga liga, boolean incluirFixturesAlReves) {
    	
    	LinkedList<EquipoFutbol> equipos = liga.getEquipos();
        int cantidadEquipos = equipos.size();

        // Genera los fixtures usando un algoritmo cíclico.
        int jornadasTotales = cantidadEquipos - 1;
        int partidosPorJornada = cantidadEquipos / 2;
        List<List<Fixture>> jornadas = new LinkedList<List<Fixture>>();

        for (int numeroDeJornada = 0; numeroDeJornada < jornadasTotales; numeroDeJornada++) {
            
        	List<Fixture> fixturesJornada = new LinkedList<Fixture>();
            Date fechaJornada = liga.fechaJornada(numeroDeJornada);
            
            for (int partido = 0; partido < partidosPorJornada; partido++) {
            	
            	// Para cada partido se escoge un arbitro aleatoriamente
            	Arbitro arbitro = Arbitro.escogerAleatoriamente();
            	
                int local = (numeroDeJornada + partido) % (cantidadEquipos - 1);
                int visitante = (cantidadEquipos - 1 - partido + numeroDeJornada) % (cantidadEquipos - 1);
                // El último equipo permanece en el mismo lugar mientras los demás rotan a su alrededor.
                if (partido == 0) {
                    visitante = cantidadEquipos - 1;
                }
                fixturesJornada.add(new Fixture(equipos.get(local), equipos.get(visitante), arbitro));
            }
            jornadas.add(fixturesJornada);
        }

        // Intercalar para que los juegos locales y fuera de casa estén dispersos de manera uniforme.
        List<List<Fixture>> intercalado = new LinkedList<List<Fixture>>();

        int evn = 0;
        int odd = (cantidadEquipos / 2);
        for (int i = 0; i < jornadas.size(); i++) {
            if (i % 2 == 0) {
                intercalado.add(jornadas.get(evn++));
            } else {
                intercalado.add(jornadas.get(odd++));
            }
        }

        jornadas = intercalado;

        // El último equipo no puede ser visitante siempre,
        // así que se cambia a locales en jornadas impares.
        for (int numeroDeJornada = 0; numeroDeJornada < jornadas.size(); numeroDeJornada++) {
        	
        	Date fechaJornada = liga.fechaJornada(numeroDeJornada);
        	
            if (numeroDeJornada % 2 == 1) {
                Fixture fixture = jornadas.get(numeroDeJornada).get(0);
                jornadas.get(numeroDeJornada).set(0, new Fixture(fixture.getEquipoVisitante(), fixture.getEquipoLocal(), fixture.getArbitro()));
            }
        }
        
        if(incluirFixturesAlReves){
            List<List<Fixture>> fixturesAlReves = new LinkedList<List<Fixture>>();
            
            int numeroDeJornada = jornadasTotales+1;
            
            for(List<Fixture> jornada: jornadas){
                
            	List<Fixture> jornadaAlReves = new LinkedList<Fixture>();
            	Date fechaJornada = liga.fechaJornada(numeroDeJornada);
                
                for(Fixture fixture: jornada){
                    
                	jornadaAlReves.add(new Fixture(fixture.getEquipoVisitante(), fixture.getEquipoLocal(), fixture.getArbitro()));
                	
                }
                
                numeroDeJornada++;
                
                fixturesAlReves.add(jornadaAlReves);
            }
            jornadas.addAll(fixturesAlReves);
        }

        return jornadas;
    }
}
