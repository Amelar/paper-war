package space;

import java.util.ArrayList;
import java.util.Random;

public class Computer extends Random{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Plane> enemys;
	ArrayList<Plane> bullets;
	Plane myplane;
	int timer =0;
	int random;
	int x = 800;
	boolean stop=false;
	boolean topdown=false;
	
	/**
	 * 
	 * @param enemy - Az ellenf�l rep�l�i
	 * @param bullets - Az ellenf�l l�ved�kei
	 */
	public Computer(ArrayList<Plane> enemy, ArrayList<Plane> bullets){
		this.enemys = enemy;
		this.bullets=bullets;
	}
	
	
	/**
	 * Meg�ll�tja az ellenfelet
	 */
	public void stop(){
		stop=true;
	}
	
	/**
	 * Egy ellens�g gener�l� f�gv�ny
	 */
	public void enemyGenerator2(){
		random = nextInt(4);
		if(!stop){
			//random = nextInt(3);
			if(timer%125==0){
				if(random==0){
					enemys.add(enemy3(150));
				}
				else if(random==1){
					enemys.add(enemy1(50));
				}
				else if(random==2){
					enemys.add(enemy2(350));
				}
				else if (random==3){
					enemys.add(enemy1(250));
				}
			}
		timer++;	
		}
	}
	
	public void enemyGenerator(){
		if(!stop){
		if(timer%1000==0){
			enemys.add(enemy1(50));
			enemys.add(enemy1(250));
			enemys.add(enemy1(450));
		}
		if(timer%1000==150){
			enemys.add(enemy2(150));
			enemys.add(enemy2(350));
		}
		if(timer%1000==300){
			enemys.add(enemy3(100));
			enemys.add(enemy3(400));
		}
		if(timer%1000==400)
			enemys.add(enemy1(50));
		if(timer%1000==450)
			enemys.add(enemy1(250));
		if(timer%1000==500)
			enemys.add(enemy3(400));
		if(timer%1000==550){
			enemys.add(enemy2(300));
			enemys.add(enemy2(200));
			enemys.add(enemy2(100));
		}
		if(timer%1000==650){
			enemys.add(enemy3(250));
			enemys.add(enemy3(50));
			enemys.add(enemy3(450));
		}
		
		
		timer++;
		}
	}
	
	/**
	 * Az ellens�get ir�ny�t� f�ggv�ny
	 */
	public void enemyControl(){
		if(!stop){
		for(int i=0; i<enemys.size(); i++)
			if(enemys.get(i).getType()==1)
				enemy1Control(enemys.get(i));
			else if(enemys.get(i).getType()==2)
				enemy2Control(enemys.get(i));
			else if(enemys.get(i).getType()==3){
				enemy2Control(enemys.get(i));
				if(timer%75==0)
				//bullets.add(new Plane(enemys.get(i).getX(), enemys.get(i).getY()+30));
				bullets.add(bullet(enemys.get(i).getX(), enemys.get(i).getY()+30));
			}
		for(int i=0; i<bullets.size();i++){
			bullets.get(i).setxVel(-3);
		}
		
	}
	}
	
	/**
	 * Egy 3. tipusu rep�l�t hoz l�tre
	 * @param y - Az ellenf�l y kordin�t�ja
	 * @return - Visszat�r egy rep�l�vel
	 */
	private Plane enemy3(int y){
		Plane plane = new Plane(x, y);
		plane.setLife(2);
		plane.setType(3);
		return plane;
	}
	
	/**
	 * Egy 2. tipus� rep�l�t hoz l�tre
	 * @param y - Az ellenf�l y kordin�t�ja
	 * @return - Visszat�r a rep�l�vel
	 */
	private Plane enemy2(int y){
		Plane plane = new Plane(x, y);
		plane.setLife(2);
		plane.setType(2);
		return plane;
	}
	
	/**
	 * Egy 1. t�pus� rep�l�t hoz l�tre
	 * @param y - Az ellenf�l y kordin�t�ja
	 * @return - Visszat�r a rep�l�vel
	 */
	private Plane enemy1(int y){
		Plane plane = new Plane(x, y);
		plane.setLife(3);
		plane.setType(1);
		return plane;
	}
	
	/**
	 * Egy l�ved�ket hoz l�tre
	 * @param x A l�ved�k x kordin�t�ja
	 * @param y	A l�ved�k y kordin�t�ja
	 * @return	Visszat�r a l�ved�kkel
	 */
	private Plane bullet(int x, int y){
		Plane plane = new Plane(x, y);
		plane.setxVel(-3);
		return plane;
	}
	
	/**
	 * Ir�ny�t egy rep�l�t egyenesen el�re
	 * @param plane Megkapja a rep�l�t amit ir�ny�tani fog
	 */
	public void enemy1Control(Plane plane){
		plane.setxVel(-2);
	}
	
	/**
	 * Ir�ny�t egy rep�l�t cikkcakkosan
	 * @param plane - Megkapja a rep�l�t amit ir�ny�t
	 */
	public void enemy2Control(Plane plane){
		plane.setxVel(-2);
		if(timer%50<25)
			plane.setyVel(2);
		else
			plane.setyVel(-2);
	}
	
	
	
}
