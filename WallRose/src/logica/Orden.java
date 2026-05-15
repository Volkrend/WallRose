package logica;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Orden {
	private Integer numOrden;
	private LocalDateTime fecha;
	private Integer estado;
	private List<Linea> lineas = new ArrayList<>();
	private Cliente cliente;

	private static Double impuesto = 0.13;
	
	public Orden(Integer estado, Integer numOrden, Cliente cliente) {
		this.cliente = cliente;
		this.numOrden = numOrden;
		this.fecha = LocalDateTime.now();
		this.estado = estado;
	}

	public Integer getNumOrden() {
		return numOrden;
	}

	public void setNumOrden(Integer numOrden) {
		this.numOrden = numOrden;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public LocalDateTime getFecha() {
		return fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public static Double getImpuesto() {
		return impuesto;
	}
	public List<Linea> getLineas() {
		return lineas;
	}
	//AGREGADAS
	
	//Suma el costo de todas las líneas, sin impuesto
	public double calcularMonto() {
        double total = 0;
        
        for (Linea l : lineas) {
            total += l.calcularCosto();
        }
        return total;
    }
 
    // valor del impuesto en el monto
    public double calcularMontoImpuesto() {
        return calcularMonto() * impuesto;
    }
 
    // Total final: monto + impuesto
    public double calcularMontoTotal() {
        return calcularMonto() + calcularMontoImpuesto();
    }
 
    // Agrega una línea al final de la lista
    public void agregarLinea(Linea linea) {
        lineas.add(linea);
    }
 
    // Borra la línea en la posición indicada (0 = primera)
    public void borrarLinea(int numLinea) {
        if (numLinea >= 0 && numLinea < lineas.size()) {
            lineas.remove(numLinea);
        }
    }
	
}
