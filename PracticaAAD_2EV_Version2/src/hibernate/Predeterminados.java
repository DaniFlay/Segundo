package hibernate;

import java.util.ArrayList;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.Comparators.ComparatorHoras;
import hibernate.Comparators.ComparatorNotasEvaluacion;
import hibernate.Comparators.ComparatorNotasModulo;
import hibernate.Comparators.ComparatorNotasTipo;
import paquete.Alumno;
import paquete.Ciclo;
import paquete.Matricula;
import paquete.MatriculaId;
import paquete.Modulo;
import paquete.Nota;
import paquete.NotaId;
import paquete.Profesor;


public class Predeterminados {
	public Alumno buscarAlumno(String dni) {
		SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
		Session session= sessionFactory.openSession();
		Transaction transaction= session.beginTransaction();
		Alumno alumno =(Alumno) session.get(Alumno.class, dni);
		transaction.commit();
		return alumno;
	}
	public Ciclo buscarCiclo(String abreviatura) {
		SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
		Session session= sessionFactory.openSession();
		Transaction transaction= session.beginTransaction();
		Ciclo ciclo =(Ciclo) session.get(Ciclo.class, abreviatura);
		transaction.commit();
		return ciclo;
	}
	public Profesor buscarProfesor(String dni) {
		SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
		Session session= sessionFactory.openSession();
		
		paquete.Profesor profesor = null;
		try {
			Transaction transaction= session.beginTransaction();
			profesor = (paquete.Profesor) session.get(paquete.Profesor.class, dni);
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return profesor;
	}
	public Modulo buscarModulo(String nombre) {
		SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
		Session session= sessionFactory.openSession();
		Transaction transaction= session.beginTransaction();
		Modulo modulo =(Modulo) session.get(Modulo.class, nombre);
		transaction.commit();
		return modulo;
	}
	public Matricula buscarMatricula(String nombreModulo, String nombreCiclo,String dniEstudiante,int cursoAcademico) {
		Matricula matricula = null;
		SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
		Session session= sessionFactory.openSession();
		Transaction transaction= session.beginTransaction();
		MatriculaId id= new MatriculaId(cursoAcademico,dniEstudiante,nombreModulo,nombreCiclo);
		matricula= (Matricula) session.get(Matricula.class, id);
		transaction.commit();
		return matricula;
		
	}
	public Nota buscarNota(int cursoAcademico, String dniEstudiante,int evaluacion, String nombreCiclo, String nombreModulo, String tipoNota) {
		Nota nota = null;
		SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
		Session session= sessionFactory.openSession();
		Transaction transaction= session.beginTransaction();
		NotaId id= new NotaId(cursoAcademico,dniEstudiante,evaluacion,nombreCiclo,nombreModulo, tipoNota);
		nota= (Nota) session.get(Nota.class, id);
		transaction.commit();
		return nota;
		
	}
	public void profesorHoras(String dni) {
		Profesor p= buscarProfesor(dni);
		ArrayList<Modulo> modulos= new ArrayList<Modulo>();
		modulos.addAll(p.getModulos());
		ComparatorHoras ch= new ComparatorHoras();
		modulos.sort(ch);
		System.out.println(p.toString());
		for(Modulo m:modulos) {
			System.out.println(m.toString());
		}
	}
	public void alumnoNotas(String dni) {
		Nota nota= null;
		Alumno a= buscarAlumno(dni);
		System.out.println(a.toString());
		ArrayList<Nota> notas= new ArrayList<Nota>();
		ArrayList<NotaId> id= new ArrayList<NotaId>();
		notas.addAll(a.getNotas());
		for(Nota n:notas) {
			id.add(n.getId());
		}
		SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
		Session session= sessionFactory.openSession();
		Transaction transaction= session.beginTransaction();
		ComparatorNotasModulo cnm= new ComparatorNotasModulo();
		ComparatorNotasEvaluacion cne= new ComparatorNotasEvaluacion();
		ComparatorNotasTipo cnt= new ComparatorNotasTipo();
		id.sort(cnm.thenComparing(cne.thenComparing(cnt)));
		for(NotaId q:id) {
			nota= (Nota) session.get(Nota.class, q);
			System.out.println(nota.toString());
		}
		transaction.commit();
		
	}
	public void nuevoProfesor(String dni,String nombre, String apellidos,String especialidad,Set modulos ) {
		SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
		Session session= sessionFactory.openSession();
		Transaction transaction= session.beginTransaction();
		Profesor p= new Profesor(dni,nombre,apellidos, especialidad,modulos);
		session.save(p);
		ArrayList<Modulo> list= new ArrayList<Modulo>();
		list.addAll(modulos);
		for(Modulo m: list) {
			m.setProfesor(p);
			session.saveOrUpdate(m);
		}
		transaction.commit();
	}
	public void nuevoAlumno(String dni, String nombre, String apellidos,Integer edad,Set notas, Set matriculas) {
		ArrayList<Nota> notasList= new ArrayList<Nota>();
		ArrayList<Matricula> matriculasList= new ArrayList<Matricula>();
		notasList.addAll(notas);
		matriculasList.addAll(matriculas);
		Alumno alumno = new Alumno(dni,nombre,apellidos,edad,notas,matriculas );
		SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
		Session session= sessionFactory.openSession();
		Transaction transaction= session.beginTransaction();
		session.save(alumno);
		for(Nota n: notasList) {
			n.setAlumno(alumno);
			session.saveOrUpdate(n);
		}
		for(Matricula m:matriculasList) {
			m.setAlumno(alumno);
			session.saveOrUpdate(m);
		}
		transaction.commit();
		
	}
	public void nuevoCiclo(String abreviatura,String nombreCompleto, Integer cursos, Set notas, Set modulos, Set matriculas) {
		ArrayList<Nota> notasList= new ArrayList<Nota>();
		ArrayList<Matricula> matriculasList= new ArrayList<Matricula>();
		ArrayList<Modulo> modulosList= new ArrayList<Modulo>();
		notasList.addAll(notas);
		matriculasList.addAll(matriculas);
		modulosList.addAll(modulos);
		Ciclo ciclo= new Ciclo(abreviatura, nombreCompleto, cursos, notas, modulos, matriculas) ;
		SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
		Session session= sessionFactory.openSession();
		Transaction transaction= session.beginTransaction();
		session.save(ciclo);
		for(Nota n: notasList) {
			n.setCiclo(ciclo);
			session.saveOrUpdate(n);
		}
		for(Matricula m:matriculasList) {
			m.setCiclo(ciclo);
			session.saveOrUpdate(m);
		}
		for(Modulo mod: modulosList) {
			mod.setCiclo(ciclo);
			session.saveOrUpdate(mod);
		}
		transaction.commit();
		
	}
	
	
}




