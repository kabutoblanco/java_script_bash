package vista;

import javax.swing.JFrame;
import modelo.Flecha;
import controlador.Controlador;

public class Main {
	public static void main (String[] args) {
		Flecha modelo = new Flecha();
		Lienzo vista = new Lienzo();
		Controlador controlador = new Controlador(modelo, vista);
		int[] p1 = {100, 100};
		int[] p2 = {300, 400};
		controlador.calcularFlecha(p1, p2);
		JFrame ventana = new JFrame("Vista");
		ventana.add(vista);
		ventana.setSize(300, 300);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}
}
