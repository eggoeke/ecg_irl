package ecg_irl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
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
	StartMenu menu;
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
		menu = new StartMenu();
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

		if (State == STATE.MENU)
			menu.render(g);

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
