package Principal;

import java.io.FileInputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

import Interfaces.Frm_proveedores;
import Servicio.ConectarServicio;
import Servicio.Conexion;

public class Main {

	//Metodo Estatico
	public static void main(String[] args){
		
		 //Para leer archivos vinarios, txt, etc se utiliza la calse FileInputStream
        try{
		FileInputStream fis = new FileInputStream("configurardb.txt"); //Lee el archivo configurarDB.txt
        Properties proper = new Properties(System.getProperties()); 
        proper.load(fis); //cargamos el archivo y leee las propiedades
        System.setProperties(proper);
        
        if(System.getProperty("mostrarpropierties").compareTo("si")==0){
            System.getProperties().list(System.out); //leer los archivos mediante una lista y la imprime
        }
		}catch (java.io.FileNotFoundException e){
			JOptionPane.showConfirmDialog(null,"No se encuentra el archivo de configuracion"+ e);
			System.exit(-1);
		//manejador de error si los parametros estan mal o al momento de imprimir se produce este error	
		}catch(java.io.IOException w){
		    JOptionPane.showMessageDialog(null,"Ocurrio un error de I/O"+w);
		    System.exit(-1);
		}
		
		
		try{
			Conexion cdb = ConectarServicio.getInstancias().getConexionDb();
			//manejador de erro si no esncuentra la clase
		}catch(java.lang.ClassNotFoundException e){
			JOptionPane.showMessageDialog(null,"Ocurrio la exepcion" + e.toString());
			JOptionPane.showMessageDialog(null,"Es probable que no se pueda encontrar la clase del conector jdbc" + System.getProperty("driver")+ "Agregala en su classpath con la opcion -cp");
			System.exit(-1);
		}catch(java.lang.InstantiationException ex){
			JOptionPane.showMessageDialog(null,"Ocurrio un error de instanciamiento" + ex.toString());
			System.exit(-1);
		}catch(java.lang.IllegalAccessException ex){
			JOptionPane.showMessageDialog(null,"Ocurrio un error de acceso ilegal" + ex.toString());
			System.exit(-1);
		}
		
		try{
			Frm_proveedores frmProveedor = new Frm_proveedores();
			frmProveedor.setVisible(true);
		}catch(Exception e){
			
		}
	}
}
