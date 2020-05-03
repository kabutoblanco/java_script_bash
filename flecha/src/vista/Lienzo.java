package vista;

import java.awt.Graphics;
import javax.swing.JPanel;
import modelo.Flecha;
import controlador.Controlador;

public class Lienzo extends JPanel {
	Flecha modelo;
	Controlador controlador;

	public void actualizar(Flecha _modelo) {
		modelo = _modelo;
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (modelo != null) {
			g.drawLine(modelo.getLineaP1().x, modelo.getLineaP1().y, modelo.getLineaP2().x, modelo.getLineaP2().y);
			g.drawLine(modelo.getLineaP1().x, modelo.getLineaP1().y, modelo.getArista1P().x, modelo.getArista1P().y);
			g.drawLine(modelo.getLineaP1().x, modelo.getLineaP1().y, modelo.getArista2P().x, modelo.getArista2P().y);
		}
	}

	public void setControlador(Controlador _controlador) {
		controlador = _controlador;
	}
}
