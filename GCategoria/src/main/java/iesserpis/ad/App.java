package iesserpis.ad;

import java.sql.Connection;

public class App {
	private static App instance = new App();
	
	public static App GetInstance() {
		return instance;
	}
	
	
	private App() {
		
	}

	
	private Connection connection;
	public Connection getConnection() {
		return connection;
				
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
