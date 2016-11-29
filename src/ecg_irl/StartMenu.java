package ecg_irl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class StartMenu {

	public Rectangle playButton = new Rectangle(Game.dimension/2 - 50 , 150, 100, 50);
	public Rectangle helpButton = new Rectangle(Game.dimension/2 - 50, 250, 100, 50);
	public Rectangle quitButton = new Rectangle(Game.dimension/2 - 50, 350, 100, 50);
	
	public void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		
		Font font = new Font("Arial", Font.BOLD, 50);
		g.setFont(font);
		g.setColor(Color.BLACK);
		g.drawString("ECG IRL", Game.dimension/3+55, 100);
		
		Font font1 = new Font("Arial", Font.BOLD, 30);
		g.setFont(font1);
		g.drawString("Start", playButton.x + 15, playButton.y + 34);
		g.drawString("Help", helpButton.x + 15, helpButton.y + 34);
		g.drawString("Quit", quitButton.x + 15, quitButton.y + 34);
		g2d.draw(playButton);
		g2d.draw(helpButton);
		g2d.draw(quitButton);
	}
	
}
