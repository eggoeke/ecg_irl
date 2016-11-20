package ecg_irl;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel{

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private ImageIcon map;
	private int mapX, mapY;
	private keyListener klisten = new keyListener();

	public Game(){
		frame = new JFrame();
		frame.add(this);
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		
		addKeyListener(klisten);
		
		map = new ImageIcon("map.png");
		mapX = 0;
		mapY = 0;

	}
	public void step(){
		
	}
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		
		map.paintIcon(this, g, mapX, mapY);
	}
}

class keyListener implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
}
