package space;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu extends JPanel{
	/**
	 * 
	 */
	
	JFrame window;
	JButton startButton;
	JButton scoreButton;
	ImageLoaded images;
	MyFont mf = new MyFont();
	Font f;
	/**
	 * 
	 * @param window - Az ablakot kapja meg
	 * @param images - Az elõre betöltött képeket kapja meg
	 */
	public Menu(JFrame window, ImageLoaded images){
		setOpaque(false);
		setLayout(null);
		f=mf.f;
		this.images=images;
		this.window=window;
		

		startButton=new  JButton("Játék Indítása");
		startButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				window.getContentPane().removeAll();
				new GameStart(window, images);
				
			}
		}
				
				);
		
        this.add(startButton);
        startButton.setFont(f);
        startButton.setBounds(250, 275, 300, 40);
        startButton.setOpaque(true);
        startButton.setBorderPainted(true);
		startButton.setFocusPainted(false);
        startButton.setContentAreaFilled(false);
        
        scoreButton = new JButton("Eredménylista");
        scoreButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				window.getContentPane().removeAll();
				new Scoreboard(window, images);
				
			}
		}
				
				);
		
        this.add(scoreButton);
        scoreButton.setFont(f);
        scoreButton.setBounds(250, 375, 300, 40);
        scoreButton.setOpaque(true);
        scoreButton.setBorderPainted(true);
		scoreButton.setFocusPainted(false);
        scoreButton.setContentAreaFilled(false);
        window.add(this);
        window.setVisible(true);
        
	}
	private static final long serialVersionUID = 1L;
	
	/**
	 *  Itt rajzolom ki a hátteret
	 */
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(images.background , 0, 0, 800, 600, this);
		
        



	}
	

}
