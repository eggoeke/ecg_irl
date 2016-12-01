package ecg_irl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Game extends JPanel{

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	Player player;
	Map campusMap;
	StatsBar stats;
	static int dimension;

	public GameStateManager gsm;
	public BuildingManager bm;



	public static enum STATE{
		MENU,
		GAME
	};
	public static enum SUBSTATE{
		PLAY,
		STATSCREEN,
		BAUMAN,
		FRANK,
		DUKE,
		KING

	};
	public static enum RESTRICTEDX{
		LEFT,
		RIGHT,
		NONE
	};
	public static enum RESTRICTEDY{
		UP,
		DOWN,
		NONE
	}

	public static STATE State = STATE.MENU;
	public static SUBSTATE subState = SUBSTATE.PLAY;
	public static RESTRICTEDX restrictedX = RESTRICTEDX.NONE;
	public static RESTRICTEDY restrictedY = RESTRICTEDY.NONE;

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

		this.addMouseListener(new MouseInput());

		player = new Player();
		campusMap = new Map(player, "mapXL.png");
		gsm = new GameStateManager(player, campusMap, this, frame);
		bm = new BuildingManager(campusMap);
		stats = new StatsBar(player, frame, this);
	}

	public void step(){
		if(State == STATE.GAME)
			gsm.tick();
		if(subState == SUBSTATE.PLAY)
			bm.tick();
		else{
			restrictedX = RESTRICTEDX.NONE;
			restrictedY = RESTRICTEDY.NONE;
		}
	}



	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);

		if (State == STATE.MENU){
			Rectangle playButton = new Rectangle(Game.dimension/2 - 50 , 150, 100, 50);
			Rectangle helpButton = new Rectangle(Game.dimension/2 - 50, 250, 100, 50);
			Rectangle quitButton = new Rectangle(Game.dimension/2 - 50, 350, 100, 50);

			Graphics2D g2d = (Graphics2D) g;
			
			Font font = new Font("Arial", Font.BOLD, 50);
			g.setFont(font);
			g.setColor(Color.BLACK);
			g.drawString("ECG IRL", Game.dimension/3+55, 100);
			
			Font font1 = new Font("Arial", Font.BOLD, 30);
			g.setFont(font1);
			g.drawString("Start", playButton.x + 15, playButton.y + 34);
			g.drawString("Help", helpButton.x + 15, helpButton.y + 34);
			g.drawString("Quit", quitButton.x + 15, quitButton.y + 34);
			g2d.draw(playButton);
			g2d.draw(helpButton);
			g2d.draw(quitButton);
		}

		if(State == STATE.GAME){
			gsm.draw(g);


			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.ORANGE);
			g2.fill(new Ellipse2D.Double(0,0,frame.getWidth()/8,frame.getWidth()/8));
			g.setFont(new Font("Courier", Font.PLAIN, 60));
			g.setColor(Color.WHITE);
			g.drawString(Integer.toString(player.getLevel()), frame.getWidth()/22, frame.getHeight()/12);
		}
	}




	private class keyListener implements KeyListener{
		@Override
		public synchronized void keyPressed(KeyEvent e) {
			gsm.keyPressed(e.getKeyCode());
			if(subState == SUBSTATE.PLAY)
				bm.keyPressed(e.getKeyCode());
		}

		@Override
		public synchronized void keyReleased(KeyEvent e) {
			gsm.keyReleased(e.getKeyCode());
		}

		@Override
		public void keyTyped(KeyEvent e) {

		}
	}
}
