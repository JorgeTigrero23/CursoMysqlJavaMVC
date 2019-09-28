package DB;

import java.sql.SQLException;
import java.util.ArrayList;

import Negocio.Proveedor;
import Servicio.ConectarServicio;
import Servicio.Conexion;

public class ProveedorBD {
	
	//creamos un obleto de la capa negocio
	private Proveedor proveedor;   

	//creamos un constructor de la clase
	public ProveedorBD(Proveedor proveedor) {  //le insertamos como parametros
		this.proveedor= proveedor;
	}
	
	/** --- Metodo Grabar Datos --- **/
	public void Grabar() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Conexion cdb = ConectarServicio.getInstancias().getConexionDb();
		
		//realizamos la consulta sql a traves de una cadena string
		cdb.un_sql = "SELECT ruc FROM proveedor WHERE ruc='" + proveedor.getRuc() +"'";
		
		//capturamos el resultado en una varibale resultado, es decir la ejecutamos y recivimos los datos
		cdb.resultado = cdb.us_st.executeQuery(cdb.un_sql);
		
		//validamos el resultado de la consulta anterior 
		//esta validacion se realizo para verificar si el proveedor existe y si existe nos da null y por ende los valores 
		//del proveedor se acualizan caso contrario entran al else que es donde ingresa al nuevo porveedor con sus valores
		if (cdb.resultado != null){
			if(cdb.resultado.next()){
				cdb.un_sql ="UPDATE proveedor SET razon='"+proveedor.getRazon_social()+"', direccion='"+proveedor.getDireccion()+"', telefono='"+proveedor.getTelefono()+"' WHERE ruc='"+proveedor.getRuc()+"'";
			    cdb.us_st.executeUpdate(cdb.un_sql);  //debido a que es una actualizacion se coloca esta sentencia sql executeUpdate
			}else{
				cdb.un_sql ="INSERT INTO proveedor VALUES('"+proveedor.getRuc()+"','"+proveedor.getRazon_social()+"','"+proveedor.getDireccion()+"','"+proveedor.getTelefono()+"')";
				cdb.us_st.executeUpdate(cdb.un_sql);  // debido a que ingresamos se ejecuta esta sentencia sql
			}	
		}else{
			cdb.un_sql ="INSERT INTO proveedor VALUES('"+proveedor.getRuc()+"','"+proveedor.getRazon_social()+"','"+proveedor.getDireccion()+"','"+proveedor.getTelefono()+"')";
			cdb.us_st.executeUpdate(cdb.un_sql);  // debido a que ingresamos se ejecuta esta sentencia sql
		}
	}
	
	public void Modificar() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		Conexion cdb = ConectarServicio.getInstancias().getConexionDb();
		
		cdb.un_sql ="SELECT RUC FROM proveedor WHERE ruc ='"+proveedor.getRuc()+"'";
		cdb.resultado = cdb.us_st.executeQuery(cdb.un_sql);
		
		if(cdb.resultado !=null){
			if(cdb.resultado.next()){
				cdb.un_sql ="UPDATE proveedor SET razon'"+proveedor.getRazon_social()+"', direccion='"+proveedor.getDireccion()+"', telefono='"+proveedor.getTelefono()+"' WHERE ruc='"+proveedor.getRuc()+"'";
				cdb.us_st.executeUpdate(cdb.un_sql);
			}else{
				/* -- Generamos nuestro propio error, luego este se activa por el catch quien lo lanza nuevamente --  */
				throw new Error("Registro"+proveedor.getRuc()+ "No se encuentra en la tabla proveedor Ubicacion" +this.getClass().getName());
			}
		}else{
			/* -- Generamos nuestro propio error, luego este se activa por el catch quien lo lanza nuevamente  -- */
			throw new Error("Modificación a registro"+proveedor.getRuc()+"Ha devuelto un recordSet null Ubicacion" + this.getClass().getName());
		}
		
	}
	
	
	/** --- Metodo Leer Datos --- 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SQLException **/
      public Proveedor Leer() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
    	  Conexion cdb = ConectarServicio.getInstancias().getConexionDb();
    	  
    	  cdb.un_sql = "SELECT ruc FROM proveedor WHERE ruc='"+proveedor.getRuc()+"'";
    	  cdb.resultado = cdb.us_st.executeQuery(cdb.un_sql);
    	  
    	   if(cdb.resultado!=null){
    		   if(cdb.resultado.next()){
    			   proveedor.setRazon_social(cdb.resultado.getString("razon"));
    			   proveedor.setDireccion(cdb.resultado.getString("direccion"));
    			   proveedor.setTelefono(cdb.resultado.getString("telefono"));
    		   }else{
    			    /** GENEREAR NUESTRO PROPIO ERROR, LUEGO ESTE SE ACTIVA POR EL CATH QUIEN LO LANZA NUEVAMENTE **/
    			    throw new Error ("Registro "+proveedor.getRuc()+ " No se encuentra en la tabla proveedor Ubicación= "+ this.getClass().getName());
    		   }
    	   }else{
    		   /** GENEREAR NUESTRO PROPIO ERROR, LUEGO ESTE SE ACTIVA POR EL CATH QUIEN LO LANZA NUEVAMENTE **/
			    throw new Error ("Consulta a Registro "+proveedor.getRuc()+ " No se encuentra en la tabla proveedor Ubicación= "+ this.getClass().getName());
    	   }
		return proveedor;
      }
      
      
      /** --- Metodo Borrar Datos --- 
     * @throws ClassNotFoundException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @throws SQLException **/
      public void Borrar () throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
    	  Conexion cdb = ConectarServicio.getInstancias().getConexionDb();
    	  
    	  cdb.un_sql = "DELETE FROM Proveedor WHERE ruc='" +proveedor.getRuc()+ "'";
    	  cdb.us_st.executeQuery(cdb.un_sql);
      }
      
      
      /** -- Creando el metodo leer y ordenar por proveedor -- 
     * @throws ClassNotFoundException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @throws SQLException **/
      public ArrayList leerTodos() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
    	  ArrayList r;
    	  Proveedor prove;
    	  
    	  Conexion cdb = ConectarServicio.getInstancias().getConexionDb();
		  //creamos una consulta
    	  cdb.un_sql="SELECT * FROM proveedor ORDER BY razon";
    	  cdb.resultado = cdb.us_st.executeQuery(cdb.un_sql);
    	  
    	  
    	  return null;
    	  
      }
      
      
      public ArrayList leer(String filtro, String campo ) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
    	  ArrayList r;
    	  Proveedor prove;
    	  
    	  Conexion cdb = ConectarServicio.getInstancias().getConexionDb();
		  //creamos una consulta
    	  cdb.un_sql="SELECT * FROM proveedor WHERE" +campo+ "LIKE '%"+filtro+"%' ODER BY razon";
    	  cdb.resultado = cdb.us_st.executeQuery(cdb.un_sql);
    	  
    	  
    	  return null;
    	  
      }
      
}
