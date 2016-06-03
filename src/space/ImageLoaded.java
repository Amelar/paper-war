package space;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageLoaded {
	Image background;
	Image myPlane;
	Image enemy1;
	Image bullet;
	/**
	 * A képek betöltése itt történik
	 */
	ImageLoaded(){
	ImageIcon bg= new ImageIcon("image/background.png");
	background = bg.getImage();
	ImageIcon myPlane_= new ImageIcon("image/myPlane.png");
	myPlane = myPlane_.getImage();
	ImageIcon enemy1_ = new ImageIcon("image/enemy2.png");
	enemy1= enemy1_.getImage();
	ImageIcon bullet_=new ImageIcon("image/bullet.png");
	bullet=bullet_.getImage();
	}
}
