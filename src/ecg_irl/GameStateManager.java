package ecg_irl;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**Manages each of the states**/

public class GameStateManager {


	public ArrayList<GameState> states;
	Map baumanMap, kingMap, dukeMap, frankMap;
	MouseInputClassroom b, f, d, k;
	ClassroomState ba, fr, du, ki;


	public GameStateManager(Player player, Map campusMap, JPanel panel, JFrame frame){

		b = new MouseInputClassroom(Game.SUBSTATE.BATTLEBAUMAN);
		d = new MouseInputClassroom(Game.SUBSTATE.BATTLEDUKE);
		f = new MouseInputClassroom(Game.SUBSTATE.BATTLEFRANK);
		k = new MouseInputClassroom(Game.SUBSTATE.BATTLEKING);

		baumanMap = new Map(player, "Bauman.png");
		kingMap = new Map(player, "King.png");
		dukeMap = new Map(player, "Duke.PNG");
		frankMap = new Map(player, "Frank.png");
		
		ba = new ClassroomState(this, player, baumanMap, panel, frame, Game.SUBSTATE.BAUMAN, b);
		du = new ClassroomState(this, player, dukeMap, panel, frame, Game.SUBSTATE.DUKE, d);
		fr =new ClassroomState(this, player, frankMap, panel, frame, Game.SUBSTATE.FRANK, f);
		ki =new ClassroomState(this, player, kingMap, panel, frame, Game.SUBSTATE.KING, k);
		
		states = new ArrayList<GameState>();
		states.add(new PlayState(this, player, campusMap, panel, frame));
		states.add(new MenuState(this, player, campusMap, panel, frame));
		states.add(new StatsState(this, player, campusMap, panel, frame));
		states.add(new JournalState(this, player, campusMap, panel, frame));
		states.add(ba);
		states.add(ki);
		states.add(fr);
		states.add(du);
		states.add(new BattleState(this, player, baumanMap, panel, frame, Game.SUBSTATE.BATTLEBAUMAN, Game.SUBSTATE.BAUMAN, ba));
		states.add(new BattleState(this, player, dukeMap, panel, frame, Game.SUBSTATE.BATTLEDUKE, Game.SUBSTATE.DUKE, du));
		states.add(new BattleState(this, player, kingMap, panel, frame, Game.SUBSTATE.BATTLEKING, Game.SUBSTATE.KING, ki));
		states.add(new BattleState(this, player, frankMap, panel, frame, Game.SUBSTATE.BATTLEFRANK, Game.SUBSTATE.FRANK, fr));


	}

	public void tick(){

		for(int i = 0; i < states.size(); i++)
			states.get(i).tick();

		if(ba.classcompleted && ki.classcompleted && fr.classcompleted && du.classcompleted){
			Game.subState = Game.SUBSTATE.ENDGAME;
		}
	}

	public void draw(Graphics g){
		for(int i = 0; i < states.size(); i++)
			states.get(i).draw(g);
	}

	public void keyPressed(int k){
		for(int i = 0; i < states.size(); i++)
			states.get(i).keyPressed(k);
	}

	public void keyReleased(int k){
		for(int i = 0; i < states.size(); i++)
			states.get(i).keyReleased(k);
	}
}
