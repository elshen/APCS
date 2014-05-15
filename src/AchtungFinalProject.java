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
	public static final int WINDOW_WIDTH = 1000;
	public static final int WINDOW_HEIGHT = 800;
	static final int TOP_OF_WINDOW = 22;	// Top of the visible window
	public static final int DELAY_IN_MILLISEC = 100;  // Time delay between updates
	public static final int PLAYERONESTARTX = 250;
	public static final int PLAYERONESTARTY = 200;
	public static final int PLAYERTWOSTARTX = 750;
	public static final int PLAYERTWOSTARTY = 600;

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
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
		}
		if (keyCode == KeyEvent.VK_LEFT)
		{
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
	}

	public void paint(Graphics g)
	{
		// Clear the window.
		g.setColor(Color.black);
		g.fillRect(0, TOP_OF_WINDOW, WINDOW_WIDTH, WINDOW_HEIGHT - TOP_OF_WINDOW);
	}

}
