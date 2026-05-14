package logica;

public class Producto {
	private static int consecutivoP = 1;
	private Integer codigoP;
	private String nombre;
	private Double existencias;
	private String unidad;
	private Double precio;
	
	public Producto(Integer codigoP, String nombre, Double existencias, String unidad, Double precio) {
		this.codigoP = codigoP;
		this.nombre = nombre;
		this.existencias = existencias;
		this.unidad = unidad;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getExistencias() {
		return existencias;
	}

	public void setExistencias(Double existencias) {
		this.existencias = existencias;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCodigoP() {
		return codigoP;
	}

	public static int getConsecutivo() {
		return consecutivoP;
	}
	
}
