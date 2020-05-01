package modelo;

import java.awt.Point;

public class Flecha{
	private Point lineaP1, lineaP2;
	private Point arista1P1, arista1P2;
	private Point arista2P1, arista2P2;

	private static final double TETA = Math.PI / 11;
	private static final double C = 50;

	public Flecha(){}

	public Flecha(Point _lineaP1, Point _lineaP2) {
		lineaP1 = _lineaP1;
		lineaP2 = _lineaP2;
		arista1P1 = _lineaP1;
		arista1P2 = new Point();
		arista2P1 = _lineaP1;
		arista2P2 = new Point();
	}

	public void calcularFlecha() {
		int[] xy = getFactorArista(lineaP1, lineaP2);
		double[] ab = getCatetos(lineaP1, lineaP2);
		double x = lineaP1.x + (xy[0] * ab[0]);
		double y = lineaP1.y + (xy[1] * ab[1]);
		double[] xoyo = traslacionPlano(x, y);
		double xo = xoyo[0];
		double yo = xoyo[1];
		arista1P2 = getAristaAntihorario(xo, yo);
		arista2P2 = getAristaHorario(xo, yo);
	}

	public double[] getCatetos(Point p1, Point p2) {
		double[] xoyo = traslacionPlano(lineaP2.x, lineaP2.y);
		double xo = xoyo[0];
		double yo = xoyo[1];
		double angulo = Math.atan(yo / xo);
		double a = Math.sqrt(Math.pow(C, 2) / (1 + Math.pow(Math.tan(angulo), 2)));
		double b = Math.sqrt(Math.pow(C, 2) - Math.pow(a, 2));
		double[] ab = {a, b};
		return ab;
	}

	public int[] getFactorArista(Point p1, Point p2) {
		double[] xoyo = traslacionPlano(lineaP2.x, lineaP2.y);
		double xo = xoyo[0];
		double yo = xoyo[1];
		xo = xo / Math.abs(xo);
		yo = yo / Math.abs(yo) * -1;
		int[] xy = {(int) xo, (int) yo};
		return xy;
	}

	public Point getAristaHorario(double xo, double yo) {
		int xp, yp;
		//Arista horario
		xp = (int) (xo * Math.cos(TETA) + (-1 * yo) * Math.sin(TETA));
		yp = (int) (xo * Math.sin(TETA) + yo * Math.cos(TETA));
		xp = lineaP1.x + xp;
		yp = lineaP1.y - yp;
		return new Point(xp, yp);
	}

	public Point getAristaAntihorario(double xo, double yo) {
		int xp, yp;
		//Arista antihorario
		xp = (int) (xo * Math.cos(TETA) + yo * Math.sin(TETA));
		yp = (int) ((-1 * xo) * Math.sin(TETA) + yo * Math.cos(TETA));
		xp = lineaP1.x + xp;
		yp = lineaP1.y - yp;
		return new Point(xp, yp);
	}

	public double[] traslacionPlano(double x, double y) {
		double xo = x - lineaP1.x;
		double yo = lineaP1.y - y;
		double[] xoyo= {xo, yo};
		return xoyo;
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
	 * @return the arista1P1
	 */
	public Point getArista1P1() {
		return arista1P1;
	}
	
	/**
	 * @return the arista1P2
	 */
	public Point getArista1P2() {
		return arista1P2;
	}

	/**
	 * @return the arista2P1
	 */
	public Point getArista2P1() {
		return arista2P1;
	}

	/**
	 * @return the arista2P2
	 */
	public Point getArista2P2() {
		return arista2P2;
	}
}
