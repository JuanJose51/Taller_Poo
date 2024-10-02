package Main;
import javax.swing.JOptionPane;
import Logica.Empleado;
import Logica.Empresa;

public class Main {
	
    public static Empresa a = new Empresa("sofwat");

	public static void main(String[] args) {
		int opcionMenu=0;
		String menu ="Menu principal ingrese un numero de la lista.\n"
		 +"1. Agregar empleado \n"
		 + "2. eliminar empleado \n"
	     + "3. actualizar empleado \n"
		 + "4 agregar comicion a empleado\n"
	     + "5. listar empleados \n"
	     + "6. empleado con salario más alto \n"
	     + "7. empleado con más comisiones \n"
	     + "8.promedio de el salario de los empleados \n"
	     + "9.Rango de sueldo\n "
	     + "10. nomina de todos los  empleados\n"
	     + "11.salir";
		do {
		    opcionMenu =Integer.parseInt(JOptionPane.showInputDialog(menu));
		    opcnMenu(opcionMenu);
		}while(opcionMenu != 11);
	}
	public static void opcnMenu(int obcionMenu) {
		switch(obcionMenu) {
		case 1:
			crearEmpleado();
			break;
		case 2:
			cancelarEmpleado();
			break;
		case 3:
			int id = Integer.parseInt(JOptionPane.showInputDialog("ingrese el id del empleado"));
			actualizarEmpleado(id);
			break;
		case 4:
			int Id = Integer.parseInt(JOptionPane.showInputDialog("inngrese el id del emleado"));
			agregarComicion(Id);
			break;
		case 5:
			listarEmpleadoEmpresa();
			break;
		case 6:
			 mayorSueldo();
			break;
		case 7:
			mayorComicion();
			break;
		case 8:
			promediSueldo();
			break;
		case 9:
			rangoSueldos();
			break;
		case 10:
			nominaTotal();
			break;
		default:
			break;
		}
	}
	private static void crearEmpleado(){ 
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado");
		int edad =Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del empleado"));
		int id =Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del empleado "));
		int salarioBase=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el salari base del empleado"));
		Empleado e = new Empleado(nombre,edad,salarioBase,id);
		boolean estado = a.agregarEmpleado(e);
		String Mensaje;
		Mensaje = estado == true ? "el empleado fue agregado exitosamente" : "el empleado ya existe, no pudo ser agregado ";
		JOptionPane.showMessageDialog(null,Mensaje);	
	}
	private static void cancelarEmpleado() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("ingrese el  id del empleapo"));
		boolean estado =a.eliminarEmpleado(id);
		String Mensaje;
		Mensaje = estado ==true ?"el empleado fue eliminado con exito" : "el empleado no se empleado encontro";
		JOptionPane.showMessageDialog(null, Mensaje);
	}
	private static void actualizarEmpleado(int id){
		Empleado e = a.buscarEmpleado(id);
		String Mensaje;
		if(e != null) {
			String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado");
			int edad =Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del empleado"));
			int Id =Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del empleado "));
			int salarioBase=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el salari base del empleado"));
			a.actulizarEmpleado( nombre, edad, salarioBase, Id, e );
			String mensaje;
			mensaje ="se actualizo con exito";
			JOptionPane.showMessageDialog(null,mensaje);
		}else {
		Mensaje ="No se pudo actualizar el contacto ";
		JOptionPane.showMessageDialog(null,Mensaje);
		}
	}
	
	private static void agregarComicion(int id) {
		Empleado e =a.buscarEmpleado(id);
		if (e != null) {
			int comicion =Integer.parseInt(JOptionPane.showInputDialog("inggrese la comicion del empleado"));
			a.agregarComicion(comicion, e);
			JOptionPane.showMessageDialog(null,"se aagrego con exito"); 
		}else {
			String Mensaje = "no se pudo agregar";
			JOptionPane.showMessageDialog(null,Mensaje);
			
		}
	}
	private static void listarEmpleadoEmpresa() {
		String mensaje = a.listaEmpleado(); 
		JOptionPane.showMessageDialog(null, mensaje);
	}
	private static void mayorSueldo() {
		String mensaje=a.mayorSalario();
		JOptionPane.showMessageDialog(null,mensaje);
	}
	private static void mayorComicion() {
		String mensaje=a.mayorComicion();
		JOptionPane.showMessageDialog(null,mensaje);
	}
	private static void promediSueldo() {
		String mensaje=a.promedioSalarios();
		JOptionPane.showMessageDialog(null,mensaje);
	}
	private static void rangoSueldos() {
		int mayor=a.mayorSueldoBase();
		int menor =a.menorSueldoBase();
		String mensaje ="el rango de sueldos es de"+mayor+" a "+menor;
		JOptionPane.showMessageDialog(null, mensaje);
	}
	private static void nominaTotal() {
		int nomina=a.nominaTotal();
		String mensaje="Nomina Total :"+nomina;
		JOptionPane.showMessageDialog(null, mensaje);
		
	}
	private static void quemarEmpleados() {
	}
}
