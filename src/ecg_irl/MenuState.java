package ecg_irl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MenuState extends GameState {
	boolean toggle;
	private String[] options = {"Stats", "Journal", "Quit"};
	private int currentSelection = 0;

	public MenuState(GameStateManager gsm, Player player, Map map, JPanel panel, JFrame frame){
		super(gsm, player, map, panel, frame);
	}

	@Override
	public void init() {
		toggle = false;

	}

	@Override
	public void tick() {

	}

	@Override
	public void draw(Graphics g) {
		if(toggle){
			g.setFont(new Font("Arial", Font.BOLD, 25));
			g.fillRect(Game.dimension/2 - Game.dimension/2, Game.dimension/7 -5, Game.dimension/7, Game.dimension/7);
			for(int i = 0; i < options.length; i++) {

				if(i == currentSelection) {
					g.setColor(Color.GREEN);
				} else {
					g.setColor(Color.BLACK);
				}


				g.drawString(options[i], Game.dimension/2 - Game.dimension/2, Game.dimension/2 - Game.dimension/3 + i * 30);



			}
		}
	}

	@Override
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_M && toggle != true)
			toggle = true;
		else if(k == KeyEvent.VK_M && toggle == true)
			toggle = false;

		if(k == KeyEvent.VK_DOWN) {
			currentSelection++;
			if(currentSelection >= options.length) {
				currentSelection = 0;
			}
		}else if(k == KeyEvent.VK_UP) {
			currentSelection--;
			if(currentSelection < 0){
				currentSelection = options.length - 1;
			}
		}

		if(k == KeyEvent.VK_ENTER) {
			if(currentSelection == 0){
				//stats

			}else if(currentSelection == 1){

			}else if(currentSelection == 2){
				System.exit(0);
			}
		}
	}

	@Override
	public void keyReleased(int k) {

	}

}
