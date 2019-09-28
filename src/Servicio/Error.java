package Servicio;

public class Error extends Exception{
    
	 private int codigo;
	 private String mensaje;
	 
	//creamos el constructor de las variables
	public Error(int codigo, String mensaje) {
		this.codigo = codigo;
		this.mensaje = mensaje;
	}
	
	//creamos los metodos de las variables
	public int codigo(){
		return codigo;
	}

	public String mensaje (){
        return mensaje;		
	}
	 
	 
}
