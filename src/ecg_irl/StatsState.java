package ecg_irl;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StatsState extends GameState{

	public StatsState(GameStateManager gsm, Player player, Map map, JPanel panel, JFrame frame) {
		super(gsm, player, map, panel, frame);

	}

	@Override
	public void init() {


	}

	@Override
	public void tick() {


	}

	@Override
	public void keyPressed(int k) {


	}

	@Override
	public void keyReleased(int k) {


	}

	public void drawStats(Graphics g, JPanel panel) {






	}

	@Override
	public void draw(Graphics g) {
		if(Game.subState == Game.SUBSTATE.STATSCREEN){
			g.fillRect(0, 0, Game.dimension, Game.dimension);
		}

	}


}
