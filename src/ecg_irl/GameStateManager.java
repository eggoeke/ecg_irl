package ecg_irl;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class GameStateManager {


	public ArrayList<GameState> states;


	public GameStateManager(Player player, Map map, JPanel panel, JFrame frame){

		states = new ArrayList<GameState>();
		states.add(new PlayState(this, player, map, panel, frame));
		states.add(new MenuState(this, player, map, panel, frame));
		states.add(new StatsState(this, player, map, panel, frame));


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
