package ecg_irl;

import java.awt.Rectangle;

// TODO: Auto-generated Javadoc
/**
 * The Class Building.
 */
public abstract class Building {
	
	/**
	 * Instantiates a new building.
	 *
	 * @param rect1 the Rectangle image
	 * @param map the map
	 */
	public Building(Rectangle rect1, Map map){
	}
	
	/**
	 * Initializes the building.
	 */
	public void init() {
	}

	public abstract void tick();
	public abstract void keyPressed(int k);
	public abstract void keyReleased(int k);
	

}
