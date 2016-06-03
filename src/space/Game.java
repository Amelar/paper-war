package space;



public class Game{
	/**
	 * A main függvény
	 * @param args
	 */
	public static void main(String[] args) {
		Frame game = new Frame();
		ImageLoaded images = new ImageLoaded();
		@SuppressWarnings("unused")
		Menu mainmenu = new Menu(game.window, images);
		}

	}
