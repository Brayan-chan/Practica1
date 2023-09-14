import javax.swing.JOptionPane;

/**
* Computadora.java
*
* @author H�ctor Manuel Quej Cosgaya
* @author Jos� Aguilar Canepa
* 
* @created 04/11/12 11:08 AM
*
* Esta clase es tu examen diagn�stico para entrar a Lenguaje de Programaci�n II
* Intencionalmente, los autores han introducido una serie de errores en esta clase. 10 de ellos, en concreto.
* Tu trabajo es encontrarlos, y corregirlos. �Utiliza todo lo que aprendiste en Lenguaje de Programaci�n I!
* Las �nicas reglas que tienes que seguir son:
*     1.- NO puedes borrar ning�n m�todo. La clase empieza con un constructor, 8 m�todos y el m�todo main: as� debe finalizar.
*     2.- NO puedes borrar ninguna variable,.
*     3.- NO puedes modificar el m�todo main. Palabra de desarrollador de software que no hay nada malo con �l.
* Salvo esas reglas, puedes hacer las modificaciones que creas pertinentes. Sin embargo, solamente 10 cambios son necesarios para que la clase funcione de nuevo
* Que no te enga�e el compilador, ni te desesperes. �Unicamente hay 10 errores!
*
* �Buena suerte, y bienvenido a Lenguaje de Programaci�n II!
*/

public class Computadora{
	
	int discoDuro;
	float velocidadProcesador;
	Computadora peer;
	String sistemaOperativo;
	String nombre;
	String[] memoria = new String[10];

	public Computadora(String nombreEquipo){
		discoDuro = 640;
		velocidadProcesador = 3.1f;
		sistemaOperativo = "Microsoft Windows 7";
		nombre = nombreEquipo;
				
	}
	
	public void encender(){
		JOptionPane.showMessageDialog(null, nombre + ": Iniciando Windows...");
		memoria[0] = sistemaOperativo;		
		JOptionPane.showMessageDialog(null, nombre + ": Bienvenido");
	}
	
	public boolean ejecutar(String programa, int posicion){
		if(posicion != 0){
			memoria[posicion] = programa;
			JOptionPane.showMessageDialog(null, nombre + ": Ejecutando el programa " + programa);
			}
			return true;
		}
	
	public void recibirDatos(String mensaje){
		JOptionPane.showMessageDialog(null, peer.nombre + " dice: " + mensaje);
	}
	
	public void enviarDatos(){
		peer.recibirDatos(JOptionPane.showInputDialog("Escribe el dato a enviar"));
		
	}
	
	public void conectar(Computadora c){
		this.peer = c;
		c.peer = this;
		JOptionPane.showMessageDialog(null, nombre + ": Conectado a " + peer.nombre);
	}
	
	public void desconectar(){
		JOptionPane.showMessageDialog(null, nombre + ": Desconectado de " + peer.nombre);
		peer.peer = null;
		this.peer = null;
	}
	
	public void apagar() {
		JOptionPane.showMessageDialog(null, "Cerrando sesi�n...");
		for (int i = 0; i < 10; i++) {
			memoria[i] = null;
		}
		JOptionPane.showMessageDialog(null, nombre + ": Windows se est� cerrando");
		memoria[0] = null;
	}
	
	public void aumentarDiscoDuro(){
		discoDuro = 1000;
	}
	
	public static void main(String[] args){
		Computadora laptop = new Computadora("Laptop");
		laptop.encender();
		laptop.ejecutar("Windows Live Messenger", 1);
		
		Computadora tablet = new Computadora("Tablet");
		tablet.encender();
		tablet.ejecutar("Windows Live Messenger", 1);
		
		laptop.conectar(tablet);	
		laptop.enviarDatos();
		laptop.desconectar();
		
		tablet.apagar();
		laptop.apagar();
	}
}