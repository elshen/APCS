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
	private Location lastLoc;
	private Color color;
	private int x;
	private int y;
	private int dx;
	private int dy;
	public final static int RADIUSP = 5;
	public final static int V = 6;
	
	public Player(Color color, int xIn, int yIn)
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
		Location loc = new Location(x, y, color);
	}
	
	public boolean checkHit(Location loc)
	{
		double xDistance = loc.getX() - x;
		double yDistance = loc.getY() - y;

		if ((xDistance * xDistance) + (yDistance * yDistance) <= (RADIUSP + Location.LRADIUS) * (RADIUSP + Location.LRADIUS)) // finds if player is touching a location
		{
			if (loc.compareTo(lastLoc) == 0) // check to make sure that its not the most recently dropped location
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
