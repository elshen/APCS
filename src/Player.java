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
	private ArrayList<Location> listOfLocs;
	private Color color;
	private int x;
	private int y;
	private int dx;
	private int dy;
	final static int RADIUS = 5;
	final static int V = 6;
	
	public Player(Color color, int xIn, int xIn)
	{
		listOfLocs = new ArrayList<Location>();
		this.color = color;
		x = xIn;
		y = yIn;
	}
	public ArrayList<Location> getLocs()
	{
		return listOfLocs;
	}
	public void addNewLoc()
	{
		
	}
	
	public boolean checkHit(Location loc)
	{
		double xDistance = loc.getX() - x;
		double yDistance = loc.getY() - y;

		if ((xDistance * xDistance) + (yDistance * yDistance) <= (RADIUS + Location.RADIUS) * (RADIUS + Location.RADIUS)) // finds if player is touching a location
		{
			if () // check to make sure that its not the most recently dropped location
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		else 
		{
			return false;
		}
	}
}
