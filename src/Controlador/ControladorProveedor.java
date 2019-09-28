package Controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import Negocio.Proveedor;

public class ControladorProveedor {
  
	public ArrayList buscarProveedor(String filtro, String campo) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		Proveedor prov;
		prov = new Proveedor();
		
		return prov.leerEspecifico(filtro,campo);
	}
	
	//Metodo para agregar un nuevo proveedor
	public void agregarProveedor(String razon_social, String ruc, String direccion, String telefono ) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Proveedor prov;
		prov = new Proveedor();
		prov.grabar(); // llamamos al metodo grabar de la clase Proveedor
		
	}
	
	//Metodo para modificar un proveedor
	public void modificarProveedor(String razon_social, String ruc, String direccion, String telefono) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Proveedor prov;
		prov = new Proveedor();
		prov.actualizar(); // llamamos al metodo actualizar de la clase Proveedor
	}
	
	//Metodo para borrar un proveedor
	public void eliminarProveedor(String ruc) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Proveedor prov;
		prov = new Proveedor();
		prov.borrar(); // llamamos al metodo borrar de la clase Proveedor
	}
	
	//Metodo para recargar proveedores
	public ArrayList recargarProveedor() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Proveedor prov;
		prov = new Proveedor();
		prov.lee();
		
		return null;
	}
}
