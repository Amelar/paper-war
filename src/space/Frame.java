package space;

import javax.swing.JFrame;

public class Frame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame window;
	// k�pek bet�lt�se
	ImageLoaded images = new ImageLoaded();
	/**
	 * Az ablak l�trehoz�sa
	 */
	Frame(){
		window=new JFrame("PaperWar");
		window.setResizable(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(800, 600);
		window.setVisible(true);
	}
	}
