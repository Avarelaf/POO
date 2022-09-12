package es.imatia.clase2;

import java.time.LocalDate;


public class Ejercicio2 {

	public static void main(String[] args) {
		
	
		Empleado em = new Empleado("Fulano", 44, LocalDate.of(1980,05,19), 24000);
		
		Director dir = new Director("Mengano", 32, LocalDate.of(1972,10,22), 50000, "Ventas", 16);
		
		Operario op = new Operario("Zutano", 26, LocalDate.of(1997,9,06), 18000, 2);
		
		
		em.incentivar();
		
		dir.incentivar();
		
		op.incentivar();
		op.actualizarNivel();
		op.incentivar();
		
		
		
		

	}

}
