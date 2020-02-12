package serpis.ad;
import java.util.*;
import java.time.LocalDateTime;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import serpis.ad.ClasesDao.ArticuloDao;
import serpis.ad.ClasesDao.CategoriaDao;
import serpis.ad.ClasesDao.ClienteDao;
import serpis.ad.ClasesDao.PedidoDao;




public class HibernateMain {
	public static EntityManagerFactory entityManagerFactory;
	public static EntityManager entityManager; 

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("======Menu=====");
		System.out.println("1.Categoria");
		System.out.println("2.Articulo");
		System.out.println("3.Cliente");
		System.out.println("4.Pedido");
		System.out.println("0.Salida");

		
		
		try {
			int num = sc.nextInt();
			
			switch(num) {
			
			case 1:
				System.out.println("Categoria");
				System.out.println("1.Insertar");
				System.out.println("2.Modificar");
				System.out.println("3.Mostrar");
				System.out.println("0.Salir");
				int seleccion=sc.nextInt();
				
				switch(seleccion) {
				case 1 :
					CategoriaDao.insert();
					break;
				
				case 2: 
					CategoriaDao.update();
					break;
					
				
				case 3: 
					CategoriaDao.show();
					break;
					
		
					
				case 0:	
					System.exit(0);
					break;
				}
				break;
				
			case 2:
				System.out.println("Articulo");
				System.out.println("1.Insertar");
				System.out.println("2.Modificar");
				System.out.println("3.Mostrar");
				System.out.println("0.Salir");
				int seleccion1 = sc.nextInt();
				
				switch(seleccion1) {
				case 1 :
					ArticuloDao.insert();
					break;
				
				case 2: 
					//ArticuloDao.update();
					
					break;
					
				
				case 3: 
					ArticuloDao.show();
					break;
					
				case 0:	
					System.exit(0);
					break;
				}
				break;
				
			case 3:
				System.out.println("Cliente");
				System.out.println("1.Insertar");
				System.out.println("2.Modificar");
				System.out.println("3.Borrar");
				System.out.println("4.Mostrar");
				System.out.println("0.Salir");
				int seleccion2=sc.nextInt();
				
				switch(seleccion2) {
				case 1 :
					ClienteDao.insert();
					break;
				
				case 2:
					ClienteDao.update();
					break;
					
				
				case 3:
					ClienteDao.delete();
					break;
					
				case 4:
					ClienteDao.show();
					break;
					
				case 0:	
					System.exit(0);
					break;
					
				}
				break;
				
			case 4:
				System.out.println("Pedido");
				System.out.println("1.Insertar");
				System.out.println("2.Modificar");
				System.out.println("3.Borrar");
				System.out.println("4.Mostrar");
				System.out.println("0.Salir");
				int seleccion3=sc.nextInt();
				
				switch(seleccion3) {
				case 1 :
					PedidoDao.insert();
					break;
				
				case 2: 
					PedidoDao.update();
					break;
					
				
				case 3: 
					PedidoDao.delete();
					break;
					
				case 4:
					PedidoDao.show();
					break;
					
				case 0:	
					System.exit(0);
					break;
				}
				
				break;
			
			}
		

			
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

	
	
	
//	public static void nuevoPedido() {
//		Scanner sc = new Scanner(System.in);
//		Categoria categoria=new Categoria();
//		System.out.println("Dime el nombre de la categoria:");
//		String nombre=sc.nextLine();
//		categoria.setNombre(nombre);
//		entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad");
//		entityManager=entityManagerFactory.createEntityManager();
//		entityManager.getTransaction().begin();
//		entityManager.persist(categoria);
//		entityManager.getTransaction().commit();
//		entityManager.close();
//		entityManagerFactory.close();
	
}
	
	
	
	


