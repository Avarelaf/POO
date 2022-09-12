package es.imatia.clase2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Operario extends Empleado {

	protected int nivel;
	
	public Operario(String nombre, int edad, LocalDate fechaIngreso, int salarioAnual, int nivel) {
		super(nombre, edad, fechaIngreso, salarioAnual);
		this.nivel = nivel;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	
	public void actualizarNivel() {
		
		long diff = this.getFechaIngreso().until(LocalDate.now(), ChronoUnit.YEARS);
		
		if (diff > 2 && this.nivel < 5) {
			this.nivel++;
		}
	}
	
	
	
	@Override
	public void incentivar() {
		
		if (this.getEdad() > 30 && this.nivel > 2) {
			this.setSalarioAnual(this.getSalarioAnual() + this.BONO * 2);
			System.out.println("Salario doblemente incentivado " + this.salarioAnual);
		}
		else if (this.getEdad() > 30 || this.nivel > 2) {
			this.salarioAnual += this.BONO;
			System.out.println("Salario incentivado " + this.salarioAnual);
		}
		
	}
}
