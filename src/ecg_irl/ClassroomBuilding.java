package ecg_irl;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class ClassroomBuilding extends Building{
	Rectangle rect1, rect2;
	Map map;
	int x,y,tempX,tempY;
	boolean intersectedY, intersectedX;
	Game.SUBSTATE state;
	Rectangle player;
	long time;
	boolean timey;


	public ClassroomBuilding(Rectangle rect1, Map map, Game.SUBSTATE state) {
		super(rect1, map);
		this.rect1 = rect1;
		this.map = map;
		x = rect1.getLocation().x;
		y = rect1.getLocation().y;
		intersectedX = false;
		intersectedY = false;
		this.state = state;
		player = new Rectangle(Game.dimension/2 - 72/2, Game.dimension/2 - 104/2, 72, 104);
		time = System.currentTimeMillis();
		}

	@Override
	public void tick() {
		if(System.currentTimeMillis() >= time + 300){
			ClassroomState.toggle = true;
			time = System.currentTimeMillis() * 1000;
			timey = true;
		}
		else if(ClassroomState.toggle == false && timey){
			time = System.currentTimeMillis();
			timey = false;
		}
		
		if(Game.restrictedX == Game.RESTRICTEDX.NONE && Game.restrictedY == Game.RESTRICTEDY.NONE || intersectedX || intersectedY ){
			rect1.setLocation(x+map.getX(), y+map.getY());
			tempX = rect1.getLocation().x;
			tempY = rect1.getLocation().y;


			if(rect1.intersects(player)){
				if(player.getLocation().x +72 > tempX && player.getX() < tempX){
					Game.restrictedX = Game.RESTRICTEDX.RIGHT;
					intersectedX = true;
				}
				else if(player.getX() < tempX+rect1.width && player.getX() > tempX+rect1.width-player.width){
					Game.restrictedX = Game.RESTRICTEDX.LEFT;
					intersectedX = true;
				}
				else{
					Game.restrictedX = Game.RESTRICTEDX.NONE;
					intersectedX = false;
				}


				if((player.getY() < tempY+rect1.height)&& player.getY() > tempY+rect1.height-player.height){
					Game.restrictedY = Game.RESTRICTEDY.UP;
					intersectedY = true;
				}else if(player.getLocation().y +player.height > tempY && player.getY() < tempY){
					Game.restrictedY = Game.RESTRICTEDY.DOWN;
					intersectedY = true;
				}
				else{
					Game.restrictedY = Game.RESTRICTEDY.NONE;
					intersectedY = false;
				}
			}else{
				Game.restrictedX = Game.RESTRICTEDX.NONE;
				Game.restrictedY = Game.RESTRICTEDY.NONE;
				intersectedX = false;
				intersectedY = false;
			}
		}
	}

	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub
		if((k == KeyEvent.VK_R && rect1.intersects(player)) && ClassroomState.toggle){
			Game.subState = state;
		}
		

	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		
	}

}
