package serpis.ad.ClasesDao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.math3.geometry.euclidean.threed.Line;

import serpis.ad.Articulo;
import serpis.ad.LineaPedido;
import serpis.ad.Pedido;

public class LineaPedidoDao {
	public static EntityManagerFactory entityManagerFactory;
	public static EntityManager entityManager;
	public static Scanner sc = new Scanner(System.in);
	
	
	public static void insert() {
		entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad.ghibernate");
		entityManager=entityManagerFactory.createEntityManager();	
		LineaPedido lineaPedido = new LineaPedido();
		System.out.println("Pedido");
		Pedido pedido = entityManager.find(Pedido.class, sc.nextLong());
		lineaPedido.setPedido(pedido);
		System.out.println("Producto: ");
		Articulo articulo = entityManager.find(Articulo.class,sc.nextLong()); 
		lineaPedido.setArticulo(articulo);
		System.out.println("Precio: ");
		float precio=sc.nextFloat();
		lineaPedido.setPrecio(precio);
		float unidades=sc.nextFloat();
		lineaPedido.setUnidades(unidades);
		float importe=sc.nextFloat();
		lineaPedido.setImporte();
		entityManager.getTransaction().begin();
		entityManager.persist(lineaPedido);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
	
	
	
	}
	
	
	public static void show() {
		
		entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad.ghibernate");
		entityManager=entityManagerFactory.createEntityManager();
		List<LineaPedido>lineaPedidos = entityManager.createQuery("from pedidolinea order by id", LineaPedido.class).getResultList();
		for(LineaPedido lineaPedido : lineaPedidos)
			System.out.printf("%f  %l  %s %f %f %f %n", lineaPedido.getId(),lineaPedido.getPedido().getId(),
					lineaPedido.getArticulo().getNombre(),lineaPedido.getPrecio(),lineaPedido.getUnidades(),lineaPedido.getImporte());
		entityManager.close();
	}

}
