package ecg_irl;

import java.awt.Rectangle;

public abstract class Building {
	
	public Building(Rectangle rect1, Map map){
	}
	public void init() {
	}
	public abstract void tick();
	public abstract void keyPressed(int k);
	public abstract void keyReleased(int k);

}
