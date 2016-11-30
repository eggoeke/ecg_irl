package ecg_irl;

import java.awt.Rectangle;
import java.util.ArrayList;

public class BuildingManager {
	public ArrayList<Building> buildings;
	
	public BuildingManager(Map map){
		buildings = new ArrayList<Building>();
		buildings.add(new OffLimitsBuilding(new Rectangle(780+60 + map.getX(), 290+95 +map.getY(), 300-65, 630-100), map));
	}
	public void tick(){
		for(int i = 0; i < buildings.size(); i++)
			buildings.get(i).tick();
	}

}
