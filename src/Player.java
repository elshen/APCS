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
	
	public Player(Color color)
	{
		listOfLocs = new ArrayList<Location>();
		this.color = color;
	}
	public ArrayList<Location> getLocs()
	{
		return listOfLocs;
	}
	public void addNewLoc()
	{
		
	}
}
