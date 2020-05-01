package controlador;

import java.awt.Point;
import modelo.Flecha;
import vista.Lienzo;

public class Controlador {
	Flecha modelo;
	Lienzo vista;

	public Controlador(Flecha _modelo, Lienzo _vista) {
		modelo = _modelo;
		vista = _vista;
	}

	public void calcularFlecha(int[] _p1, int[] _p2) {
		Point p1 = new Point(_p1[0], _p1[1]);
		Point p2 = new Point(_p2[0], _p2[1]);
		modelo = new Flecha(p1, p2);
		modelo.calcularFlecha();
		notificar();
	}

	public void notificar() {
		vista.actualizar(modelo);
	}
}
