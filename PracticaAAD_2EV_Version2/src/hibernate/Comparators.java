package hibernate;

import java.util.Comparator;

import paquete.Modulo;
import paquete.Nota;
import paquete.NotaId;

public class Comparators {
	static class ComparatorHoras implements Comparator<Modulo>{

		@Override
		public int compare(Modulo o1, Modulo o2) {
			return o1.getHorasSemanales().compareTo(o2.getHorasSemanales());
		}
		
	}
	static class ComparatorNotasModulo implements Comparator<NotaId>{


		@Override
		public int compare(NotaId o1, NotaId o2) {
			return o1.getNombreModulo().compareTo(o2.getNombreModulo());
		}
		
	}
	static class ComparatorNotasEvaluacion implements Comparator<NotaId>{

		@Override
		public int compare(NotaId o1, NotaId o2) {
			return o1.getEvaluacion() > o2.getEvaluacion() ? +1 : o1.getEvaluacion() < o2.getEvaluacion() ? -1 : 0;
		}
		
	}
	static class ComparatorNotasTipo implements Comparator<NotaId>{

		@Override
		public int compare(NotaId o1, NotaId o2) {
			return o1.getTipoNota().compareTo(o2.getTipoNota());
		}
		
	}

}
