package vista;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import modelo.Flecha;

public class Lienzo extends JPanel {
	Flecha modelo;

	public void actualizar(Flecha _modelo) {
		modelo = _modelo;
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (modelo != null) {
			g.drawLine(modelo.getLineaP1().x, modelo.getLineaP1().y, modelo.getLineaP2().x, modelo.getLineaP2().y);
			g.setColor(Color.red);
			g.drawLine(modelo.getArista1P1().x, modelo.getArista1P1().y, modelo.getArista1P2().x, modelo.getArista1P2().y);
			g.drawLine(modelo.getArista2P1().x, modelo.getArista2P1().y, modelo.getArista2P2().x, modelo.getArista2P2().y);
		}
	}
}
