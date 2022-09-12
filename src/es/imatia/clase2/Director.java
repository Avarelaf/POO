package es.imatia.clase2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Director extends Empleado {

	protected String departamento;
	protected int personal;
	
	public Director(String nombre, int edad, LocalDate fechaIngreso, int salarioAnual, String departamento, int personal) {
		super(nombre, edad, fechaIngreso, salarioAnual);
		this.departamento = departamento;
		this.personal = personal;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public int getPersonal() {
		return personal;
	}

	public void setPersonal(int personal) {
		this.personal = personal;
	}
	
	
	@Override
	public void incentivar() {
		long diff = this.getFechaIngreso().until(LocalDate.now(), ChronoUnit.MONTHS);  //Resposta de Zaira
		
		if (diff > 30 && this.personal > 20) {
			this.salarioAnual += this.BONO * 2; 
			System.out.println("Salario doblemente incentivado " + this.salarioAnual);
		}
		else if (diff > 30 || this.personal > 20) {
			this.salarioAnual += this.BONO;
			System.out.println("Salario incentivado " + this.salarioAnual);
		}
		
	}
	
	
}
