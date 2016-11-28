package ecg_irl;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class MenuState extends GameState {
	boolean toggle;
	private String[] options = {"Stats", "Journal", "Quit"};
	private int currentSelection = 0;

	public MenuState(GameStateManager gsm){

		super(gsm);
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
			g.fillRect(Game.dimension/2 - Game.dimension/12, Game.dimension/2 - Game.dimension/6, Game.dimension/8, Game.dimension/8);
			for(int i = 0; i < options.length; i++) {

				if(i == currentSelection) {
					g.setColor(Color.GREEN);
				} else {
					g.setColor(Color.BLACK);
				}


				g.drawString(options[i], Game.dimension/2 - Game.dimension/12, Game.dimension/2 - Game.dimension/8 + i * 30);


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

				gsm.states.push(new StatsState(gsm));


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
