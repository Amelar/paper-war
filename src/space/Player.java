package space;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Player extends JPanel implements KeyListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Plane myPlane;
	boolean endgame=false;
	ArrayList<Plane> bullet;
	int time=0;
	/**
	 * 
	 * @param p - A játékos repülõgépe
	 * @param bullet - A lövedékek listája
	 */
	Player(Plane p, ArrayList<Plane> bullet){
		myPlane=p;
		this.bullet=bullet;
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	/**
	 * A billentyû lenyomásra történõ események kezelése
	 */
	@Override
	public synchronized void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		System.out.println("Ide");
		if(c== KeyEvent.VK_LEFT)
		{
			
			myPlane.setxVel(-2);
			if(myPlane.getX()<=0)
				myPlane.setX(0);
			//myPlane.setyVel(0);
		}
		else if(c== KeyEvent.VK_RIGHT)
		{
			myPlane.setxVel(2);
			//myPlane.setyVel(0);
		}
		else if(c==KeyEvent.VK_UP)
		{
			//myPlane.setxVel(0);
			myPlane.setyVel(-2);
		}
		else if(c==KeyEvent.VK_DOWN)
		{
			//myPlane.setxVel(0);
			myPlane.setyVel(2);
		}
		else if(c==KeyEvent.VK_SPACE){
			if(time%10==0){
			bullet.add(new Plane(myPlane.getX()+70, myPlane.getY()+23));
			bullet.get(bullet.size()-1).setxVel(3);
			time++;
			}
		}
		else if(c==KeyEvent.VK_ESCAPE){
			endgame=true;
		}
	}
	
	
	/**
	 * Amíg a billentyû lent van tartva addig az események
	 */
	@Override
	public synchronized void  keyReleased(KeyEvent e) {
		int c = e.getKeyCode();
		if(c== KeyEvent.VK_LEFT)
		{
			myPlane.setxVel(0);
			//myPlane.setyVel(0);
		}
		else if(c== KeyEvent.VK_RIGHT)
		{
			myPlane.setxVel(0);
			//myPlane.setyVel(0);
		}
		else if(c==KeyEvent.VK_UP)
		{
			//myPlane.setxVel(0);
			myPlane.setyVel(0);
		}
		else if(c==KeyEvent.VK_DOWN)
		{
			//myPlane.setxVel(0);
			myPlane.setyVel(0);
		}
		else if(c==KeyEvent.VK_SPACE){
			time=0;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
}
