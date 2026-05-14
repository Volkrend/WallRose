package logica;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Orden {
	private static int consecutivo = 1;
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

	public static int getConsecutivo() {
		return consecutivo;
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
	
}
