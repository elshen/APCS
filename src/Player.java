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
	public static final int WINDOW_WIDTH = 1000;
	public static final int WINDOW_HEIGHT = 800;
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
		listOfLocs.add(loc);
		lastLoc = listOfLocs.get(listOfLocs.size() - 2);
	}
	
	public boolean checkCollisions(Player otherPlayer)
	{
		if( x >= WINDOW_WIDTH || x <= 0)
			return true;
		
		if (y >= WINDOW_HEIGHT|| y <= 0)
			return true;
			
		for(Location loc: listOfLocs)
		{
			if(checkHit(loc))
				return true;
		}
		
		for(Location loc: otherPlayer.getLocs())
		{
			if(checkHit(loc))
				return true;
		}
		return false;
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
	
	public void move()
	{
		x = x + dx;
		y = y + dy;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setX( int newX)
	{
		x = newX;
	}
	
	public void setY( int newY)
	{
		y = newY;
	}
	
	public int getDX()
	{
		return dx;
	}
	
	public int getDY()
	{
		return dy;
	}
	
	public void setDX( int newDX)
	{
		dx = newDX;
	}
	
	public void setDY( int newDY)
	{
		dy = newDY;
	}
	
	
}
