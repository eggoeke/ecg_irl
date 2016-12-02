package ecg_irl;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JournalState extends GameState {

	public JournalState(GameStateManager gsm, Player player, Map map, JPanel panel, JFrame frame) {
		super(gsm, player, map, panel, frame);
	}

	@Override
	public void init() {


	}

	@Override
	public void tick() {


	}

	public void drawJournal(Graphics g){

		//g.setColor(Color.BLACK);
		//g.fillRect(0, 0, Game.dimension, Game.dimension);
		g.drawString("JOURNAL ENTRIES uh... who takes notes? LEL \n:):):):):):):):):):):):):):):):):):)"
				+ "\n:):):):):):):):):):):):):):):):):):) ", Game.dimension/10 , Game.dimension/10);

	}

	@Override
	public void draw(Graphics g) {
		if(Game.subState == Game.SUBSTATE.JOURNALSCREEN)
			drawJournal(g);

	}

	@Override
	public void keyPressed(int k) {


	}

	@Override
	public void keyReleased(int k) {


	}

}
