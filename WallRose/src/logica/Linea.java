package logica;

public class Linea {
	
    private double cantidad;
    private Producto producto;

    public Linea(Producto producto, double cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public double getCantidad() { 
    	return cantidad; 
    	}
    public void setCantidad(double cantidad) { 
    	this.cantidad = cantidad; 
    	}

    public Producto getProducto() { 
    	return producto; 
    	}

    // precio unitario × cantidad
    public double calcularCosto() {
        return producto.getPrecio() * cantidad;
    }
}
