package es.imatia.clase2;

import java.time.LocalDate;

public class Empleado {

	protected String nombre;
	protected int edad;
	protected LocalDate fechaIngreso;
	protected double salarioAnual;
	protected final double BONO = 1000.0; 
	
	public Empleado(String nombre, int edad, LocalDate fechaIngreso, double salarioAnual) {
		this.nombre = nombre;
		this.edad = edad;
		this.fechaIngreso = fechaIngreso;
		this.salarioAnual = salarioAnual;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public double getSalarioAnual() {
		return salarioAnual;
	}

	public void setSalarioAnual(double salarioAnual) {
		this.salarioAnual = salarioAnual;
	}
	
	public void incentivar( ) {
		System.out.println("Empleado [nombre = " + nombre + ", edad = " + edad + ", fechaIngreso = " + fechaIngreso + ", salarioAnual = "
				+ salarioAnual + ", BONO = " + BONO + "]");
	}
	
}

