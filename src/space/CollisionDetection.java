package space;

import java.util.ArrayList;



public class CollisionDetection {
	
	boolean endgame=false;
	/**
	 * A repülõ és az ellenfelek ütközését vizsgálja
	 * @param myplane - A játékos repülõje
	 * @param enemys - Az ellenség repülõi
	 */
	public void isCollisionDetection(Plane myplane, ArrayList<Plane> enemys){
		for(int i=0; i<enemys.size(); i++)
		if((Math.abs(myplane.getX()-enemys.get(i).getX()))<35 && Math.abs(myplane.getY()-enemys.get(i).getY())<35){
			System.out.println("ütközött");
			myplane.minusLife();
			endgame=true;
		}
	}
	
	/**
	 * Megnézi hogy eltaláltunk-e egy ellenfelet
	 * @param bullet - A player lövedékei
	 * @param enemys - Az ellenség repülõi
	 */
	public void isCollisionDetection(ArrayList<Plane> bullet, ArrayList<Plane> enemys){
		for(int i=0; i<enemys.size();i++){
			for(int j=0; j<bullet.size(); j++){
				if((Math.abs((bullet.get(j).getX())-enemys.get(i).getX()))<15 && Math.abs(bullet.get(j).getY()-30-enemys.get(i).getY())<35){
					System.out.println("lelõve");
					bullet.remove(j);
					enemys.get(i).minusLife();
					if(enemys.get(i).getLife()==0){
						enemys.remove(i);
					}
					
				}
			}
		}
	}
	
	/**
	 * Megnézi, hogy a repülõnket eltalálták-e az ellenfél lövedékei
	 * @param myplane - A játékos repülõi
	 * @param bullets - Az ellenfél lövedékei
	 */
	public void isBulletCollisionDetection(Plane myplane, ArrayList<Plane> bullets){
		for(int i=0; i<bullets.size(); i++)
		if((Math.abs(myplane.getX()+25-bullets.get(i).getX()))<25 && Math.abs(myplane.getY()+30-bullets.get(i).getY())<25){
			bullets.remove(i);
			System.out.println("ütközött");
			myplane.minusLife();
		}
	}
	
	/**
	 * Megnézi hogy átlépték-e a pálya szélét az ellenség repülõi
	 * @param enemys - Az ellenség repülõi
	 * @return - true ha igen, egyébként false
	 */
	public boolean outOfMap(ArrayList<Plane> enemys){
		for(int i=0; i<enemys.size();i++){
			if(enemys.get(i).getX()<=0){
				enemys.remove(i);
				System.out.println("Kint van");
				return true;
			}
		}
		return false;
	}
	
	
	
	
	

}
