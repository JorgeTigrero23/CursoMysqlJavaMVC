package Negocio;

import java.sql.SQLException;
import java.util.ArrayList;

import DB.ProveedorBD;

public class Proveedor {

	//definir los tipos de datos
	private int codigo;
	private String razon_social;
	private String ruc;
	private String direccion;
	private String telefono;
	
	//creo los getters and setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getRazon_social() {
		return razon_social;
	}
	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/** -- Instanciandos nuestros metodos en el paquete DB
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException **/
	/** -- Este metodo permite instanciar la clase ProveedorBD y llamar al metodo grabar para hacer uso de el -- **/
	public void grabar() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		ProveedorBD proveedor_db = new ProveedorBD(this);
		proveedor_db.Grabar();
	   
	}
	
	
	/** -- Este metodo permite instanciar la clase ProveedorBD y llamar al metodo grabar para hacer uso de el -- **/
	public void actualizar() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		ProveedorBD proveedor_db = new ProveedorBD(this);
		proveedor_db.Modificar();
	   
	}
	

	/** -- Este metodo permite instanciar la clase ProveedorBD y llamar al metodo borrar para hacer uso de el -- **/
	public void borrar () throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
	
		ProveedorBD proveedor_db = new ProveedorBD(this);
		proveedor_db.Borrar();
		
	}
	
    /** -- Este metodo lee todo los datos de la tabla proveedor --**/
	public ArrayList leerDatos() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		ProveedorBD proveedor_db = new ProveedorBD(this);
		return proveedor_db.leerTodos();
		
	}
	
	/** -- Este metodo retorna un conjuto de datos de la clase proveedor --**/
	public Proveedor lee() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		ProveedorBD proveedor_db = new ProveedorBD(this);
		return proveedor_db.Leer();
	}
	
	/** -- Este metodo busca un proveedor indicando el ruc y porque campo se va a filtrar --**/
	public ArrayList leerEspecifico(String filtro, String campo) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		ProveedorBD proveedor_db = new ProveedorBD(this);
		return proveedor_db.leer(filtro,campo);
	}
	
}
