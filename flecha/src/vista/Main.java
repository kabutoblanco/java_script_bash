package vista;

import javax.swing.JFrame;
import modelo.Flecha;
import controlador.Controlador;

public class Main {
	public static void main (String[] args) {
		Flecha modelo = new Flecha();
		Lienzo vista = new Lienzo();
		Controlador controlador = new Controlador(modelo, vista);
		controlador.configurar();
		controlador.calcularFlecha();
		JFrame ventana = new JFrame("Vista");
		ventana.add(vista);
		ventana.setSize(600, 600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}
}
