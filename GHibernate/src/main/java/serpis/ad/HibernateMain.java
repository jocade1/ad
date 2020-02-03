package serpis.ad;
import java.util.*;
import java.time.LocalDateTime;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import serpis.ad.ClasesDao.CategoriaDao;
import serpis.ad.ClasesDao.ClienteDao;




public class HibernateMain {
	public static EntityManagerFactory entityManagerFactory;
	public static EntityManager entityManager; 

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("======Menu=====");
		System.out.println("1.Categoria");
		System.out.println("2.Producto");
		System.out.println("3.Cliente");
		System.out.println("4.Pedido");
		System.out.println("5.Linea");
		System.out.println("0.Salida");

		
		
		try {
			int num = sc.nextInt();
			
			switch(num) {
			
			case 1:
				System.out.println("Categoria");
				System.out.println("1.Insertar");
				System.out.println("2.Modificar");
				System.out.println("3.Borrar");
				System.out.println("4.Mostrar");
				System.out.println("0.Salir");
				int seleccion=sc.nextInt();
				
				switch(seleccion) {
				case 1 :
					CategoriaDao.insert();
					break;
				
				case 2: 
				
					break;
					
				
				case 3: 
						
					break;
					
				case 4:
					CategoriaDao.show();
					break;
					
				case 0:	
					System.exit(0);
					break;
				}
				
			case 2:
				System.out.println("Producto");
				System.out.println("1.Insertar");
				System.out.println("2.Modificar");
				System.out.println("3.Borrar");
				System.out.println("4.Mostrar");
				System.out.println("0.Salir");
				int seleccion1=sc.nextInt();
				
				switch(seleccion1) {
				case 1 :
					CategoriaDao.insert();
					break;
				
				case 2: 
				
					break;
					
				
				case 3: 
						
					break;
					
				case 4:
					CategoriaDao.show();
					break;
					
				case 0:	
					System.exit(0);
					break;
				}
				
			

			
			}
		

			
			}catch(Exception e) {
				System.out.println("Nothing to do");
			}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

	
	
	
	public static void nuevoPedido() {
		Scanner sc = new Scanner(System.in);
		Categoria categoria=new Categoria();
		System.out.println("Dime el nombre de la categoria:");
		String nombre=sc.nextLine();
		categoria.setNombre(nombre);
		entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad");
		entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(categoria);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	
	}
	
	
	
	

}
