package Servicio;
import java.sql.*;

public class Conexion {
  
	public Connection conexion = null;
	public Statement us_st = null;
	public DatabaseMetaData dbmd;
	public String s_conexion;
	public ResultSet resultado = null;
	public String un_sql = null;
	
	protected String jdbc;
	protected String driver;
	protected String host;
	protected String database;
	protected String username;
	protected String password;
	
	public Conexion() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		jdbc = System.getProperty("jdbc");
		driver = System.getProperty("driver");
		host = System.getProperty("host");
		database = System.getProperty("database");
		username = System.getProperty("username");
		password = System.getProperty("password");
	
		//llamar al metodo Iniciardb
		
		Iniciardb();
		
	}
	
	//Metodo Inicciardb
	public void Iniciardb() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		s_conexion = jdbc + host + "/" + database;
		Class.forName(driver).newInstance();
		conexion = DriverManager.getConnection(s_conexion, username, password);
		dbmd = conexion.getMetaData();
		us_st = conexion.createStatement();
	}
}
