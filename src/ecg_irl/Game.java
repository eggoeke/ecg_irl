package ecg_irl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel{

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	Player player;
	Map map;
	StatsBar stats;
    public final Set<Character> pressed = new HashSet<Character>();
    int dimension;


	public Game(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) screenSize.getHeight();
		int width = (int) screenSize.getWidth();
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);  
		frame.add(this);
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for(int i = 0; (height-100) > i; i+=50)
			dimension = i;
		frame.setSize(dimension, dimension);
		frame.setLocation(width/2 - dimension/2, height/2 - dimension/2);
		setFocusable(true);

		keyListener klisten = new keyListener();
		addKeyListener(klisten);


		player = new Player();
		map = new Map(player);
		stats = new StatsBar(player, frame, this);
		
	}
	
	public void step(){
		if(pressed.contains(' ')) player.setSpeed(2);
		else player.setSpeed(1);
		
		if(pressed.contains('w') && map.getY() <=0){
			player.moveUp();
			map.moveUp();
		}
		else if(pressed.contains('s') && map.getY() >= (-map.getMapHeight()+frame.getHeight())){
			player.moveDown();
			map.moveDown();
		}else{
			player.stopY();
		}
		
		if(pressed.contains('a') && map.getX() <=0){
			player.moveRight();
			map.moveRight();
		}
		else if(pressed.contains('d') && map.getX() >= (-map.getMapWidth()+frame.getWidth())){
			player.moveLeft();
			map.moveLeft();
		}else{
			player.stopX();
		}
		player.move();
		map.move();
	}
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		map.drawMap(g, this);
		player.drawPlayer(g, this, frame);
		
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.ORANGE);
		g2.fill(new Ellipse2D.Double(0,0,frame.getWidth()/8,frame.getWidth()/8));
		g.setFont(new Font("Courier", Font.PLAIN, 60));
		g.setColor(Color.WHITE);
		g.drawString(Integer.toString(player.getLevel()), frame.getWidth()/22, frame.getHeight()/12);
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
