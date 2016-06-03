package space;

import java.util.ArrayList;



public class CollisionDetection {
	
	boolean endgame=false;
	/**
	 * A rep�l� �s az ellenfelek �tk�z�s�t vizsg�lja
	 * @param myplane - A j�t�kos rep�l�je
	 * @param enemys - Az ellens�g rep�l�i
	 */
	public void isCollisionDetection(Plane myplane, ArrayList<Plane> enemys){
		for(int i=0; i<enemys.size(); i++)
		if((Math.abs(myplane.getX()-enemys.get(i).getX()))<35 && Math.abs(myplane.getY()-enemys.get(i).getY())<35){
			System.out.println("�tk�z�tt");
			myplane.minusLife();
			endgame=true;
		}
	}
	
	/**
	 * Megn�zi hogy eltal�ltunk-e egy ellenfelet
	 * @param bullet - A player l�ved�kei
	 * @param enemys - Az ellens�g rep�l�i
	 */
	public void isCollisionDetection(ArrayList<Plane> bullet, ArrayList<Plane> enemys){
		for(int i=0; i<enemys.size();i++){
			for(int j=0; j<bullet.size(); j++){
				if((Math.abs((bullet.get(j).getX())-enemys.get(i).getX()))<15 && Math.abs(bullet.get(j).getY()-30-enemys.get(i).getY())<35){
					System.out.println("lel�ve");
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
	 * Megn�zi, hogy a rep�l�nket eltal�lt�k-e az ellenf�l l�ved�kei
	 * @param myplane - A j�t�kos rep�l�i
	 * @param bullets - Az ellenf�l l�ved�kei
	 */
	public void isBulletCollisionDetection(Plane myplane, ArrayList<Plane> bullets){
		for(int i=0; i<bullets.size(); i++)
		if((Math.abs(myplane.getX()+25-bullets.get(i).getX()))<25 && Math.abs(myplane.getY()+30-bullets.get(i).getY())<25){
			bullets.remove(i);
			System.out.println("�tk�z�tt");
			myplane.minusLife();
		}
	}
	
	/**
	 * Megn�zi hogy �tl�pt�k-e a p�lya sz�l�t az ellens�g rep�l�i
	 * @param enemys - Az ellens�g rep�l�i
	 * @return - true ha igen, egy�bk�nt false
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
