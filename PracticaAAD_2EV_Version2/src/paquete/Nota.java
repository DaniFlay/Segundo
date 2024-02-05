package paquete;
// Generated 5 feb 2024 13:20:42 by Hibernate Tools 6.3.1.Final

/**
 * Nota generated by hbm2java
 */
public class Nota implements java.io.Serializable {

	private NotaId id;
	private Ciclo ciclo;
	private Alumno alumno;
	private Modulo modulo;
	private Double valorNumerico;

	public Nota() {
	}

	public Nota(NotaId id, Ciclo ciclo, Alumno alumno, Modulo modulo, Double valorNumerico) {
		this.id = id;
		this.ciclo = ciclo;
		this.alumno = alumno;
		this.modulo = modulo;
		this.valorNumerico = valorNumerico;
	}
	

	@Override
	public String toString() {
		return  "Ciclo:" + ciclo.getNombreCompleto() + "\nAlumno DNI: " + alumno.getDni() + "\nModulo=" + modulo.getNombre() + "Valor: "
				+ valorNumerico + "\nEvaluacion: "+id.getEvaluacion()+"\nTipoNota: "+id.getTipoNota();
	}

	public NotaId getId() {
		return this.id;
	}

	public void setId(NotaId id) {
		this.id = id;
	}

	public Ciclo getCiclo() {
		return this.ciclo;
	}

	public void setCiclo(Ciclo ciclo) {
		this.ciclo = ciclo;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Modulo getModulo() {
		return this.modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public Double getValorNumerico() {
		return this.valorNumerico;
	}

	public void setValorNumerico(Double valorNumerico) {
		this.valorNumerico = valorNumerico;
	}

}
