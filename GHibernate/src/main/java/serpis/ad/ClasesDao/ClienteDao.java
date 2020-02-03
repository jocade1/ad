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
	
		}
	
	
	
	public static void update() {
		
		System.out.println("Indique el id a cambiar");
		Long idCliente = sc.nextLong();
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.createQuery("from clientes where id_clientes = idClientes");
		
		System.out.println("Seleccion opcion a cambiar");
		System.out.println("1.Nombre");
		System.out.println("2.Id");
		
		int cambio = sc.nextInt();
		
		switch(cambio) {
		
		case 1 :
			
			break;
			
			
		case 2:
			
			break;
			
			
			
		}
		
	}
		
		
		public static void show() {
			List<Cliente> clientes= entityManager.createQuery("from Cliente order by id", Cliente.class).getResultList();
			System.out.println("ID "+" Nombre ");
			for (Cliente cliente : clientes)
				System.out.printf("%d  %s %n ", cliente.getId(), cliente.getNombre()); 

		
		
	}
	

}
