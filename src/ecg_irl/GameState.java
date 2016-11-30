package ecg_irl;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public abstract class GameState {
	
	protected GameStateManager gsm;
	
	public GameState(GameStateManager gsm, Player player, Map map, JPanel panel, JFrame frame){
		
		this.gsm = gsm;
		init();
		
	}
	
	public abstract void init();
	public abstract void tick();
	public abstract void draw(Graphics g);
	public abstract void keyPressed(int k);
	public abstract void keyReleased(int k);


	

	
	

}
