package modelo;

import java.awt.Point;

public class Flecha {
	private Point lineaP1, lineaP2;
	private Point arista1P, arista2P;

	private static final double DELTA = Math.PI / 4;
	private static final double C = 50;

	public Flecha() {}

	public Flecha(Point _lineaP1, Point _lineaP2) {
		lineaP1 = _lineaP1;
		lineaP2 = _lineaP2;
		arista1P = new Point();
		arista2P = new Point();
	}

	public void calcularFlecha() {
		double[] ajustadas = trasladarFigura(lineaP2.x, lineaP2.y);
		double[] cateto = calcularCatetos(ajustadas[0], ajustadas[1]);
		int[] factor = calcularFactor(ajustadas[0], ajustadas[1]);
		double xp = lineaP1.x + (factor[0] * cateto[0]);
		double yp = lineaP1.y + (factor[1] * cateto[1]);		
		ajustadas = trasladarFigura(xp, yp);
		arista1P = rotarHorario(ajustadas[0], ajustadas[1]);
		arista2P = rotarAntihorario(ajustadas[0], ajustadas[1]);
	}

	//Trasladar la figura
	private double[] trasladarFigura(double x, double y) {
		double xp = x - lineaP1.x;
		double yp = lineaP1.y - y;
		double[] coordenadas = {xp, yp};
		return coordenadas;
	}

	//Calcular longitud de catetos
	private double[] calcularCatetos(double x, double y) {
		double angulo = Math.atan(y / x);
		double a = Math.sqrt(Math.pow(C, 2) / (1 + Math.pow(Math.tan(angulo), 2)));
		double b = Math.sqrt(Math.pow(C, 2) - Math.pow(a, 2));
		double[] ab = {a, b};
		return ab;
	}

	//Calcular factor de aristas
	private int[] calcularFactor(double x, double y) {
		double fx = x / Math.abs(x);
		double fy = y / (Math.abs(y) * -1);
		int[] factor = {(int) fx, (int) fy};
		return factor;
	}

	//Calcular arista horario
	private Point rotarHorario(double x, double y) {
		double xp = x * Math.cos(DELTA) + y * Math.sin(DELTA);
		double yp = (-1 * x * Math.sin(DELTA)) + y * Math.cos(DELTA);
		xp = lineaP1.x + xp;
		yp = lineaP1.y - yp;
		return new Point((int) xp, (int) yp);
	}

	//Calcular arista antihorario
	private Point rotarAntihorario(double x, double y) {
		double xp = x * Math.cos(DELTA) + (-1 * y * Math.sin(DELTA));
		double yp = x * Math.sin(DELTA) + y * Math.cos(DELTA);
		xp = lineaP1.x + xp;
		yp = lineaP1.y - yp;
		return new Point((int) xp, (int) yp);
	}

	/**
	 * @return the lineaP1
	 */
	public Point getLineaP1() {
		return lineaP1;
	}

	/**
	 * @return the lineaP2
	 */
	public Point getLineaP2() {
		return lineaP2;
	}

	/**
	 * @return the arista1P
	 */
	public Point getArista1P() {
		return arista1P;
	}

	/**
	 * @return the arista2P
	 */
	public Point getArista2P() {
		return arista2P;
	}
}
