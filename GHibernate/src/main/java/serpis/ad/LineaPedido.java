package serpis.ad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.sound.sampled.Line;

@Entity
public class LineaPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn (name = "pedido")
	
	private Pedido pedido;
	@ManyToOne
	@JoinColumn (name = "articulo")
	private Articulo articulo;
	
	
	private double precio = 0.0;
	private float unidades = 0.0f;
	private float importe = 0.0f;
	
	

	public LineaPedido() {} //Hibernate necesita un ctor sin parámetros
	
	public LineaPedido(Pedido pedido) {
		this.pedido = pedido;
		pedido.getLineaPedidos().add(this);
}
	

	
	public Long getId() {
		return id;
		
	}
	
	public Pedido getPedido() {
		return pedido;
		
	}
	
	public void setArticulo(Articulo articulo) {
		this.precio = articulo.getPrecio();
		this.unidades = 1.0f;
		this.articulo = articulo;
	}
	
	public double getPrecio(){
		return precio;
		
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
		
	}

	
	public void setUnidades(float unidades) {
		this.unidades = unidades;
		
	}
	
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	
	
	@PrePersist
	@PreUpdate
	private void setImporte() {
		importe = (float)precio * unidades;
	}
	
	public float getImporte() {
		getImporte();
		return importe;
	}
}
