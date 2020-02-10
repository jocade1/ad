package serpis.ad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.sound.sampled.Line;

@Entity(name="pedidolinea")

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
	
	@Column
	private float precio = 0.0f;
	
	@Column
	private float unidades = 0.0f;
	
	@Column
	private float importe ;
	
	
	
	

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
		this.articulo = articulo;
	}
	
	public float getPrecio(){
		return precio;
		
	}
	
	public float getUnidades() {
		return unidades;
	}

	
	public void setPrecio(float precio) {
		this.precio = precio;
		
	}

	
	public void setUnidades(float unidades) {
		this.unidades = unidades;
		
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido=pedido;
	}


	
	
	@PrePersist
	@PreUpdate
	public void setImporte() {
		System.out.println("calculando importe :" + unidades * precio);
		this.importe = unidades*precio;
	}
	
	public float getImporte() {
		if(this.importe == 0f)
			this.setImporte();
		return importe;
	}
	
	public Articulo getArticulo() {
		return articulo;
	}


}
