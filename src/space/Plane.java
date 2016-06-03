package space;


public class Plane {
	private int x, y;
	private int xVel=0, yVel=0;
	private int life;
	private int type;
	
	
	/**
	 * A repülõ konstruktora
	 * @param x_ - x kordinátája
	 * @param y_ - y kordinátája
	 */
	Plane(int x_, int y_){
		x=x_;
		y=y_;
		this.life=1;
	}
	/**
	 * A repülõ konstruktora élettel együtt
	 * @param x_ - x kordinátája
	 * @param y_ - y kordinátája
	 * @param life - a repülõ élete
	 */
	Plane(int x_, int y_, int life){
		x=x_;
		y=y_;
		this.life=life;
	}
	
	/**
	 * A repülõ pozíciójának beállítása
	 * @param x_ - x kordinátája
	 * @param y_ - y kordinátája
	 */
	public void setLocation(int x_, int y_){
		x=x_;
		y=y_;
	}
	
	/**
	 * A x és y irányú sebességének beállítása
	 * @param xVel_ x irányú sebesség
	 * @param yVel_ y irányú sebesség
	 */
	public void setVel(int xVel_, int yVel_){
		xVel=xVel_;
		yVel=yVel_;
		
	}
	
	/**
	 * Az x irányú sebesség beállítása
	 * @param xVel_ - x irányú sebesség
	 */
	public void setxVel(int xVel_){
		xVel=xVel_;
	}
	
	/**
	 * Az y irányú sebesség beállítása
	 * @param yVel_ - y irányú sebesség
	 */
	public void setyVel(int yVel_){
		yVel=yVel_;
	}
	
	/**
	 * Az x irányú sebesség lekérdezése
	 * @return - az x irányú sebesség
	 */
	public int getxVel(){
		
		return xVel;
	}
	
	/**
	 * Az y irányú sebesség lekérdezése
	 * @return - az y irányú sebesség
	 */
	public int getyVel(){
		return yVel;
	}
	
	/**
	 * Az x koordinátájának beállítása
	 * @param x_ - x koordináta
	 */
	public void setX(int x_){
		x=x_;
	}
	
	/**
	 * Az y koordinátájának beállítása
	 * @param y_ - y koordináta
	 */
	public void setY(int y_){
		y=y_;
	}
	
	/**
	 * Az x koordinátájának lekérdezése
	 * @return - x koordináta
	 */
	public int getX(){
		
		return x;
	}
	
	/**
	 * Az y koordinátájának lekérdezése
	 * @return - y koordináta
	 */
	public int getY(){
		return y;
	}
	
	/**
	 * A repülõ életének beállítása
	 * @param life - az élete
	 */
	public void setLife(int life){
		this.life=life;
	}
	
	/**
	 * A repülõ életének lekérdezése
	 * @return - az élete
	 */
	public Integer getLife(){
		return life;
	}
	
	/**
	 * Egyel csökkenti az életerejét a repülõgépnek
	 */
	public void minusLife(){
		life--;
	}
	
	/**
	 * A repülõ tipusának beállítása
	 * @param type - a típusa
	 */
	public void setType(int type){
		this.type=type;
	}
	
	/**
	 * A repülõ típusának lekérdezése
	 * @return - a típusa
	 */
	public int getType(){
		return type;
	}
}
