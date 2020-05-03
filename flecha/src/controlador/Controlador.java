package controlador;

import modelo.Flecha;
import vista.Lienzo;

import java.awt.Point;

public class Controlador {
	Flecha modelo;
	Lienzo vista;

	public Controlador(Flecha _modelo, Lienzo _vista) {
		modelo = _modelo;
		vista = _vista;
	}

	public void calcularFlecha() {
		modelo = new Flecha(new Point(300, 400), new Point(100, 100));
		modelo.calcularFlecha();
		notificar();
	}

	public void notificar() {
		vista.actualizar(modelo);
	}

	public void configurar() {
		vista.setControlador(this);
	}
}
