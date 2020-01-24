package serpis.ad;
import java.util.*;
import java.time.LocalDateTime;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateMain {

	public static void main(String[] args) {
		
		System.out.println("Base de datos");
		System.out.println("Funciones: ");
		System.out.println("1.Añadir");
		System.out.println("2.Modificar");
		System.out.println("3.Eliminar");
		System.out.println("4.Ver lista articulos");
		
		Scanner sc = new Scanner(System.in);
		int operacion = sc.nextInt();
		
		switch (operacion) {
		
		case 1:
			
			System.out.println("Vas a añadir un pedido");
			nuevoPedido();
			break;
		
		case 2:
			
			System.out.println("Vas a modificar un pedido");
			modificarPedido();
			break;
			
		case 3:
			
			System.out.println("Vas a borrar un pedido");
			eliminarPedido();
			break;
			
		
		
		}
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("serpis.ad");
		
		Categoria categoria = new Categoria();
		categoria.setNombre("cat " + LocalDateTime.now());
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(categoria);
		
		List<Categoria> categorias = entityManager.createQuery("from Categoria order by Id", Categoria.class).getResultList();
		show(categorias);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		
		entityManagerFactory.close();
		
		

	}
	
	private static void show(List<Categoria> categorias) {
		for (Categoria categoria : categorias)
			System.out.printf("%3d %s %n", categoria.getId(), categoria.getNombre());		
	}
	
	
	
	public static void nuevoPedido() {
		Scanner sc = new Scanner(System.in);
		Categoria categoria = new Categoria();
		
		
	
	}
	
	
	
	
	public static void modificarPedido() {
		
	}

	
	public static void eliminarPedido() {
		
		
	}
	
}
