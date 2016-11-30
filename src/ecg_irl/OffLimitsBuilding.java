package ecg_irl;

import java.awt.Rectangle;

public class OffLimitsBuilding extends Building {
	Rectangle rect1, rect2;
	Map map;
	int x,y,tempX,tempY;

	public OffLimitsBuilding(Rectangle rect1, Map map) {
		super(rect1, map);
		this.rect1 = rect1;
		this.map = map;
		x = rect1.getLocation().x;
		y = rect1.getLocation().y;
	}

	@Override
	public void tick() {
		rect1.setLocation(x+map.getX(), y+map.getY());
		tempX = rect1.getLocation().x;
		tempY = rect1.getLocation().y;


		Rectangle player = new Rectangle(Game.dimension/2 - 72/2, Game.dimension/2 - 104/2, 72, 104);
		if(rect1.intersects(player)){
			System.out.println(tempX+" "+player.getX()+" "+" "+rect1.width+" "+(player.getX()>(tempX+rect1.width-79)));
			if(player.getLocation().x +72 >= tempX && player.getX() < tempX)
				Game.restrictedX = Game.RESTRICTEDX.RIGHT;
			else if(player.getX() <= tempX+rect1.width && player.getX() > tempX+rect1.width-player.width)
				Game.restrictedX = Game.RESTRICTEDX.LEFT;
			else
				Game.restrictedX = Game.RESTRICTEDX.NONE;

			if((player.getY() + 104 >= tempY) ){
				Game.restrictedY = Game.RESTRICTEDY.UP;
			}
			else
				Game.restrictedY = Game.RESTRICTEDY.NONE;
		}else{
			Game.restrictedX = Game.RESTRICTEDX.NONE;
			Game.restrictedY = Game.RESTRICTEDY.NONE;
		}
	}


	@Override
	public void keyPressed(int k) {

	}

	@Override
	public void keyReleased(int k) {

	}

}
