package ecg_irl;

import java.awt.Rectangle;
import java.util.ArrayList;

public class BuildingManager {
	public ArrayList<Building> buildings;
	static boolean[] intersectX, intersectY;
	boolean intersectedX, intersectedY;

	public BuildingManager(Map map){
		buildings = new ArrayList<Building>();
		
		/**Sets the bounds for each of the buildings on the map**/
		
		buildings.add(new ClassroomBuilding(new Rectangle(1727 + map.getX(),2810 +map.getY(), 310, 190), map, Game.SUBSTATE.DUKE));
		buildings.add(new ClassroomBuilding(new Rectangle(1270 + map.getX(),2000 +map.getY(), 350, 321), map, Game.SUBSTATE.KING));
		buildings.add(new ClassroomBuilding(new Rectangle(1412 +65+ map.getX(), 450 +100 +map.getY(), 240-65, 330-100), map, Game.SUBSTATE.BAUMAN));
		buildings.add(new ClassroomBuilding(new Rectangle(1380 + map.getX(),665 +map.getY(), 350, 155), map, Game.SUBSTATE.BAUMAN));
		buildings.add(new ClassroomBuilding(new Rectangle(780+60 + map.getX(), 290+95 +map.getY(), 300-65, 630-100), map, Game.SUBSTATE.FRANK));
		buildings.add(new OffLimitsBuilding(new Rectangle(942 + map.getX(),1109 +map.getY(), 500, 180),map));
		buildings.add(new OffLimitsBuilding(new Rectangle(1130  + map.getX(),1263 +map.getY(), 120, 200),map));
		buildings.add(new OffLimitsBuilding(new Rectangle(852  + map.getX(),1740 +map.getY(), 335, 120), map));
		buildings.add(new OffLimitsBuilding(new Rectangle(970  + map.getX(),1620 +map.getY(), 100, 200),map));
		buildings.add(new OffLimitsBuilding(new Rectangle(1611  + map.getX(),1240 +map.getY(), 300, 135),map));
		buildings.add(new OffLimitsBuilding(new Rectangle(2250  + map.getX(),720 +map.getY(), 100, 100),map));
		buildings.add(new OffLimitsBuilding(new Rectangle(1950  + map.getX(),462 +map.getY(), 300, 150),map));
		buildings.add(new OffLimitsBuilding(new Rectangle(1342  + map.getX(),1639 +map.getY(), 300, 140),map));
		buildings.add(new OffLimitsBuilding(new Rectangle(1500 + map.getX(),1560 +map.getY(), 111, 315),map));
		buildings.add(new OffLimitsBuilding(new Rectangle(1023 + map.getX(),2460 +map.getY(), 600, 345),map));

	}

	public void tick(){
		if(Game.subState == Game.SUBSTATE.PLAY)
			for(int i = 0; i < buildings.size(); i++)
				buildings.get(i).tick();
		else{
			Game.restrictedX = Game.RESTRICTEDX.NONE;
			Game.restrictedY = Game.RESTRICTEDY.NONE;
		}

	}
	public void keyPressed(int k){
		for(int i = 0; i < buildings.size(); i++)
			buildings.get(i).keyPressed(k);
	}


}
