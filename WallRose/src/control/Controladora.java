package control;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import logica.Cliente;
import logica.Orden;
import logica.Producto;
import logica.Linea;


public class Controladora {
	private static Controladora instance = null;
	private Map<String, Cliente> clientes;
	private Map<Integer, Orden> ordenes;
	private Map<Integer, Producto> productos;

	private Controladora() {
	    this.clientes = new TreeMap<String, Cliente>();
	    this.ordenes = new TreeMap<Integer, Orden>();
	    this.productos = new TreeMap<Integer, Producto>();
	}
	public static Controladora getInstance() { //SINGLETON
		if (instance == null)
			instance = new Controladora();
		return instance;
	}
	//METODOS DE CLIENTE//
	
	//Crear cliente nuevo a partir de ID, nombre y email. 
	public void crearCliente(String idCliente, String nombre, String email) {
		Cliente nuevo = new Cliente(idCliente, nombre, email);  // crea el objeto
        clientes.put(idCliente, nuevo);
    }
	
	public Cliente obtenerCliente(String idCliente) { //profe
		return clientes.get(idCliente);
	}
	//Actualizar cliente a partir de ID, nombre y email.
	public void actualizarCliente(String idCliente, String nombre, String email) {
	    Cliente c = obtenerCliente(idCliente);   
	        if (c != null) {                          
	            c.setNombre(nombre);                  
	            c.setEmail(email);                   
	        }
	 }
	//Borrar un cliente a partir del ID.
	public void borraCliente(String idCliente) {
		clientes.remove(idCliente);
	}
	
	//Obtener listado de clientes (ID, nombre, email). Ordenado por ID.
    public ArrayList<Cliente> obtenerClientes() {
    	return new ArrayList<>(clientes.values()); //ocupa new
    }
    
    //Obtener los datos de un cliente a partir del ID (ID, nombre, email, total pendiente)
    public Cliente buscarCliente(String idCliente) {
    	return (clientes.get(idCliente));
    }
    //Obtener lista de todas las órdenes de un cliente a partir del ID (número, fecha, estado).
    public ArrayList<Orden> obtenerOrdenes(String idCliente) {
    	Cliente c = obtenerCliente(idCliente);
    	return new ArrayList<>(c.getOrdenes());
    }
    //Obtener lista de órdenes iniciadas de un cliente a partir del ID (número, fecha, estado).
    public ArrayList<Orden> obtenerOrdenesIniciadas(String idCliente) { //revisar/cambiar
    	ArrayList<Orden> resultado = new ArrayList<>();  // lista 
    	 
        for (Orden o : obtenerOrdenesIniciadas(idCliente)) {  // recorre todas
            if (o.getEstado() == 1) {           
                resultado.add(o);                                  // agrega si pasa
            }
        }
        return resultado;
    }
    //Obtener lista de órdenes pendientes de un cliente a partir del ID (número, fecha, estado)
    public ArrayList<Orden> obtenerOrdenesPendientes(String idCliente) {
        ArrayList<Orden> resultado = new ArrayList<>();
        for (Orden o : obtenerOrdenesPendientes(idCliente))
            if (o.getEstado() == 1)
                resultado.add(o);
        return resultado;
    }
    //Obtener lista de órdenes terminadas de un cliente a partir del ID (número, fecha, estado)
    public ArrayList<Orden> obtenerOrdenesTerminadas(String idCliente) {
        ArrayList<Orden> resultado = new ArrayList<>();
        for (Orden o : obtenerOrdenesTerminadas(idCliente))
            if (o.getEstado() == 2)
                resultado.add(o);
        return resultado;
    }
}
 

    
