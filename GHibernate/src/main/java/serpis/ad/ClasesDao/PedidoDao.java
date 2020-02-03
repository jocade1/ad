package serpis.ad.ClasesDao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import serpis.ad.Cliente;
import serpis.ad.Pedido;

public class PedidoDao {
	
	public static EntityManagerFactory entityManagerFactory;
	public static EntityManager entityManager;
	public static Scanner sc = new Scanner(System.in);
	
	public void insert() {
		Pedido pedido = new Pedido();
		System.out.println("Indique el precio");
		Long precio = sc.nextLong();
		pedido.setImporte(precio);
		LocalDateTime fecha = LocalDateTime.now();
		pedido.setFecha(fecha);
		System.out.println("id del cliente");
		Cliente cliente = entityManager.find(Cliente.class,sc.nextLong());
		pedido.setCliente(cliente);
		entityManager.getTransaction().begin();
		entityManager.persist(pedido);
		entityManager.getTransaction().commit();
	}
	
	public  static void show(){
		List<Pedido>pedidos= entityManager.createQuery("from Pedido order by id", Pedido.class).getResultList();
		System.out.println("ID  "+"  Fecha  "+"  Nombre  "+"  Precio  ");
		for (Pedido pedido : pedidos)
			System.out.printf("%d  %s  %s %d %n", pedido.getId(), pedido.getFecha(),pedido.getCliente().getNombre(),pedido.getImporte());	

}

}
