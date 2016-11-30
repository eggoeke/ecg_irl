package ecg_irl;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class PlayState extends GameState {
	public final Set<Integer> pressed = new HashSet<Integer>();
	private Player player;
	private Map map;
	private JPanel panel;
	private JFrame frame;

	public PlayState(GameStateManager gsm, Player player, Map map, JPanel panel, JFrame frame) {
		super(gsm, player, map, panel, frame);
		this.map = map;
		this.player = player;
		this.panel = panel;
		this.frame = frame;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
	}

	@Override
	public void tick() {
		if(Game.subState == Game.SUBSTATE.PLAY){
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
			player.move();
			map.move();
		}
	}

	@Override
	public void draw(Graphics g) {
		if(Game.subState == Game.SUBSTATE.PLAY){
			map.drawMap(g, panel);
			player.drawPlayer(g, panel, frame);
		}

	}

	@Override
	public void keyPressed(int k) {
		pressed.add(k);
	}

	@Override
	public void keyReleased(int k) {
		pressed.remove(k);

	}


}
