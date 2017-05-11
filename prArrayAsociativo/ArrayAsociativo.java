package prArrayAsociativo;

import java.util.NoSuchElementException;

public class ArrayAsociativo {
	//Clases internas
	private class Nodo{
		private String clave;
		private String valor;
		private Nodo sig; //siguiente nodo
		
		public Nodo(String c, String v, Nodo s){
			clave = c;
			valor = v;
			sig = s;
		}
	}
	
	//Variables de instancia
	private Nodo primero;
	
	
	//Constructores
	public ArrayAsociativo(){
		primero = null;
	}
	
	public ArrayAsociativo(String[] claves, String[] valores){
		this();
		if (claves.length > 0){
			primero = new Nodo(claves[0], valores[0],null);
			for (int i = 1; i< claves.length; i++){
				Nodo nuevo = new Nodo(claves[i], valores[i],primero);
				primero = nuevo;
			}
		}
	}
	
	//Métodos de instancia
	public int size(){
		int i = 0;
		Nodo aux = primero;
		while(aux.sig != null){
			i++;
		aux = aux.sig;
		}
		return i;
	}
	public String get(String clave){

		Nodo aux = primero;
		while(aux.clave != clave && aux.clave != null){
		aux = aux.sig;
		}
		if(aux.clave == null){
			throw new NoSuchElementException("no elemento");
		}
		return aux.valor;
	}
}
