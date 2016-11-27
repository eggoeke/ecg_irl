package ecg_irl;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel{

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	Player player;
	Map map;
    public final Set<Character> pressed = new HashSet<Character>();


	public Game(){
		frame = new JFrame();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);  
		frame.add(this);
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);

		setFocusable(true);

		keyListener klisten = new keyListener();
		addKeyListener(klisten);


		player = new Player();
		map = new Map(player);

	}
	public void step(){
		if(pressed.contains(' ')) player.setSpeed(2);
		else player.setSpeed(1);
		
		if(pressed.contains('w') && map.getY()!=0){
			player.moveUp();
			map.moveUp();
		}
		else if(pressed.contains('s') && map.getY() >= (-map.getMapHeight()+frame.getHeight())){
			player.moveDown();
			map.moveDown();
		}
		
		if(pressed.contains('a') && map.getX()!=0){
			player.moveRight();
			map.moveRight();
		}
		else if(pressed.contains('d') && map.getX() >= (-map.getMapWidth()+frame.getWidth())){
			player.moveLeft();
			map.moveLeft();
		}
		player.move();
		map.move();
	}
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		map.drawMap(g, this);
		player.drawPlayer(g, this, frame);
	}





	private class keyListener implements KeyListener{
		@Override
		public synchronized void keyPressed(KeyEvent e) {
			pressed.add(e.getKeyChar());
		}

		@Override
		public synchronized void keyReleased(KeyEvent e) {
			pressed.remove(e.getKeyChar());
			for(char c: pressed)
				System.out.println(c);
		}

		@Override
		public void keyTyped(KeyEvent e) {

		}
		

	}
}
