package space;


public class Plane {
	private int x, y;
	private int xVel=0, yVel=0;
	private int life;
	private int type;
	
	
	/**
	 * A rep�l� konstruktora
	 * @param x_ - x kordin�t�ja
	 * @param y_ - y kordin�t�ja
	 */
	Plane(int x_, int y_){
		x=x_;
		y=y_;
		this.life=1;
	}
	/**
	 * A rep�l� konstruktora �lettel egy�tt
	 * @param x_ - x kordin�t�ja
	 * @param y_ - y kordin�t�ja
	 * @param life - a rep�l� �lete
	 */
	Plane(int x_, int y_, int life){
		x=x_;
		y=y_;
		this.life=life;
	}
	
	/**
	 * A rep�l� poz�ci�j�nak be�ll�t�sa
	 * @param x_ - x kordin�t�ja
	 * @param y_ - y kordin�t�ja
	 */
	public void setLocation(int x_, int y_){
		x=x_;
		y=y_;
	}
	
	/**
	 * A x �s y ir�ny� sebess�g�nek be�ll�t�sa
	 * @param xVel_ x ir�ny� sebess�g
	 * @param yVel_ y ir�ny� sebess�g
	 */
	public void setVel(int xVel_, int yVel_){
		xVel=xVel_;
		yVel=yVel_;
		
	}
	
	/**
	 * Az x ir�ny� sebess�g be�ll�t�sa
	 * @param xVel_ - x ir�ny� sebess�g
	 */
	public void setxVel(int xVel_){
		xVel=xVel_;
	}
	
	/**
	 * Az y ir�ny� sebess�g be�ll�t�sa
	 * @param yVel_ - y ir�ny� sebess�g
	 */
	public void setyVel(int yVel_){
		yVel=yVel_;
	}
	
	/**
	 * Az x ir�ny� sebess�g lek�rdez�se
	 * @return - az x ir�ny� sebess�g
	 */
	public int getxVel(){
		
		return xVel;
	}
	
	/**
	 * Az y ir�ny� sebess�g lek�rdez�se
	 * @return - az y ir�ny� sebess�g
	 */
	public int getyVel(){
		return yVel;
	}
	
	/**
	 * Az x koordin�t�j�nak be�ll�t�sa
	 * @param x_ - x koordin�ta
	 */
	public void setX(int x_){
		x=x_;
	}
	
	/**
	 * Az y koordin�t�j�nak be�ll�t�sa
	 * @param y_ - y koordin�ta
	 */
	public void setY(int y_){
		y=y_;
	}
	
	/**
	 * Az x koordin�t�j�nak lek�rdez�se
	 * @return - x koordin�ta
	 */
	public int getX(){
		
		return x;
	}
	
	/**
	 * Az y koordin�t�j�nak lek�rdez�se
	 * @return - y koordin�ta
	 */
	public int getY(){
		return y;
	}
	
	/**
	 * A rep�l� �let�nek be�ll�t�sa
	 * @param life - az �lete
	 */
	public void setLife(int life){
		this.life=life;
	}
	
	/**
	 * A rep�l� �let�nek lek�rdez�se
	 * @return - az �lete
	 */
	public Integer getLife(){
		return life;
	}
	
	/**
	 * Egyel cs�kkenti az �leterej�t a rep�l�g�pnek
	 */
	public void minusLife(){
		life--;
	}
	
	/**
	 * A rep�l� tipus�nak be�ll�t�sa
	 * @param type - a t�pusa
	 */
	public void setType(int type){
		this.type=type;
	}
	
	/**
	 * A rep�l� t�pus�nak lek�rdez�se
	 * @return - a t�pusa
	 */
	public int getType(){
		return type;
	}
}
