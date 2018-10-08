package modelo.factorymethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;




public class MYSQLDBAdapter implements IDBAdapter {

	private static final String DB_PROPERTIES = "BD_INF/DBMySQL.properties";
	
	 private static final String DB_NAME_PROP =	 		"dbname";
	 private static final String DB_HOST_PROP =	 		"host";
	 private static final String DB_PASSWORD_PROP = 	"password";
	 private static final String DB_PORT_PROP = 		"port";
	 private static final String DB_USER_PROP = 		"user";
	
	
	
	
	
	static {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		try {	
				new com.mysql.cj.jdbc.Driver();
				JOptionPane.showMessageDialog(null, "registro exitoso");
		
		} catch (Exception e) {
			e.printStackTrace();
			
			
		}
	}
		
		@Override
		public Connection getConnection() throws SQLException {
			try {
				String connectionString = createConnectionString();
				Connection connection = DriverManager.getConnection(connectionString,"root","123");
			//	System.out.println("conectado a"+DB_NAME_PROP);
				System.out.println("Connection class ==> "+ connection.getClass().getName());
				return connection;
			} catch (SQLDataException e) {
				JOptionPane.showMessageDialog( null, "error de regsitro de drive",null, 0);
				return null;
				
			}
			
		}

		private String createConnectionString() {
			
			Properties prop = PropertiesUtil.loadProperty(DB_PROPERTIES); 
			String host = prop.getProperty(DB_HOST_PROP);
			
		
			String port = prop.getProperty(DB_PORT_PROP);
			
			String db = prop.getProperty(DB_NAME_PROP);
			
			String user = prop.getProperty(DB_USER_PROP); 
			
			String password = prop.getProperty(DB_PASSWORD_PROP);
		//	+"?useTimezone=true&serverTimezone=UTC"
			String connectionString = "jdbc:mysql://" + host + ":" + port + "/" + db +" ?useTimezone=true&serverTimezone=UTC"+" &user="+ user + "&password=" + password;
			
			System.out.println("ConnectionString ==> " + connectionString);
			return connectionString;
		}
		
	





	

}
