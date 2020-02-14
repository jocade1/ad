package serpis.ad.ClasesDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

import serpis.ad.Cliente;

public class ClienteDao {
	public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("serpis.ad.ghibernate");
	public static EntityManager entityManager = entityManagerFactory.createEntityManager();
	public static Cliente cliente = new Cliente();

	public static Scanner sc = new Scanner(System.in);
	
	public static void insert() {
		
		System.out.println("Introduce nombre del cliente");
		String nombre = sc.nextLine();
		cliente.setNombre(nombre);
		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		entityManager.getTransaction().commit();
		entityManager.close();
		}
	
	
	
	public static void update() {
		
		System.out.println("Indique el id a cambiar");
		Long idCliente = sc.nextLong();
		cliente=entityManager.find(Cliente.class,idCliente);
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Nombre:");
		entityManager.getTransaction().begin();
		cliente.setNombre(sc2.nextLine());
		entityManager.getTransaction().commit();
		entityManager.close();
		
	
		

			
		}
	
	
	
	public static void delete() {
		
		System.out.println("Introduce el id del cliente a eliminar");
		Long id=sc.nextLong();
		cliente=entityManager.find(Cliente.class, id);
    	entityManager.getTransaction().begin();
    	entityManager.remove(cliente);
    	entityManager.getTransaction().commit();
    	entityManager.close();
	}
		
	
		
		
		public static void show() {
			entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad.ghibernate");
			entityManager=entityManagerFactory.createEntityManager();
			List<Cliente> clientes= entityManager.createQuery("from Cliente order by id", Cliente.class).getResultList();
			System.out.println("ID "+" Nombre ");
			for (Cliente cliente : clientes)
				System.out.printf("%d  %s %n ", cliente.getId(), cliente.getNombre()); 

		
		
	}
	

}
