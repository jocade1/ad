package serpis.ad;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime fecha = LocalDateTime.now();
	private float importe =0.0f;
	@ManyToOne
	@JoinColumn(name="cliente")
	private Cliente cliente;
	@OneToMany (mappedBy ="pedido",cascade = CascadeType.ALL,orphanRemoval = true)
	
	private List<LineaPedido> lineasPedido;
		
	public Pedido() {
		
	}
	
	public Pedido(Cliente cliente) {
		this.cliente=cliente;
	}
	
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public LocalDateTime getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
		
	}
	
	
	public float getImporte() {
		return importe;
	}
	
	public void setImporte(float importe) {
		this.importe = importe;
		
	}
	 
	
	public List<LineaPedido> getLineaPedidos() {
		return lineasPedido;
	}


	public void setLinea_pedido(List<LineaPedido> lineasPedido) {
		this.lineasPedido = lineasPedido;
}
	


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
}
	
	
	

}
