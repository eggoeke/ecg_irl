package ecg_irl;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInputClassroom implements MouseListener {
	Game.SUBSTATE state;
	
	public MouseInputClassroom(Game.SUBSTATE state){
		this.state = state;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();
		
	
		//PLAY BUTTON
		if(mx >= Game.dimension/2 +100  && mx <= Game.dimension/2 +300){
			if(my >= Game.dimension/2 - 50/2 && my <= Game.dimension/2 -50/2 + 50 )
			{
				Game.subState = state;
				Sound.sound2.loop();
			}
			
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
