package logica;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class orden {
	private static int consecutivo = 1;
	private Integer numOrden;
	private LocalDateTime fecha;
	private Integer estado;
	private List<Linea> lineas;
	private cliente Cliente;
	private static Double impuesto = 0.13;
	
	public Orden(Integer estado, Integer numOrden, Cliente cliente) {
		this.Cliente = cliente;
		this.numOrden = numOrden;
		this.fecha = LocalDateTime.now();
		this.estado = estado;
		this.lineas = new  ArrayList<Linea>();
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

	public static int getConsecutivo() {
		return consecutivo;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public List<Linea> getLineas() {
		return lineas;
	}

	public cliente getCliente() {
		return Cliente;
	}

	public static Double getImpuesto() {
		return impuesto;
	}
	
}
