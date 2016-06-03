package space;

import java.io.Serializable;
import java.util.Comparator;

public class Score implements Serializable, Comparator<Score>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8829572847606597880L;
	String name;
	Integer score;
	
	/**
	 * Az eredm�nylista adatai
	 * @param nev - a neve a j�t�kosnak
	 * @param score - az el�rt pontsz�ma
	 */
	Score(String nev, Integer score) {
		if (nev.equals("")) {
			this.name = "Unnamed";
		} else {
			this.name = nev;
		}
		this.score = score;
	}
	/**
	 * �res Konstruktor
	 */
	Score(){}
	
	/**
	 * A sorbarendez�shez sz�ks�ges f�ggv�ny
	 */
	@Override
	public int compare(Score s1, Score s2) {
		Integer sp1 = (Integer) s1.score;
		Integer sp2 = (Integer) s2.score;
		return sp2.compareTo(sp1);
	}
	
}
