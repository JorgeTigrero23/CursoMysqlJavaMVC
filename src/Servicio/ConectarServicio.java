package Servicio;

public class ConectarServicio {

	private Conexion cdb;
	private static ConectarServicio instancia;
	
	//Agregamos el constructor
	public ConectarServicio() {
	  
	}
	
	//creamos un metodo estatico
	public static synchronized ConectarServicio getInstancias(){
		if(instancia==null){   //pregunta si la instancia esta creada y si es null entonces la crea
			instancia = new ConectarServicio();  //crea la instancia
		}
		return instancia;     //retorna el valor de la instancia
		
	}
	
	public Conexion getConexionDb() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		if(cdb == null){
			String nombreClase = System.getProperty("databaseclass");   //lee el archivo configurardb.txt y trabajara con la variable databaseclass
			cdb = (Conexion) Class.forName(nombreClase).newInstance();  //creamos una instancia de la clase databaseclass, instancia linea por linea y luego la envia a la classe Conexion_mySql y despues a Conexion.
		}
		
		return cdb;
	}
	
}
