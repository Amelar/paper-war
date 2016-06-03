package space;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ScoreAdd extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Score score;
	Integer tempscore;
	ArrayList<Score> scores;
	File file;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	String fileName="Score.ser";
	JTextField nameText;
	JButton saveButton;
	Font f;
	MyFont mf;
	JFrame window;
	ImageLoaded images;
	
	
	/**
	 * Az eredmény beírásához elõkészíti a képernõyt
	 * @param window - az ablakot
	 * @param score - a pontszám
	 * @param images - a képek
	 */
	ScoreAdd(JFrame window, Integer score, ImageLoaded images){
		this.window=window;
		this.images=images;
		mf= new MyFont();
		f= mf.f;
		this.setLayout(null);
		tempscore=score;
		nameText = new JTextField("Player", 20);
		nameText.setEditable(true);
		nameText.setFont(f);
		this.add(nameText);
		nameText.setBounds(300, 200, 200, 30);
		
		saveButton= new JButton("Save");
		saveButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					kiir(nameText.getText(), tempscore);
					window.getContentPane().removeAll();
					new Menu(window, images);
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		this.add(saveButton);
		saveButton.setFont(f);
		saveButton.setOpaque(false);
        saveButton.setBorderPainted(false);
		saveButton.setFocusPainted(false);
        saveButton.setContentAreaFilled(false);
		saveButton.setBounds(300, 320, 200, 30);
		window.add(this);
		window.requestFocus();
		window.revalidate();
		file = new File(fileName);
		
		
	}
	
	/**
	 * kirajzolja a hátteret
	 */
public void paintComponent(Graphics g){
		
		
		super.paintComponent(g);
		g.drawImage(images.background , 0, 0, this);
		
		
		
		
}
	/**
	 * kiírja fájlba az eredményeket serializálással
	 * @param nev - játékos neve
	 * @param pont - játékos pontszáma
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void kiir(String nev, int pont) throws FileNotFoundException, IOException, ClassNotFoundException {

		if (!file.exists()) {
			file.createNewFile();
		}

		score = new Score(nev, pont);
		scores = new ArrayList<Score>();

		long size = file.length();

		if (size != 0) {
			ois = new ObjectInputStream(new FileInputStream(fileName));
			scores = (ArrayList<Score>) ois.readObject();
			ois.close();
		}

		scores.add(score);

		oos = new ObjectOutputStream(new FileOutputStream(fileName));
		oos.writeObject(scores);
		oos.close();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
