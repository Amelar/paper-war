package space;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyFont{
	
	Font f;
	/**
	 * Beolvassa az adott Font típust
	 */
	MyFont(){
	try {
		f = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("Font/OpenDyslexic-Italic.otf"))).deriveFont(Font.PLAIN, 24);
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (FontFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	
}
