import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import java.util.ArrayList;

import java.util.Scanner;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;


public class AchtungFinalProject extends JFrame implements ActionListener, KeyListener
{
	static final int WINDOW_WIDTH = 1000;
	static final int WINDOW_HEIGHT = 800;
	static final int TOP_OF_WINDOW = 22;	// Top of the visible window
	public static final int DELAY_IN_MILLISEC = 30;  // Time delay between updates
	public static final double MAX_VELOCITY = 3;

	public static double multiple = .1;
	public static double dx1 = Math.sqrt(MAX_VELOCITY*MAX_VELOCITY/2);
	public static double dy1 = Math.sqrt(MAX_VELOCITY*MAX_VELOCITY/2);
	public static double dx2 = Math.sqrt(MAX_VELOCITY*MAX_VELOCITY/2);
	public static double dy2 = Math.sqrt(MAX_VELOCITY*MAX_VELOCITY/2);

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
	private final Set<Integer> keysPressed = new HashSet<Integer>();
	public static Player p1;
	public static Player p2;
	public static int time = 0;


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

		p1 = new Player(Color.red, WINDOW_WIDTH/2, WINDOW_HEIGHT/2, 3, 3);
		p2 = new Player(Color.blue, WINDOW_WIDTH/3, WINDOW_HEIGHT/3, 3, 3);

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

		if(keysPressed.contains(KeyEvent.VK_LEFT))
		{
			//left player one
			double temp = dx1;
			dx1 = dx1 + multiple * dy1;
			dy1 = dy1 - multiple * temp;
			double currentVelocity = Math.sqrt(dx1*dx1 + dy1*dy1);
			dx1 = dx1 / currentVelocity * MAX_VELOCITY;
			dy1 = dy1 / currentVelocity * MAX_VELOCITY;

			p1.setDX(dx1);
			p1.setDY(dy1);

		}
		if(keysPressed.contains(KeyEvent.VK_RIGHT))
		{
			double temp = dx1;
			dx1 = dx1 - multiple * dy1;
			dy1 = dy1 + multiple * temp;
			double currentVelocity = Math.sqrt(dx1*dx1 + dy1*dy1);
			dx1 = dx1 / currentVelocity * MAX_VELOCITY;
			dy1 = dy1 / currentVelocity * MAX_VELOCITY;

			p1.setDX(dx1);
			p1.setDY(dy1);
		}


		if(keysPressed.contains(KeyEvent.VK_A))
		{
			double temp = dx2;
			dx2 = dx2 + multiple * dy2;
			dy2 = dy2 - multiple * temp;
			double currentVelocity = Math.sqrt(dx2*dx2 + dy2*dy2);
			dx2 = dx2 / currentVelocity * MAX_VELOCITY;
			dy2 = dy2 / currentVelocity * MAX_VELOCITY;

			p2.setDX(dx2);
			p2.setDY(dy2);
			System.out.println("vk1");
		}
		if(keysPressed.contains(KeyEvent.VK_D))
		{
			double temp = dx2;
			dx2 = dx2 - multiple * dy2;
			dy2 = dy2 + multiple * temp;
			double currentVelocity = Math.sqrt(dx2*dx2 + dy2*dy2);
			dx2 = dx2 / currentVelocity * MAX_VELOCITY;
			dy2 = dy2 / currentVelocity * MAX_VELOCITY;

			p2.setDX(dx2);
			p2.setDY(dy2);
			System.out.println("vk2");
		}

		if(!dead)
		{
			p1.move();
			p2.move();

			if(p1.getX() > 0 && p1.getY() > 0 && p1.getX() < WINDOW_WIDTH && p1.getY() < WINDOW_HEIGHT)
			{
				if(screenPixels[(int)p1.getX()][(int)p1.getY()])
				{
					System.out.println("dead");
					dead = true;
				}

				int currentX = (int)(p1.getX());
				int currentY = (int)(p1.getY());

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
			}
			else
			{
				dead = true;
			}
			//System.out.println(Math.sqrt(dx*dx + dy*dy));
			if(p2.getX() > 0 && p2.getY() > 0 && p2.getX() < WINDOW_WIDTH && p2.getY() < WINDOW_HEIGHT)
			{
				if(screenPixels[(int)p2.getX()][(int)p2.getY()])
				{
					System.out.println("dead");
					dead = true;
				}

				int currentX = (int)(p2.getX());
				int currentY = (int)(p2.getY());

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
			}
			else
			{
				dead = true;
			}
			// Update the window.
			repaint();
		}
		time++;
	}

	/**
	 * Allows for the user to enter commands
	 */
	public void keyPressed(KeyEvent e)					// #4A
	{
		keysPressed.add(e.getKeyCode());
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
		keysPressed.remove(e.getKeyCode());
	}

	public void paint(Graphics g)
	{
		// Clear the window.
		if(time==0)
		{
			g.setColor(Color.black);
			g.fillRect(0, TOP_OF_WINDOW, WINDOW_WIDTH, WINDOW_HEIGHT - TOP_OF_WINDOW);
		}
		p1.draw(g);
		p2.draw(g);

	}
	
}
