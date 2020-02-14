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
		lineaPedido.setImporte();
		entityManager.getTransaction().begin();
		entityManager.persist(pedido);

		entityManager.getTransaction().commit();
		
		
		
		
	}

	
	
	
	public static void update() {
		System.out.println("Introduce id a cambiar");
		Long pedidoId = sc.nextLong();
		pedido=entityManager.find(Pedido.class, pedidoId);
		entityManager.getTransaction().begin();
		Long lineaId = sc.nextLong();
		lineaPedido =entityManager.find(LineaPedido.class,lineaId);
		System.out.println("Precio");
		float precio= sc.nextFloat();
		lineaPedido.setPrecio(precio);
		float unidades = sc.nextFloat();
		lineaPedido.setUnidades(unidades);
		System.out.println("Id cliente");
		cliente=entityManager.find(Cliente.class,sc.nextLong());
		pedido.setCliente(cliente);

		entityManager.getTransaction().commit();

	}
	
	public static void delete() {
		System.out.println("Id a borrar");
		Long pedidoId = sc.nextLong();
		pedido=entityManager.find(Pedido.class,pedidoId);
		entityManager.getTransaction().begin();
		entityManager.remove(pedido);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public  static void show(){
		entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad.ghibernate");
		entityManager=entityManagerFactory.createEntityManager();
		
		List<Pedido>pedidos= entityManager.createQuery("from Pedido order by id", Pedido.class).getResultList();
		System.out.println("ID  "+"  Fecha  "+"  Nombre  "+"  Precio  ");
		for (Pedido pedido : pedidos)
			System.out.printf("%d  %s  %s %d %n", pedido.getId(), pedido.getFecha(),pedido.getCliente().getNombre(),pedido.getImporte());	

}

}
