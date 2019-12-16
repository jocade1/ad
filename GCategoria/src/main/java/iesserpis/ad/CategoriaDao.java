package iesserpis.ad;

import java.sql.PreparedStatement;

public class CategoriaDao {
	/**
	 * 
	 * @param id
	 * @return
	 */
	public static Categoria load(Object id) {
		return null;
		
		
	}
	
	public static int save(Categoria categoria) {
	
		if (categoria.getId()==0)
			insert(categoria);
		else
			update(categoria);
	}
	
	private static String insertSql = "insert into categoria (nombre) values(?)";
	private static int insert(Categoria categoria) {
		try(PreparedStatement preparedStatement = App.GetInstance().getConnection().prepareStatement(insertSql)) {
			preparedStatement.setString(1,categoria.getNombre());
			return preparedStatement.executeUpdate();
		}
	}
	
	private static int update(Categoria categoria) {
		return 0;
	}

}
