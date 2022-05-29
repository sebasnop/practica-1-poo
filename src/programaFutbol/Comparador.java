package programaFutbol;

import java.util.Comparator;


public class Comparador implements Comparator<EquipoFutbol> {
	
	@Override
	public int compare(EquipoFutbol t, EquipoFutbol t1) {
		
		if(t.getPuntos() > t1.getPuntos())
			return -1;
		
		else
			if (t.getPuntos()< t1.getPuntos())
				return 1;
		
			else {
				int diferenciaGol= t.getGolesAnotados()-t.getGolesRecibidos();
				
				int diferenciaGol1 = t1.getGolesAnotados()-t1.getGolesRecibidos();
				
				if (diferenciaGol> diferenciaGol1)
					return -1;
				
				else
					if (diferenciaGol < diferenciaGol1)
						return 1;
					else
						return 0;
				
				
			}
	
	
	}
	
	

}
