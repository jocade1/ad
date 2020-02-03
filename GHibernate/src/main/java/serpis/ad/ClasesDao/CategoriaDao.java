package serpis.ad.ClasesDao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import serpis.ad.Categoria;

public class CategoriaDao {
	
	public static EntityManagerFactory entityManagerFactory;
	public static EntityManager entityManager;
	public static  Scanner sc = new Scanner(System.in);
	
	
	public static void insert() {
		
		Categoria categoria = new Categoria();
		System.out.println("Indique el nombre de la categoria");
		String nombre = sc.nextLine();
		categoria.setNombre(nombre);
		entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad.ghibernate");
		entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(categoria);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();		
	
	}
	
	
	public static void update() {
		entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad");
		
	}
	
	
	public static void delete() {
		
	}
	
	
	public static void show() {
		entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad");
		entityManager=entityManagerFactory.createEntityManager();
		List<Categoria>categorias= entityManager.createQuery("from categoria order by id", Categoria.class).getResultList();
		for (Categoria categoria : categorias)
			System.out.printf("%d %s %n", categoria.getId(), categoria.getNombre());	
	    entityManager.close();
}

}
