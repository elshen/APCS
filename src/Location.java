import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import java.util.Scanner;
import java.util.Random;

public class Location 
{
  private int x;
  private int y;
  public static final int LRADIUS = 5;
  private Color c;
  
  public Location(int dx, int dy, Color dcolor)
  {
    x = dx;
    y = dy;
    c = dcolor;
  }
  
  public double getX()
  {
	return x;
   }
	
   public double getY()
   {
	return y;
    }
    
    public Color getColor()
   {
	return c;
    }
  
}
