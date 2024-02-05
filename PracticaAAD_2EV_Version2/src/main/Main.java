package main;

import java.util.HashSet;
import java.util.Set;

import hibernate.Predeterminados;

public class Main {

	public static void main(String[] args) {
		Set set= new HashSet<>();
		String nombre= "Paco";
		String apellido= "Perez";
		String especialidad= "Programador";
		String dni="12345678B";
		Predeterminados p= new Predeterminados();
		p.nuevoProfesor(dni,nombre,apellido,especialidad, set);

	}

}
