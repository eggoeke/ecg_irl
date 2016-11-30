package ecg_irl;

import java.awt.Rectangle;

public class OffLimitsBuilding extends Building {
	Rectangle rect1, rect2;
	Map map;

	public OffLimitsBuilding(Rectangle rect1, Rectangle rect2, Map map) {
		super(rect1,rect2, map);
		this.rect1 = rect1;
		if(rect2 != null)
			this.rect2=rect2;
		this.map = map;
	}

	@Override
	public void tick() {
		rect1.setLocation(rect1.getLocation().x+map.getX(), rect1.getLocation().y+map.getY());
		if(rect2 != null)
			rect2.setLocation(rect2.getLocation().x+map.getX(), rect2.getLocation().y+map.getY());

		if(rect1.getLocation().x == Game.dimension - 72/2|| rect2.getLocation().x == Game.dimension - 72/2){
			Game.restrictedX = Game.RESTRICTEDX.LEFT;
		} else if(rect1.getLocation().x +rect1.width == Game.dimension - 72/2|| rect2.getLocation().x +rect2.width == Game.dimension - 72/2){
			Game.restrictedX = Game.RESTRICTEDX.RIGHT;
		}else
			Game.restrictedX = Game.RESTRICTEDX.NONE;


		if(rect1.getLocation().y == Game.dimension - 104/2|| rect2.getLocation().y == Game.dimension - 104/2){
			Game.restrictedY = Game.RESTRICTEDY.DOWN;
		}if(rect1.getLocation().y + rect1.height == Game.dimension - 104/2 || rect2.getLocation().y +rect2.height == Game.dimension - 104/2){
			Game.restrictedY = Game.RESTRICTEDY.UP;
		}else
			Game.restrictedY = Game.RESTRICTEDY.NONE;

	}


	@Override
	public void keyPressed(int k) {

	}

	@Override
	public void keyReleased(int k) {

	}

}
