package Logica;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Empresa {
	private String nombre;
	private ArrayList<Empleado> Empleados;
	
    public Empresa(String nombre){
	    this.nombre = nombre;
	    this.Empleados = new ArrayList<>();
	}

/******************************
 *    METODOS DE EMPLEADO     *
 ******************************/
	public boolean existeEmpleado(Empleado empleado) {
		for(Empleado c : this.Empleados) {
			int id = empleado.getId();
			if(c.getId() == id) {
				return true;	
			}
		}
		return false;
	}
	
	public boolean agregarEmpleado(Empleado empleado) {
		boolean existe = existeEmpleado(empleado);
		if(existe != true) {
			this.Empleados.add(empleado);
			return true;
		}
		return false;
	}
	public Empleado buscarEmpleado(int id) {
		for(Empleado e : this.Empleados ) {
			if(e.getId() == id) {
				return e;
			}
		}
		return null;
	}
	public boolean eliminarEmpleado(int id) {
		Empleado e =buscarEmpleado(id);
		if(e == null) {
			return false;
		}
		this.Empleados.remove(e);
		return true;
	}
	public boolean actulizarEmpleado(String nombre, int edad, int salarioBase, int id,Empleado c) {
		c.setNombre(nombre);
		c.setEdad(edad);
		c.setSalarioBase(salarioBase); 
		c.setId(id);
		return true;
	}
	public void agregarComicion(int comicion,Empleado c) {
		c.setComisiones(comicion);
	}
	public String listaEmpleado() {
		String lista = "";
		for(Empleado e : this.Empleados) {
			lista+="Nombre :"+e.getNombre()+" id :"+ e.getId()+"\n";
		}
		return lista; 
	}

	public void ajustarSalarioo(int porcentaje, Empleado e) {
	    	int salarioBase = e.getSalarioBase();
	    	int porcenta = porcentaje / 100;
	    	int incremento = porcenta * salarioBase;
	    	int Total = salarioBase + incremento;
	    	e.setSalarioBase(Total);
	     }
	public String mayorSalario() {
		int mayorSueldo=0;
		int sueldoActual=0;
		String mensaje="";
		for(Empleado e:this.Empleados) {
			sueldoActual = e.totalComicion();
			sueldoActual += e.getSalarioBase();
			if(sueldoActual > mayorSueldo) {
				mayorSueldo = sueldoActual;
				mensaje = e.getNombre()+" Tiene el mayor salario que es de "+ mayorSueldo;
			}
		}
		return mensaje;
	}
	public String mayorComicion() {
		int mayorComicion=0;
		int comiciondoActual=0;
		String mensaje="";
		for(Empleado e:this.Empleados) {
			comiciondoActual = e.totalComicion();
			if(comiciondoActual > mayorComicion) {
				mayorComicion = comiciondoActual;
				mensaje = e.getNombre()+" Tiene la mayor comicion que es de "+ mayorComicion;
			}
		}
		return mensaje;
	}
	public String promedioSalarios() {
		int tamañoLista = this.Empleados.size();
		int sueldo= 0;
		int total=0;
		String mensaje="";
		for(Empleado e : this.Empleados) {
			sueldo += e.getSalarioBase();
		}
		total = sueldo/tamañoLista;
		mensaje ="promedio de los sueldos  es de :"+total;
		return mensaje;
	}
	public int mayorSueldoBase() {
		int mayorSueldo=0;
		int sueldoActual=0;
		for(Empleado e:this.Empleados) {
			sueldoActual = e.getSalarioBase();
			if(sueldoActual > mayorSueldo) {
				mayorSueldo = sueldoActual;
			}
		}
		return mayorSueldo;
	}
	public int menorSueldoBase() {
		int menorSueldo=mayorSueldoBase();
		int sueldoActual=0;
		for(Empleado e:this.Empleados) {
			sueldoActual = e.getSalarioBase();
			if(sueldoActual < menorSueldo) {
				menorSueldo = sueldoActual;
			}
		}
		return menorSueldo;
	}
	public int nominaTotal() {
		int sueldo =0;
		for(Empleado e:this.Empleados) {
			sueldo +=e.getSalarioBase();
		}
		return sueldo;
	} 

}
