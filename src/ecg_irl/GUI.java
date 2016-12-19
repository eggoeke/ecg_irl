package ecg_irl;

/**Creates the threads to run the game and update position, states continuously**/

public class GUI {
	static GUI game;
	int TARGET_FPS, fps;

	public static void main(String[] arg){
		game = new GUI();
	}

	public GUI(){
		Game game = new Game();
		boolean isRunning = true;
		long lastLoopTime = System.nanoTime();
		TARGET_FPS = 100;
		fps = 0;
		long lastFpsTime = 0;

		while (isRunning) {
			long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
			long now = System.nanoTime();
			long updateLength = now - lastLoopTime;
			lastLoopTime = now;

			lastFpsTime += updateLength;
			fps++;

			if (lastFpsTime >= 1000000000) {
				lastFpsTime = 0;
				fps = 0;
			}
			
			game.step();
			game.repaint();
			
			try{
				Thread.sleep( (Math.max(0,Math.min(lastLoopTime,(lastLoopTime)-System.nanoTime() + OPTIMAL_TIME)/1000000 )));
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}

	}
}
