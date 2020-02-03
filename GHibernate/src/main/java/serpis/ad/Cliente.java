package serpis.ad;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nombre;
	
	@OneToMany(targetEntity=Pedido.class,cascade=CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name ="cliente")
	
	public Long getId() {
		return id;
		
	}

	public void setId(Long id) {
		this.id = id;
		
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
