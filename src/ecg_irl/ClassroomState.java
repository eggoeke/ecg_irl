package ecg_irl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**The classroom state which the player enters once he enters a classroom.
 * 
 * 
 *
 */
public class ClassroomState extends GameState{
	public final Set<Integer> pressed = new HashSet<Integer>();
	private Player player;
	private Map map;
	private JPanel panel;
	private JFrame frame;
	private Game.SUBSTATE state;
	static boolean toggle;
	private BufferedImage finalBoss;
	boolean classcompleted;


	private MouseInputClassroom bListener;


	/**
	 * @wbp.parser.entryPoint
	 */
	public ClassroomState(GameStateManager gsm, Player player, Map map, JPanel panel, JFrame frame, Game.SUBSTATE state, MouseInputClassroom b) {
		super(gsm, player, map, panel, frame);
		this.map = map;
		this.player = player;
		this.panel = panel;
		this.frame = frame;
		this.state = state;
		toggle = true;
		this.bListener = b;
	}

	@Override
	public void init() {


	}

	@Override
	/**Moves player**/
	public void tick() {
		if(Game.subState == state){
			panel.addMouseListener(bListener);
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

		}else
			panel.removeMouseListener(bListener);

	}


	@Override
	public void draw(Graphics g) {



		if(Game.subState == state){
			map.drawMap(g, panel);
			player.drawPlayer(g, panel, frame);

			if (!classcompleted){
				Graphics2D g2d = (Graphics2D) g;
				/**Button to launch quiz**/
				
				Rectangle battleButton = new Rectangle(Game.dimension/2 +72, Game.dimension/2 - 50/2, 175, 50);
				g.setColor(Color.ORANGE);
				g.fillRect(Game.dimension/2 +72, Game.dimension/2- 50/2, 175, 50);
				Font font1 = new Font("Arial", Font.BOLD, 30);
				g.setFont(font1);
				g.setColor(Color.white);
				g.drawString("Start Quiz", battleButton.x + 15, battleButton.y + 34);
				g2d.draw(battleButton);

				if(Game.subState == Game.SUBSTATE.BAUMAN){
					ImageIcon chafic  = new ImageIcon("chafic.png"); 
					chafic.paintIcon(panel, g, Game.dimension/4 - map.x, Game.dimension/4 - map.y);
				}
			}
		}

	}
	public void complete(boolean boo){
		classcompleted = boo;
	}

	@Override
	public void keyPressed(int k) {



		pressed.add(k);
		if(Game.subState == state)
			if(k == KeyEvent.VK_R){
				toggle = false;
				Game.subState = Game.SUBSTATE.PLAY;
				Sound.sound1.loop();
			}
	}

	@Override
	public void keyReleased(int k) {
		pressed.remove(k);

	}



}
