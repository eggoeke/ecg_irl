package ecg_irl;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel{

	private static final long serialVersionUID = 1L;
	public static int mapY, mapX;
	private JFrame frame;
	private ImageIcon map;

	public Game(){
		frame = new JFrame();
		frame.setVisible(true);  
		frame.add(this);
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		
		setFocusable(true);
		
		keyListener klisten = new keyListener();
		addKeyListener(klisten);
		
		
		mapX =0;
		mapY= 0;

	}
	public void step(){
		
	}
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		map = new ImageIcon("map.png");
		map.paintIcon(this, g, mapX, mapY);
	}
}




class keyListener implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == 'w' && Game.mapY!=0){
			Game.mapY+=5;
		}
		else if(e.getKeyChar() == 's'){
			Game.mapY-=5;
		}
		else if(e.getKeyChar() == 'a' && Game.mapX!=0){
			Game.mapX+=5;
		}
		else if(e.getKeyChar() == 'd'){
			Game.mapX-=5;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
}
