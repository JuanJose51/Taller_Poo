package Logica;
import java.util.ArrayList; 

public class Empleado {
	private String nombre;
	private int edad;
	private int salarioBase;
	private int id;
	private ArrayList<Integer> comisiones;
	
	public Empleado(String nombre, int edad, int salarioBase, int id) {
		this.nombre = nombre;
		this.edad = edad;
		this.salarioBase = salarioBase;
		this.id = id;
		this.comisiones = new ArrayList<>();
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

	public int getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(int salarioBase) {
		this.salarioBase = salarioBase;
	}

	public ArrayList<Integer> getComisiones() {
		return comisiones; 
	}

	public void setComisiones(int comisiones) {
		this.comisiones.add(comisiones);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int totalComicion() {
		int total=0;
		for(int e:this.comisiones) {
			total+=e;
		}
		return total;
	}
	
}
