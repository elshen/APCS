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
	public static final int DELAY_IN_MILLISEC = 50;  // Time delay between updates
	public static final int RADIUS = 4;
	public static final double MAX_VELOCITY = 3;
	
	public static double x = WINDOW_WIDTH / 2;
	public static double y = WINDOW_HEIGHT / 2;
	public static double multiple = .2;
	public static double dx = 3;
	public static double dy = 3;
	
	public static boolean movingLeft;
	public static boolean movingRight;
	

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
		}
		if(movingRight)
		{
			double temp = dx;
			dx = dx - multiple * dy;
			dy = dy + multiple * temp;
			double currentVelocity = Math.sqrt(dx*dx + dy*dy);
			dx = dx / currentVelocity * MAX_VELOCITY;
			dy = dy / currentVelocity * MAX_VELOCITY;
		}
		
		x = x + dx;
		y = y + dy;
		
		System.out.println(Math.sqrt(dx*dx + dy*dy));
		
		// Update the window.
		repaint();

		//When game ends saves top score
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
		g.setColor(Color.red);
		g.fillOval((int)x - RADIUS,(int)y - RADIUS, 2*RADIUS , 2*RADIUS);
	}

}
