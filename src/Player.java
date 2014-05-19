import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import java.util.Scanner;
import java.util.Random;

public class Player
{
	public static final int WINDOW_WIDTH = 1000;
	public static final int WINDOW_HEIGHT = 800;
	private Color color;
	private double x;
	private double y;
	private double dx;
	private double dy;
	public final static double RADIUSP = 3.5;

	public Player(Color color, double xIn, double yIn, double dxIn, double dyIn)
	{
		
		this.color = color;
		x = xIn;
		y = yIn;
		dx = dxIn;
		dy = dyIn;
	}

	public void move()
	{
		x = x + dx;
		y = y + dy;
	}

	public double getX()
	{
		return x;
	}

	public double getY()
	{
		return y;
	}

	public void setX( double newX)
	{
		x = newX;
	}

	public void setY( double newY)
	{
		y = newY;
	}

	public double getDX()
	{
		return dx;
	}

	public double getDY()
	{
		return dy;
	}

	public void setDX( double newDX)
	{
		dx = newDX;
	}

	public void setDY( double newDY)
	{
		dy = newDY;
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.red);
		g.fillOval((int)(x-RADIUSP), (int)(y - RADIUSP), (int)(RADIUSP*2), (int)(RADIUSP*2));
	}


}
