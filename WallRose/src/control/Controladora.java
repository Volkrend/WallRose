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
	private int consecutivoP = 1;
	private int consecutivoO = 1; //manejarlos mas facil

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
                resultado.add(o);                                  
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
    
    //METODOS DE PRODUCTOS//
    
    //Obtener listado de productos (código, nombre, existencias, unidad, precio). Ordenado por código.
    public ArrayList<Producto> obtenerProductos() {
        return new ArrayList<>(productos.values());
    }
    
    public Producto obtenerProducto(Integer codigoP) {
    	return productos.get(codigoP);
    }
    
    //Crear producto nuevo a partir (nombre, existencias, unidad, precio)
    public void crearProducto(String nombre, Double existencias, String unidad, Double precio) {
    	Producto nuevo = new Producto(consecutivoP, nombre, existencias, unidad, precio);
        productos.put(consecutivoP, nuevo);
    }
    //Obtener los datos de un producto a partir del código, nombre, existencias, unidad, precio
    public Producto datosProducto(Integer codigoP) {
        return productos.get(codigoP);
    }
    //Actualizar un producto partir del código, nombre, existencias, unidad, precio.
    public void actualizarProducto(Integer codigoProducto, String nombre, Double existencias, String unidad, Double precio) {
		Producto p = obtenerProducto(codigoProducto); //agregar falta                              
			p.setNombre(nombre);
			p.setExistencias(existencias);
			p.setUnidad(unidad);
			p.setPrecio(precio);
		}
    // Borrar un producto a partir del código.
    public void borrarProducto(Integer codigoProducto) {
        productos.remove(codigoProducto);
    }
    
    //METODOS ORDEN//
    
    //Obtener los datos de una orden de compra a partir de su número 
    //(id de cliente, nombre de cliente, estado, fecha, monto, monto del impuesto, monto total)
    public Orden obtenerOrden(Integer numeroOrden) {
        return ordenes.get(numeroOrden);
    }
    
    //Obtener listado de órdenes de compra. Ordenado por número de orden
    public ArrayList<Orden> obtenerListadoOrdenes() {
        return new ArrayList<>(ordenes.values());
    }
    //Obtener monto total de todas las órdenes pendientes.
    public Double obtenerMontoTotalPendiente() {
        double total = 0;
        for (Orden o : ordenes.values()) {                        
            if (o.getEstado() == 1) {       
                total += o.calcularMontoTotal();  //agregar falta
            }
        }
        return total;
    }
    //Crear orden de compra vacía a partir del ID del cliente. Iniciada, fecha actual, sin líneas. Retornar el número de orden.
    public void crearOrdenVacia(String idCliente) throws Exception { 
        Cliente c = clientes.get(idCliente); //restriccion
        if (c == null) {
           throw new Exception("Error: cliente no encontrado.");
        }
        
        int numOrden = consecutivoO;
        Orden nueva = new Orden(0, numOrden, c);
        ordenes.put(numOrden, nueva);       // 
        c.getOrdenes().add(nueva);          // revisar, cambiar
        consecutivoO++;

    }
    
    //Obtener listado de línead e una orden de compra a partir de su número 
    //(código de producto, nombre de producto, cantidad, unidades, costo de línea).
    public ArrayList<Linea> obtenerLineasOrden(Integer numOrden) { //agregado profe
        Orden o = ordenes.get(numOrden);
        return new ArrayList<>(o.getLineas());
    }
    
    //Poner orden como pendiente, a partir de su número.
    public void ponerOrdenPendiente(Integer numeroOrden) {
        Orden o = obtenerOrden(numeroOrden);
        if (o != null) {
            o.setEstado(1);
        }
    }
    //Poner orden como terminada, a partir de su número.
    public void ponerOrdenTerminada(Integer numeroOrden) {
        Orden o = obtenerOrden(numeroOrden);
        if (o != null) {
            o.setEstado(2);
        }
    }
    
    //Agregar línea a una orden, a partir de número de orden, código de producto y la cantidad.
    public void agregarLineaOrden(Integer numeroOrden, Integer codigoProducto, Double cantidad) {
    	Orden    o = obtenerOrden(numeroOrden);         
        Producto p = obtenerProducto(codigoProducto);  
        
	    Linea linea = new Linea(p, cantidad);  
	    o.agregarLinea(linea);        //agregar                   
}
    // Actualizar una línea de una orden.
    public void actualizarLineaOrden(Integer numOrden, Integer numLinea, Integer codigoP, Double cantidad) {
        Orden o = ordenes.get(numOrden);        // busca la orden
        Producto p = productos.get(codigoP);    // busca el nuevo producto
        
        Linea linea = o.getLineas().get(numLinea);  // agarra la línea 
        
        linea.setProducto(p);      // le cambia el producto
        linea.setCantidad(cantidad); // le cambia la cantidad
    }
    
    //Borrar una línea de una orden, a partir del número de orden y número de línea.
    	public void borrarLineaOrden(Integer numeroOrden, Integer numeroLinea) {
            Orden o = obtenerOrden(numeroOrden);
            if (o != null) {
                o.borrarLinea(numeroLinea); //metodo agregar
            }
        }
     
}
 

    
