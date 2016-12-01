package ecg_irl;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClassroomState extends GameState{
	public final Set<Integer> pressed = new HashSet<Integer>();
	private Player player;
	private Map map;
	private JPanel panel;
	private JFrame frame;
	private Game.SUBSTATE state;
	static boolean toggle;


	public ClassroomState(GameStateManager gsm, Player player, Map map, JPanel panel, JFrame frame, Game.SUBSTATE state) {
		super(gsm, player, map, panel, frame);
		this.map = map;
		this.player = player;
		this.panel = panel;
		this.frame = frame;
		this.state = state;
		toggle = true;
	}

	@Override
	public void init() {

	}

	@Override
	public void tick() {
		if(Game.subState == state){
			if(pressed.contains(KeyEvent.VK_SPACE)) player.setSpeed(2);
			else player.setSpeed(1);

			if(pressed.contains(KeyEvent.VK_W) && map.getY() <= map.mapHeight/2 - 104 -20){
				player.moveUp();
				map.moveUp();
			}
			else if(pressed.contains(KeyEvent.VK_S) && map.getY() >= (-3*map.getMapHeight()/2+frame.getHeight())+104+20){
				player.moveDown();
				map.moveDown();
			}else{
				player.stopY();
			}

			if(pressed.contains(KeyEvent.VK_A) && map.getX() <= map.getMapWidth()/3 - 94 ){
				player.moveRight();
				map.moveRight();
			}
			else if(pressed.contains(KeyEvent.VK_D) && map.getX() >= (-4*map.getMapWidth()/3 +frame.getWidth())+94){
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
		if(Game.subState == state){
			map.drawMap(g, panel);
			player.drawPlayer(g, panel, frame);
		}

	}

	@Override
	public void keyPressed(int k) {
		pressed.add(k);
		if(Game.subState == state)
			if(k == KeyEvent.VK_SHIFT){
				toggle = false;
				Game.subState = Game.SUBSTATE.PLAY;
			}
	}

	@Override
	public void keyReleased(int k) {
		pressed.remove(k);

	}


}
