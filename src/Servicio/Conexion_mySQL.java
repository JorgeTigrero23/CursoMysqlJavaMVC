package Servicio;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion_mySQL extends Conexion {  //con el extends Conexion heredamos de la clase Conexion

	private String opciones;
	
	public Conexion_mySQL() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
		
		opciones = System.clearProperty("options");
		
		//llamamos al metodo Iniciardb de la clase Conexion
		Iniciardb();
	}
	
public void Iniciardb() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		s_conexion= jdbc + host + "/" + database + "?";
		Class.forName(driver).newInstance();
		conexion = DriverManager.getConnection(s_conexion, username, password);
		dbmd = conexion.getMetaData();
		us_st = conexion.createStatement();
	}

}
