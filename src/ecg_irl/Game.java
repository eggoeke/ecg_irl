package ecg_irl;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel{

	private static final long serialVersionUID = 1L;
	public static int mapY=0, mapX=0;
	private JFrame frame;
	private ImageIcon map;
	private keyListener klisten = new keyListener();

	public Game(){
		frame = new JFrame();
		frame.setVisible(true);  
		frame.add(this);
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		
		addKeyListener(klisten);
		
		map = new ImageIcon("map.png");

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
		if(e.getKeyChar() == 'w')
			Game.mapY-= 1;
		else if(e.getKeyChar() == 's')
			Game.mapY+=1;
		else if(e.getKeyChar() == 'a')
			Game.mapX-=1;
		else if(e.getKeyChar() == 'd')
			Game.mapX+=1;
		
		
	}
	
}
