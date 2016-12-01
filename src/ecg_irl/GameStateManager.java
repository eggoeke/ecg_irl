package ecg_irl;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class GameStateManager {


	public ArrayList<GameState> states;
	Map baumanMap, kingMap, dukeMap, frankMap;


	public GameStateManager(Player player, Map campusMap, JPanel panel, JFrame frame){

		baumanMap = new Map(player, "Bauman.png");
		kingMap = new Map(player, "King.png");
		dukeMap = new Map(player, "Duke.PNG");
		frankMap = new Map(player, "Frank.png");
		
		states = new ArrayList<GameState>();
		states.add(new PlayState(this, player, campusMap, panel, frame));
		states.add(new MenuState(this, player, campusMap, panel, frame));
		states.add(new StatsState(this, player, campusMap, panel, frame));
		states.add(new ClassroomState(this, player, baumanMap, panel, frame, Game.SUBSTATE.BAUMAN));
		states.add(new ClassroomState(this, player, kingMap, panel, frame, Game.SUBSTATE.KING));
		states.add(new ClassroomState(this, player, frankMap, panel, frame, Game.SUBSTATE.FRANK));
		states.add(new ClassroomState(this, player, dukeMap, panel, frame, Game.SUBSTATE.DUKE));




	}

	public void tick(){

		for(int i = 0; i < states.size(); i++)
			states.get(i).tick();

	}

	public void draw(Graphics g){
		for(int i = 0; i < states.size(); i++)
			states.get(i).draw(g);
	}

	public void keyPressed(int k){
		for(int i = 0; i < states.size(); i++)
			states.get(i).keyPressed(k);
	}

	public void keyReleased(int k){
		for(int i = 0; i < states.size(); i++)
			states.get(i).keyReleased(k);
	}
}
