import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import java.util.Scanner;
import java.util.Random;

public class AchtungFinalProject extends JFrame implements ActionListener, KeyListener
{
	static final int WINDOW_WIDTH = 1000;
	static final int WINDOW_HEIGHT = 800;
	static final int TOP_OF_WINDOW = 22;	// Top of the visible window
	public static final int DELAY_IN_MILLISEC = 40;  // Time delay between updates
	public static final double MAX_VELOCITY = 3;
	
	public static double multiple = .2;
	public static double dx = Math.sqrt(MAX_VELOCITY*MAX_VELOCITY/2);
	public static double dy = Math.sqrt(MAX_VELOCITY*MAX_VELOCITY/2);
	
	public static boolean movingLeft;
	public static boolean movingRight;
	public static boolean dead = false;
	
	public static boolean[][] pixelTemplate = 
		{{false, false, false, false ,false, false, false},
		{false, false, false, false ,false, false, false},
		{false, false, true, true, true, false, false},
		{false, false, true, true ,true, false, false},
		{false, false, true, true ,true, false, false},
		{false, false, false, false ,false, false, false},
		{false, false, false, false ,false, false, false}};
	public static boolean[][] screenPixels = new boolean[WINDOW_WIDTH][WINDOW_HEIGHT];
	
	public static Player p;
	

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		AchtungFinalProject mb = new AchtungFinalProject();
	}
	
	public AchtungFinalProject()
	{
		
		for(int x = 0; x < WINDOW_WIDTH; x++)
		{
			for(int y = 0; y < WINDOW_HEIGHT; y++)
			{
				screenPixels[x][y] = false;
			}
		}
		
		p = new Player(Color.red, WINDOW_WIDTH/2, WINDOW_HEIGHT/2, 3, 3);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Achtung");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setVisible(true);
		
		
		//Start Timer
		Timer clock= new Timer(DELAY_IN_MILLISEC, this);
				
		//Create key Listener
		addKeyListener(this);
		
		clock.start();
	}

	/**
	 * actionPerformed -- Move the ball every time the "timer" goes off.
	 * Note that all of the action that we want to happen every time the timer
	 * goes off goes in this method.
	 */
	public void actionPerformed(ActionEvent e)
	{	
		if(movingLeft)
		{
			double temp = dx;
			dx = dx + multiple * dy;
			dy = dy - multiple * temp;
			double currentVelocity = Math.sqrt(dx*dx + dy*dy);
			dx = dx / currentVelocity * MAX_VELOCITY;
			dy = dy / currentVelocity * MAX_VELOCITY;
			
			p.setDX(dx);
			p.setDY(dy);
		}
		if(movingRight)
		{
			double temp = dx;
			dx = dx - multiple * dy;
			dy = dy + multiple * temp;
			double currentVelocity = Math.sqrt(dx*dx + dy*dy);
			dx = dx / currentVelocity * MAX_VELOCITY;
			dy = dy / currentVelocity * MAX_VELOCITY;
			
			p.setDX(dx);
			p.setDY(dy);
		}
		
		if(!dead)
		{
			p.move();
			
			if(p.getX() > 0 && p.getY() > 0 && p.getX() < WINDOW_WIDTH && p.getY() < WINDOW_HEIGHT)
			{
				if(screenPixels[(int)p.getX()][(int)p.getY()])
				{
					System.out.println("dead");
					dead = true;
				}
				
				int currentX = (int)(p.getX());
				int currentY = (int)(p.getY());
				
				for(int x = currentX - 3; x <= currentX + 3; x++)
				{
					for(int y = currentY - 3; y <= currentY + 3; y++)
					{
						if(x > 0 && y > 0 && x < WINDOW_WIDTH && y < WINDOW_HEIGHT)
						{
							if(pixelTemplate[x+3-currentX][y+3-currentY])
							{
								screenPixels[x][y] = true;
							}
						}
					}
				}
				//System.out.println(Math.sqrt(dx*dx + dy*dy));
				
			}
			else
			{
				dead = true;
			}
			// Update the window.
			repaint();
		}
	}

	/**
	 * Allows for the user to enter commands
	 */
	public void keyPressed(KeyEvent e)					// #4A
	{
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_RIGHT)
		{
			movingRight = true;
		}
		if (keyCode == KeyEvent.VK_LEFT)
		{
			movingLeft = true;
		}
	}

	/**
	 * Called when typing of a key is completed
	 * Required for any KeyListener
	 * 
	 * @param e		Contains info about the key typed
	 */
	public void keyTyped(KeyEvent e)					// #4B
	{
	}

	/**
	 * Called when a key is released
	 * Required for any KeyListener
	 * 
	 * @param e		Contains info about the key released
	 */
	public void keyReleased(KeyEvent e)					// #4C
	{
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_RIGHT)
		{
			movingRight = false;
		}
		if (keyCode == KeyEvent.VK_LEFT)
		{
			movingLeft = false;
		}
	}

	public void paint(Graphics g)
	{
		// Clear the window.
//		g.setColor(Color.black);
//		g.fillRect(0, TOP_OF_WINDOW, WINDOW_WIDTH, WINDOW_HEIGHT - TOP_OF_WINDOW);
		p.draw(g);
		
	}

}
