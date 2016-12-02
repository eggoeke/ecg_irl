package ecg_irl;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class EndGameState extends GameState {
	Chafic chafic;
	public final Set<Integer> pressed = new HashSet<Integer>();
	private Player player;
	private Map map;
	private JPanel panel;
	private JFrame frame;


	public EndGameState(GameStateManager gsm, Player player, Map map, JPanel panel, JFrame frame) {
		super(gsm, player, map, panel, frame);
		this.map = map;
		this.player = player;
		this.panel = panel;
		this.frame = frame;
		this.chafic = chafic;

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		if(Game.subState == Game.SUBSTATE.ENDGAME){
			if(pressed.contains(KeyEvent.VK_SPACE)) player.setSpeed(2);
			else player.setSpeed(1);

			if(pressed.contains(KeyEvent.VK_W) && map.getY() <=0 && Game.restrictedY != Game.RESTRICTEDY.UP){
				player.moveUp();
				map.moveUp();
			}
			else if(pressed.contains(KeyEvent.VK_S) && map.getY() >= (-map.getMapHeight()+frame.getHeight()) && Game.restrictedY != Game.RESTRICTEDY.DOWN){
				player.moveDown();
				map.moveDown();
			}else{
				player.stopY();
			}

			if(pressed.contains(KeyEvent.VK_A) && map.getX() <=0 && Game.restrictedX != Game.RESTRICTEDX.LEFT){
				player.moveRight();
				map.moveRight();
			}
			else if(pressed.contains(KeyEvent.VK_D) && map.getX() >= (-map.getMapWidth()+frame.getWidth()) && Game.restrictedX != Game.RESTRICTEDX.RIGHT){
				player.moveLeft();
				map.moveLeft();
			}else{
				player.stopX();
			}
			
			if(chafic.getX()> player.getX() && chafic.getY()> player.getY()){
				chafic.setxMove(-1);
				chafic.setyMove(-1);
			}
			else if(chafic.getX()< player.getX() && chafic.getY()> player.getY()){
				chafic.setxMove(1);
				chafic.setyMove(-1);

			}
			else if(chafic.getY()> player.getY() && chafic.getX() == player.getX()){
				chafic.setxMove(0);
				chafic.setyMove(-1);
			}
			else if(chafic.getY() == player.getY() && chafic.getX()> player.getX()){
				chafic.setxMove(0);
				chafic.setyMove(1);
			}
			if(chafic.getX()> player.getX() && chafic.getY()< player.getY()){
				chafic.setxMove(-1);
				chafic.setyMove(1);
			}
			else if(chafic.getX()< player.getX() && chafic.getY()< player.getY()){
				chafic.setxMove(1);
				chafic.setyMove(1);
			}
			else if(chafic.getY() == player.getY() && chafic.getX() < player.getX()){
				chafic.setxMove(0);
				chafic.setyMove(1);
			}
			else if(chafic.getY()< player.getY() && chafic.getX() == player.getX()){
				chafic.setxMove(0);
				chafic.setyMove(1);
			}			
			

			chafic.tick();
			player.move();
			map.move();
		}
	}

	@Override
	public void draw(Graphics g) {

		// TODO Auto-generated method stub
		if(Game.subState == Game.SUBSTATE.ENDGAME){
			chafic.drawChafic(g, panel, frame);
			map.drawMap(g, panel);
			player.drawPlayer(g, panel, frame);
		}
	}

	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub
		pressed.add(k);

	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		pressed.remove(k);

	}

}
