package ecg_irl;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class MouseInput implements MouseListener {

	private HelpFrame hFrame;
	
	public MouseInput(){
		
		
		hFrame = new HelpFrame("Help");
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();
		
		if(mx >= Game.dimension/2 - 50 && mx <= Game.dimension/2 + 50){
			if(my >= 150 && my <= 200)
			{
				
			}
			
		}
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();
		
		/*public Rectangle playButton = new Rectangle(Game.dimension/2 - 50 , 150, 100, 50);
		public Rectangle helpButton = new Rectangle(Game.dimension/2 - 50, 250, 100, 50);
		public Rectangle quitButton = new Rectangle(Game.dimension/2 - 50, 350, 100, 50);*/
		
		//PLAY BUTTON
		if(mx >= Game.dimension/2 - 50 && mx <= Game.dimension/2 + 50){
			if(my >= 150 && my <= 200)
			{
				Game.State = Game.STATE.GAME;
				Sound.sound1.loop();
			}
			
		}
		
		//HELP BUTTON
		if(mx >= Game.dimension/2 - 50 && mx <= Game.dimension/2 + 50){
			if(my >= 250 && my <= 300)
			{
				hFrame.setVisible(true);
			}
			
		}
		
		//QUIT BUTTON
		if(mx >= Game.dimension/2 - 50 && mx <= Game.dimension/2 + 50){
			if(my >= 350 && my <= 400)
			{
				System.exit(0);;
			}
			
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
