package ecg_irl;

import java.awt.Rectangle;
import java.util.ArrayList;

public class BuildingManager {
	public ArrayList<Building> buildings;
	
	public BuildingManager(Map map){
		buildings = new ArrayList<Building>();
		buildings.add(new OffLimitsBuilding(new Rectangle(780 + map.getX(), 290 +map.getY(), 300, 630), null, map));
	}
	public void tick(){
		for(int i = 0; i < buildings.size(); i++)
			buildings.get(i).tick();
	}

}
