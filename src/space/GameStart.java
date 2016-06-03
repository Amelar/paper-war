package space;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 * 
 * @author Ádám
 *
 */
public class GameStart extends JPanel implements ActionListener{

	
	
	Timer tm;
	private static final long serialVersionUID = -6467188834815292689L;
	Plane plane = new Plane(80, 80, 10);
	ArrayList<Plane> bullet = new ArrayList<Plane>();
	Player player = new Player(plane, bullet);
	ArrayList<Plane> enemys = new ArrayList<Plane>();
	ArrayList<Plane> enemysBullet = new ArrayList<Plane>();
	Computer comp = new Computer(enemys, enemysBullet);
	Integer score=0;

	
	CollisionDetection cd = new CollisionDetection();
	JFrame window;
	ImageLoaded images;
	Font f;
	MyFont mf;
	
	/**
	 * Maga a Játék
	 * @param window - Az ablakot kapja paraméterül
	 * @param images - A képeket kapja meg
	 */
	GameStart(JFrame window, ImageLoaded images){
		this.window=window;
		this.images=images;
		tm = new Timer(10, this);
		tm.start();
		window.add(player);
		window.add(this);
		player.requestFocus();
		window.revalidate();
		mf= new MyFont();
		f= mf.f;
	}
	
	/**
	 *  Ez a függvény rajzolja ki a repülõket, hátteret, pontokat az életünket
	 */
	@Override
	public void paintComponent(Graphics g){
		
		
		g.setFont(f);
		super.paintComponent(g);
		g.drawImage(images.background , 0, 0, this);
		g.drawImage(images.myPlane, plane.getX(), plane.getY(), this);
		for(int i=0; i<enemys.size(); i++)
			g.drawImage(images.enemy1, enemys.get(i).getX(), enemys.get(i).getY(), this);
		for(int i=0; i< bullet.size(); i++)
			g.drawImage(images.bullet, bullet.get(i).getX(), bullet.get(i).getY(), this);
		for(int i=0; i< enemysBullet.size(); i++)
			g.drawImage(images.bullet, enemysBullet.get(i).getX(), enemysBullet.get(i).getY(), this);
			g.drawString("Score: " + score.toString(), 0, 20);
		g.drawString(plane.getLife().toString(), 0, 40);
			
	}
	
	/**
	 * Itt történnek meg a különféle eseményeknek a kezelése
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		score++;
		plane.setX(plane.getX()+plane.getxVel());
		plane.setY(plane.getY()+plane.getyVel());
		comp.enemyGenerator2();
		comp.enemyControl();
		cd.isCollisionDetection(plane, enemys);
		cd.isCollisionDetection(bullet, enemys);
		cd.isBulletCollisionDetection(plane, enemysBullet);
		if(cd.outOfMap(enemys))
			plane.minusLife();
		for(int i=0; i<enemys.size(); i++){
			enemys.get(i).setX(enemys.get(i).getX()+enemys.get(i).getxVel());
			enemys.get(i).setY(enemys.get(i).getY()+enemys.get(i).getyVel());
		}
		for(int i=0; i<bullet.size(); i++)
			bullet.get(i).setX(bullet.get(i).getX()+bullet.get(i).getxVel());
		for(int i=0; i<enemysBullet.size(); i++)
			enemysBullet.get(i).setX(enemysBullet.get(i).getX()+enemysBullet.get(i).getxVel());
		repaint();
		
		if(player.endgame==true){
			plane.setLife(10);
			window.getContentPane().removeAll();
			new Menu(window, images);
			player.removeAll();
			enemys.clear();
			bullet.clear();
			enemysBullet.clear();
			comp.stop();
			player.endgame=false;
		}
		if(cd.endgame==true || plane.getLife()==0){
			plane.setLife(10);
			window.getContentPane().removeAll();
			new ScoreAdd(window, score, images);
			player.removeAll();
			enemys.clear();
			bullet.clear();
			enemysBullet.clear();
			comp.stop();
			cd.endgame=false;
			
		}
		
	}
	
}

