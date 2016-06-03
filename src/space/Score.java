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
	 * Az eredménylista adatai
	 * @param nev - a neve a játékosnak
	 * @param score - az elért pontszáma
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
	 * Üres Konstruktor
	 */
	Score(){}
	
	/**
	 * A sorbarendezéshez szükséges függvény
	 */
	@Override
	public int compare(Score s1, Score s2) {
		Integer sp1 = (Integer) s1.score;
		Integer sp2 = (Integer) s2.score;
		return sp2.compareTo(sp1);
	}
	
}
