package ecg_irl;

import java.awt.Rectangle;
import java.util.ArrayList;

public class BuildingManager {
	public ArrayList<Building> buildings;
	static boolean[] intersectX, intersectY;
	boolean intersectedX, intersectedY;
	
	public BuildingManager(Map map){
		buildings = new ArrayList<Building>();
		buildings.add(new OffLimitsBuilding(new Rectangle(780+60 + map.getX(), 290+95 +map.getY(), 300-65, 630-100), map));
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
		for(int i = 0; i < buildings.size(); i++)
			buildings.get(i).tick();
	}

}
