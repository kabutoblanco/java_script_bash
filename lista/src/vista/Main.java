package vista;

import javax.swing.JFrame;

public class Main {
	public static void main (String[] args) {
		JFrame ventana = new JFrame("Vista");
		Lienzo lienzo = new Lienzo();
		ventana.add(lienzo);
		ventana.setSize(300, 300);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}
}
