package serpis.ad.ClasesDao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.math3.geometry.euclidean.threed.Line;

import serpis.ad.LineaPedido;

public class LineaPedidoDao {
	public static EntityManagerFactory entityManagerFactory;
	public static EntityManager entityManager;
	public static Scanner sc = new Scanner(System.in);
	
	
	public static void insert() {
		entityManagerFactory=Persistence.createEntityManagerFactory("serpis.ad.ghibernate");
		entityManager=entityManagerFactory.createEntityManager();	
		LineaPedido lineaPedido = new LineaPedido();
		lineaPedido.se
	
	
	
	}

}
