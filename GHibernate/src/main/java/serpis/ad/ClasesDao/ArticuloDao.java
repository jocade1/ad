package serpis.ad.ClasesDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import serpis.ad.Articulo;
import serpis.ad.Categoria;


public class ArticuloDao {





	public static EntityManagerFactory entityManagerFactory;
	public static EntityManager entityManager;
	
	public static void insert() {
		Scanner tcl=new Scanner(System.in);
		entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad.ghibernate");
		entityManager=entityManagerFactory.createEntityManager();
		Articulo articulo=new Articulo();
		
		System.out.println("Dime el nombre del Producto:");
		String nombre=tcl.nextLine();
		articulo.setNombre(nombre);
		
		System.out.println("Dime el precio");
		float precio=tcl.nextFloat();
		articulo.setPrecio(precio);
		System.out.println("Dime categoria");
		Categoria categoria=entityManager.find(Categoria.class,tcl.nextLong());
		articulo.setCategoria(categoria);
		entityManager.getTransaction().begin();
		entityManager.persist(articulo);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
	}
	

	
	
	
	public static void show() {
		entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad.proyectofinal");
		entityManager=entityManagerFactory.createEntityManager();
		List<Articulo>articulos= entityManager.createQuery("from producto order by id", Articulo.class).getResultList();
		System.out.println("ID "+" Nombre "+" Precio ");
		for (Articulo articulo : articulos)
			System.out.printf("%  %s  %f %n ", articulo.getId(), articulo.getNombre(),articulo.getPrecio());	
	     entityManager.close();
		
		
	}
}