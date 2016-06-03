package space;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Scoreboard extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int namex=200;
	int scorex=400;
	int y=100;
	
	
	JFrame window;
	JButton menuButton;
	ImageLoaded images;
	String fileName="Score.ser";
	Font f;
	MyFont mf;
	Score score;
	ArrayList<Score> scores;
	File file;
	ObjectInputStream ois;
	
	/**
	 * Az eredménylista képernyõje
	 * @param window - az ablak
	 * @param images - a képek
	 */
	Scoreboard(JFrame window, ImageLoaded images){
		
	setOpaque(false);
	setLayout(null);
	this.images=images;
	this.window=window;
	mf= new MyFont();
	f= mf.f;

	
	menuButton=new  JButton("Menü");
	menuButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			window.getContentPane().removeAll();
			new Menu(window, images);
			
		}
	}
			
			);
	
    this.add(menuButton);
    menuButton.setFont(f);
    menuButton.setBounds(0, 500, 200, 40);
    menuButton.setOpaque(false);
    menuButton.setBorderPainted(false);
	menuButton.setFocusPainted(false);
    menuButton.setContentAreaFilled(false);
    window.add(this);
    window.setVisible(true);
    window.requestFocus();
	window.revalidate();
	}
	
	/**
	 * A háttér és az eredmények kiírása a képernyõre
	 */
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setFont(f);
		g.drawImage(images.background , 0, 0, 800, 600, this);
		try {
			beolvas();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Integer i=0; i<scores.size() && i<15; i++){
			Integer w= i+1;
			g.drawString( w.toString()+". "+scores.get(i).name, namex, y+i*20);
			g.drawString(scores.get(i).score.toString(), scorex, y+i*20);
		}
		
		
        



	}
	
	/**
	 * A Serializált fájl beolvasása
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public void beolvas() throws FileNotFoundException, IOException, ClassNotFoundException {

		ois = new ObjectInputStream(new FileInputStream(fileName));
		scores = (ArrayList<Score>) ois.readObject();
		ois.close();

		
		Collections.sort(scores, new Score());
	}
	
	
}
