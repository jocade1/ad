package serpis.ad.ClasesDao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import serpis.ad.Articulo;
import serpis.ad.Cliente;
import serpis.ad.LineaPedido;
import serpis.ad.Pedido;

public class PedidoDao {
	
	public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("serpis.ad.ghibernate");
	public static EntityManager entityManager=entityManagerFactory.createEntityManager();
	public static Scanner sc = new Scanner(System.in);
	public static Pedido pedido = new Pedido();
	public static LineaPedido lineaPedido = new LineaPedido(pedido);
	public static Cliente cliente;
	public static Articulo articulo;
	
	public static void insert() {
		

		LocalDateTime fecha=LocalDateTime.now();
		pedido.setFecha(fecha);
		System.out.println("Introduce id del cliente");
		cliente = entityManager.find(Cliente.class, sc.nextLong());
		pedido.setCliente(cliente);
		lineaPedido.setPedido(pedido);
		System.out.println("Id articulo");
		Long articuloId = sc.nextLong();
		articulo = entityManager.find(Articulo.class,articuloId);
		lineaPedido.setArticulo(articulo);
		lineaPedido.setPrecio(articulo.getPrecio());
		System.out.println("Cantidad");
		float unidades = sc.nextFloat();
		lineaPedido.setUnidades(unidades);
		//lineaPedido.setImporte();
		entityManager.getTransaction().begin();
		entityManager.persist(pedido);

		entityManager.getTransaction().commit();
		
		
		
		
	}
//		Pedido pedido = new Pedido();
//		System.out.println("Indique el precio");
//		Long precio = sc.nextLong();
//		pedido.setImporte(precio);
//		LocalDateTime fecha = LocalDateTime.now();
//		pedido.setFecha(fecha);
//		System.out.println("id del cliente");
//		Cliente cliente = entityManager.find(Cliente.class,sc.nextLong());
//		pedido.setCliente(cliente);
//		entityManager.getTransaction().begin();
//		entityManager.persist(pedido);
//		entityManager.getTransaction().commit();
	
	
	
	
	public static void update() {
		System.out.println("Introduce id a cambiar");
		Long pedidoId = sc.nextLong();
		pedido=entityManager.find(Pedido.class, pedidoId);
		entityManager.getTransaction().begin();
		System.out.println("Precio");
		float importe = sc.nextFloat();
		System.out.println();
		pedido.setImporte(importe);
		System.out.println("Id cliente");
		cliente=entityManager.find(Cliente.class, sc.nextLong());
		pedido.setCliente(cliente);
		entityManager.getTransaction().commit();
		entityManager.close();
		//lineaPedido.setImporte(importe);
		
	}
	
	public  static void show(){
		List<Pedido>pedidos= entityManager.createQuery("from Pedido order by id", Pedido.class).getResultList();
		System.out.println("ID  "+"  Fecha  "+"  Nombre  "+"  Precio  ");
		for (Pedido pedido : pedidos)
			System.out.printf("%d  %s  %s %d %n", pedido.getId(), pedido.getFecha(),pedido.getCliente().getNombre(),pedido.getImporte());	

}

}
