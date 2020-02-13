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
import serpis.ad.Cliente;
import serpis.ad.Pedido;


public class ArticuloDao {





	public static EntityManagerFactory entityManagerFactory;
	public static EntityManager entityManager;
	public static Scanner sc=new Scanner(System.in);
	public static Articulo articulo;
	public static Categoria categoria;
	
	
	public static void insert() {
		
		entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad.ghibernate");
		entityManager=entityManagerFactory.createEntityManager();
		articulo=new Articulo();
		
		System.out.println("Dime el nombre del Producto:");
		String nombre=sc.nextLine();
		articulo.setNombre(nombre);
		
		System.out.println("Dime el precio");
		float precio=sc.nextFloat();
		articulo.setPrecio(precio);
		System.out.println("Dime categoria");
		Categoria categoria=entityManager.find(Categoria.class,sc.nextLong());
		articulo.setCategoria(categoria);
		entityManager.getTransaction().begin();
		entityManager.persist(articulo);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
	}
	
	
	public static void update() {
		System.out.println("introduce id a cambiar");
		Long id_producto =sc.nextLong();
		articulo =entityManager.find(Articulo.class,id_producto);
		entityManager.getTransaction().begin();
		System.out.println("Introduce el nombre");
		articulo.setNombre(sc.nextLine());
		System.out.println("Introduce el nuevo precio");
		articulo.setPrecio(sc.nextFloat());
		System.out.println("Introduce el id de categoria");
		categoria=entityManager.find(Categoria.class,sc.hasNextLong());
		articulo.setCategoria(categoria);
		
		entityManager.getTransaction().begin();
		entityManager.persist(articulo);
		entityManager.getTransaction().commit();
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