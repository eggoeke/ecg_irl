package ecg_irl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BattleState extends GameState{
	private Player player;
	private Map map;
	private JPanel panel;
	private JFrame frame;
	private Game.SUBSTATE state, stateClass;
	int i = 0;
	boolean toggle, init, toggle2, correct, incorrect;
	String[] questions = new String[10];
	String[] answers = new String[10];
	String[][] decoyAnswers = new String[10][4];
	ArrayList<Integer> index = new ArrayList<Integer>();
	ArrayList<Integer> indexAnswers = new ArrayList<Integer>();
	private BufferedImage paper = null;
	ClassroomState c;


	public BattleState(GameStateManager gsm, Player player, Map map, JPanel panel, JFrame frame, Game.SUBSTATE sub, Game.SUBSTATE stateClass, ClassroomState c) {
		super(gsm, player, map, panel, frame);
		this.map = map;
		this.player = player;
		this.panel = panel;
		this.frame = frame;
		this.state = sub;
		toggle = true;
		toggle2 = true;
		init();
		this.stateClass = stateClass;
		this.c = c;

		index.add(0);
		index.add(1);
		index.add(2);
		index.add(3);
		index.add(4);
		index.add(5);
		index.add(6);
		index.add(7);
		index.add(8);
		index.add(9);

		correct = false;
		incorrect = false;



	}

	@Override
	public void init() {



		if(state == Game.SUBSTATE.BATTLEBAUMAN){
			//questions
			questions[0] ="Which company was behind the creation of Java?";
			questions[1] ="What was the original name for Java?";
			questions[2] ="What is the name of the inventor (or father) of Java?";
			questions[3] ="Java code that is embedded as a small application in a web page is called a(n)...?";
			questions[4] ="Java can run on any computer platform that has a ...?";
			questions[5] ="The Java API intended for business and server 3-tier applications is called?";
			questions[6] ="What does AWT stand for?";
			questions[7] ="Which of the following keywords are found in Java but not in C++?";
			questions[8] ="Which of the following keywords are in C++ but not in Java?";
			questions[9] ="What is the name of the class that all Java classes inherit (directly or indirectly) from?";

			answers[0] ="Sun Microsystems";
			answers[1] ="Oak";
			answers[2] ="James Gosling";
			answers[3] ="Applet";
			answers[4] ="Java Virtual Machine";
			answers[5] ="Java 2, Enterprise Edition";
			answers[6] ="Abstract Window Toolkit";
			answers[7] ="final";
			answers[8] ="virtual";
			answers[9] ="ClassLoader";

			//DO NOT CHANGE THE ""
			//decoys for question1
			decoyAnswers[0][0] = "Apple";
			decoyAnswers[0][1] = "Microsoft";
			decoyAnswers[0][2] = "";
			decoyAnswers[0][3] = "Borland";

			//decoys for question2
			decoyAnswers[1][0] = "";
			decoyAnswers[1][1] = "Ada";
			decoyAnswers[1][2] = "C++";
			decoyAnswers[1][3] = "Lisp";

			//decoys for question3
			decoyAnswers[2][0] = "Dennis Ritchie";
			decoyAnswers[2][1] = "Bill Gates";
			decoyAnswers[2][2] = "Bjarne Stroustroup";
			decoyAnswers[2][3] = "";

			//decoys for question4
			decoyAnswers[3][0] = "Servlet";
			decoyAnswers[3][1] = "";
			decoyAnswers[3][2] = "JSP";
			decoyAnswers[3][3] = "Javabean";

			//decoys for question5
			decoyAnswers[4][0] = "Java compiler";
			decoyAnswers[4][1] = "Intel Pentium";
			decoyAnswers[4][2] = "";
			decoyAnswers[4][3] = "Linux OS";

			//decoys for question6
			decoyAnswers[5][0] = "";
			decoyAnswers[5][1] = "Java 2 Servlets";
			decoyAnswers[5][2] = "Java 2, Standard Edition";
			decoyAnswers[5][3] = "JavaMail";

			//decoys for question7
			decoyAnswers[6][0] = "Apple-Windows Technology";
			decoyAnswers[6][1] = "Abstract Widget Transfer";
			decoyAnswers[6][2] = "";
			decoyAnswers[6][3] = "All Windows Titles";

			//decoys for question8
			decoyAnswers[7][0] = "void";
			decoyAnswers[7][1] = "";
			decoyAnswers[7][2] = "int";
			decoyAnswers[7][3] = "static";

			//decoys for question9
			decoyAnswers[8][0] = "goto";
			decoyAnswers[8][1] = "class";
			decoyAnswers[8][2] = "float";
			decoyAnswers[8][3] = "";

			//decoys for question10
			decoyAnswers[9][0] = "";
			decoyAnswers[9][1] = "Object";
			decoyAnswers[9][2] = "Class";
			decoyAnswers[9][3] = "none of the above";


		}
		else if(state == Game.SUBSTATE.BATTLEDUKE){
			questions[0] = "When did East Germany and West Germany unite?";
			questions[1] ="Who won 1990 Football World Cup?";
			questions[2] ="Who won Wimbledon Men’s Singles Title in 1991?";
			questions[3] ="Who won Wimbledon Women’s Singles Title in 1991?";
			questions[4] ="How was Adolf Hitler known?";
			questions[5] ="In which Olympics Israelis were killed?";
			questions[6] ="Who followed the policy of Blood and Iron?";
			questions[7] ="Which was the capital of West Germany?";
			questions[8] ="Who spent many years in Spandau prison?";
			questions[9] ="Who began Reformation in the 16th century?";

			answers[0] ="1990";
			answers[1] ="West Germany";
			answers[2] ="Michael Stich";
			answers[3] ="Steffi Graf";
			answers[4] ="Fuehrer";
			answers[5] ="Munich";
			answers[6] ="Otto von Bismark";
			answers[7] ="Bonn";
			answers[8] ="Heinrich Himmler";
			answers[9] ="Martin Luther";

			//DO NOT CHANGE THE ""
			//decoys for question1
			decoyAnswers[0][0] = "1986";
			decoyAnswers[0][1] = "1994";
			decoyAnswers[0][2] = "";
			decoyAnswers[0][3] = "2000";

			//decoys for question2
			decoyAnswers[1][0] = "";
			decoyAnswers[1][1] = "East Germany";
			decoyAnswers[1][2] = "Brazil";
			decoyAnswers[1][3] = "Italy";

			//decoys for question3
			decoyAnswers[2][0] = "Boris Becker";
			decoyAnswers[2][1] = "John McEnroe";
			decoyAnswers[2][2] = "Jimmy Connors";
			decoyAnswers[2][3] = "";

			//decoys for question4
			decoyAnswers[3][0] = "Anke Huber";
			decoyAnswers[3][1] = "";
			decoyAnswers[3][2] = "Arantxa Sanchez";
			decoyAnswers[3][3] = "Monica Seles";

			//decoys for question5
			decoyAnswers[4][0] = "Czar";
			decoyAnswers[4][1] = "Kaiser";
			decoyAnswers[4][2] = "";
			decoyAnswers[4][3] = "Duce";

			//decoys for question6
			decoyAnswers[5][0] = "";
			decoyAnswers[5][1] = "Berlin";
			decoyAnswers[5][2] = "Montreal";
			decoyAnswers[5][3] = "Sydney";

			//decoys for question7
			decoyAnswers[6][0] = "Helmut Kohl";
			decoyAnswers[6][1] = "Willy Brandt";
			decoyAnswers[6][2] = "";
			decoyAnswers[6][3] = "Gerhard Shroeder";

			//decoys for question8
			decoyAnswers[7][0] = "Prague";
			decoyAnswers[7][1] = "";
			decoyAnswers[7][2] = "Vienna";
			decoyAnswers[7][3] = "Frankfurt";

			//decoys for question9
			decoyAnswers[8][0] = "Paul Joseph Goebbels";
			decoyAnswers[8][1] = "Rudolf Hess";
			decoyAnswers[8][2] = "Erwin Rommel";
			decoyAnswers[8][3] = "";

			//decoys for question10
			decoyAnswers[9][0] = "";
			decoyAnswers[9][1] = "Nestorius";
			decoyAnswers[9][2] = "John Wesley";
			decoyAnswers[9][3] = "William Booth";

		}
		else if(state == Game.SUBSTATE.BATTLEFRANK){
			questions[0] ="One of the largest land carnivores of all time, on which continent did the Tyrannosaurus Rex once live?";
			questions[1] ="Although its development was achieved with the work of many scientists, who is generally regarded as the chief inventor of the television?";
			questions[2] ="The malleable metal alloy pewter is made from which of the following?";
			questions[3] ="The fifth planet from the Sun, which planet can be found between Mars and Saturn in our Solar System?";
			questions[4] ="Which well-known English theoretical physicist suffers from a motor neuron disease, which leaves him almost entirely paralysed?";
			questions[5] ="Ascorbic acid is a vitamin which most of us consume every day. By what name is ascorbic acid better known?";
			questions[6] ="What unit of measurement do we use to measure electrical current?";
			questions[7] ="Having written close to 500 books, what science fiction writer wrote the three laws of robotics?";
			questions[8] ="What is the colored part of your eye that controls how much light passes through your pupil called?";
			questions[9] ="Most flowers contain a male reproductive organ called the 'stamen' and a female organ called?";

			answers[0] ="North America";
			answers[1] ="John Logie Baird";
			answers[2] ="Copper, Antimony, Bismuth and Tin";
			answers[3] ="Jupiter";
			answers[4] ="Stephen Hawking";
			answers[5] ="Vitamin C";
			answers[6] ="Amperes";
			answers[7] ="Isaac Asimov";
			answers[8] ="Iris";
			answers[9] ="Stigma";

			//DO NOT CHANGE THE ""
			//decoys for question1
			decoyAnswers[0][0] = "Asia";
			decoyAnswers[0][1] = "South America";
			decoyAnswers[0][2] = "";
			decoyAnswers[0][3] = "Africa";

			//decoys for question2
			decoyAnswers[1][0] = "";
			decoyAnswers[1][1] = "Charles Babbage";
			decoyAnswers[1][2] = "Alexander Graham Bell";
			decoyAnswers[1][3] = "Charles Francis Jenkins";

			//decoys for question3
			decoyAnswers[2][0] = "Copper and Bronze";
			decoyAnswers[2][1] = "Copper, Gold and Tin";
			decoyAnswers[2][2] = "Lead and Bronze";
			decoyAnswers[2][3] = "";

			//decoys for question4
			decoyAnswers[3][0] = "Venus";
			decoyAnswers[3][1] = "";
			decoyAnswers[3][2] = "Earth";
			decoyAnswers[3][3] = "Mercury";

			//decoys for question5
			decoyAnswers[4][0] = "Leonard Mlodinow";
			decoyAnswers[4][1] = "Richard Dawkins";
			decoyAnswers[4][2] = "";
			decoyAnswers[4][3] = "Carl Sagan";

			//decoys for question6
			decoyAnswers[5][0] = "";
			decoyAnswers[5][1] = "Vitamin D";
			decoyAnswers[5][2] = "Vitamin A";
			decoyAnswers[5][3] = "Vitamin B";

			//decoys for question7
			decoyAnswers[6][0] = "Resistors";
			decoyAnswers[6][1] = "Capacitors";
			decoyAnswers[6][2] = "";
			decoyAnswers[6][3] = "Volts";

			//decoys for question8
			decoyAnswers[7][0] = "Douglas Adams";
			decoyAnswers[7][1] = "";
			decoyAnswers[7][2] = "H. G. Wells";
			decoyAnswers[7][3] = "Ray Bradbury";

			//decoys for question9
			decoyAnswers[8][0] = "Cornea";
			decoyAnswers[8][1] = "Lens";
			decoyAnswers[8][2] = "Pupil ";
			decoyAnswers[8][3] = "";

			//decoys for question10
			decoyAnswers[9][0] = "";
			decoyAnswers[9][1] = "Sepal";
			decoyAnswers[9][2] = "Peduncle";
			decoyAnswers[9][3] = "Pistil";

		}
		else if(state == Game.SUBSTATE.BATTLEKING){
			questions[0] ="A large increase in the number of fast-food restaurants in a community is most likely to result in: ";
			questions[1] ="A person who starts a business to produce a new product in the marketplace is known as: ";
			questions[2] ="An increase from 5% to 8% in the interest rates charged by banks would most likely encourage: ";
			questions[3] ="For most people, the largest portion of their personal income comes from: ";
			questions[4] ="If the real gross domestic product of the United States has increased, but the production of goods has remained the same, then the production of services has";
			questions[5] ="If the price of beef doubled and the price of poultry stayed the same, people would most likely buy";
			questions[6] ="If the United States stopped importing automobiles from Country X, who would be most likely to benefit? ";
			questions[7] ="If your city government sets a maximum amount landlords can charge in rent, what is the most likely result? ";
			questions[8] ="In the United States, who determines what goods and services should be produced?";
			questions[9] ="Mexico grows fruits and vegetables and Argentina produces beef. If Mexico voluntarily trades fruits and vegetables in exchange for Argentinean beef, ";

			answers[0] ="Lower prices and higher quality.";
			answers[1] ="An entrepreneur.";
			answers[2] ="People to save money.";
			answers[3] ="Wages and salaries from their jobs.";
			answers[4] ="Increased";
			answers[5] ="More poultry and less beef.";
			answers[6] ="Automobile manufacturers in the United States";
			answers[7] ="There will be fewer apartments available than people want to rent.";
			answers[8] ="Producers, consumers, and government";
			answers[9] =" Both Mexico and Argentina benefit from the trade";

			//DO NOT CHANGE THE ""
			//DO NOT CHANGE THE ""
			//decoys for question1
			decoyAnswers[0][0] = "Lower prices and lower quality.";
			decoyAnswers[0][1] = "Higher prices and higher quality.";
			decoyAnswers[0][2] = "";
			decoyAnswers[0][3] = "Higher prices and lower quality";

			//decoys for question2
			decoyAnswers[1][0] = "";
			decoyAnswers[1][1] = "A manager.";
			decoyAnswers[1][2] = "A bureaucrat.";
			decoyAnswers[1][3] = "A nerd";

			//decoys for question3
			decoyAnswers[2][0] = "Businesses to invest.";
			decoyAnswers[2][1] = "People to purchase housing.";
			decoyAnswers[2][2] = "People to break down crying";
			decoyAnswers[2][3] = "";

			//decoys for question4
			decoyAnswers[3][0] = "Interest from stocks and bonds they own.";
			decoyAnswers[3][1] = "";
			decoyAnswers[3][2] = "Rent paid to them from property they own.";
			decoyAnswers[3][3] = "Their DVD collection";

			//decoys for question5
			decoyAnswers[4][0] = "Decreased.";
			decoyAnswers[4][1] = "Remained the same.";
			decoyAnswers[4][2] = "";
			decoyAnswers[4][3] = "Decreased but not increased";

			//decoys for question6
			decoyAnswers[5][0] = "";
			decoyAnswers[5][1] = "Less poultry and more beef.";
			decoyAnswers[5][2] = "The same amount of poultry and beef.";
			decoyAnswers[5][3] = "Venison";

			//decoys for question7
			decoyAnswers[6][0] = "Automobile manufacturers in Country X";
			decoyAnswers[6][1] = "Consumers in the United States";
			decoyAnswers[6][2] = "";
			decoyAnswers[6][3] = "China";

			//decoys for question8
			decoyAnswers[7][0] = "There will be more apartments available than people want to rent.";
			decoyAnswers[7][1] = "";
			decoyAnswers[7][2] = "The number of apartments available will be equal.";
			decoyAnswers[7][3] = "The water temperature will increase";

			//decoys for question9
			decoyAnswers[8][0] = "Producers and government";
			decoyAnswers[8][1] = "Consumers and government";
			decoyAnswers[8][2] = "Guilford College bookstore";
			decoyAnswers[8][3] = "";

			//decoys for question10
			decoyAnswers[9][0] = "";
			decoyAnswers[9][1] = "Both Mexico and Argentina lose from the trade.";
			decoyAnswers[9][2] = "Mexico benefits and Argentina loses from the trade.";
			decoyAnswers[9][3] = "Mexico will build a wall on its border with Argentinar";

		}
	}

	@Override
	public void tick() {
		if(state == Game.subState && toggle && init){
			Collections.shuffle(index);
			toggle = false;
			i =0;
		}else
			toggle = true;



	}

	@Override
	public void draw(Graphics g) {
		if(Game.subState == state){
			if(toggle2){
				Collections.shuffle(index);
				toggle2 = false;
				correct = false;
				incorrect = false;
			}
			if(player.getHp() > 0 && i < 10){

				ImageIcon paper = new ImageIcon("paper.png");
				paper.paintIcon(panel, g, 0, 0);
				g.setColor(Color.BLACK);
				g.setFont(new Font("Bradley Hand ITC", Font.BOLD, 16));
					g.drawString(questions[index.get(i)], 20, 100);
					g.setFont(new Font("Bradley Hand ITC", Font.BOLD, 24));
					for(int p = 0; p < 4; p++){
						if(!decoyAnswers[index.get(i)][p].equals("")){
							g.drawString((char) (65+p)+". "+decoyAnswers[index.get(i)][p], Game.dimension/2 - 400, 220 + 30*p);
						}
						else
							g.drawString((char) (65+p)+". "+answers[index.get(i)], Game.dimension/2 - 400, 220 + 30*p);

						if(correct){
							g.setFont(new Font("Bradley Hand ITC", Font.BOLD, 24));

							g.drawString("Previous question was correct! +2 EXP", 100, 440);
						}else if(incorrect){
							g.setFont(new Font("Bradley Hand ITC", Font.BOLD, 24));
							g.drawString("Previous question was incorrect! -10 HP", 100, 440);
						}
					}

			}else if(player.getHp() <= 0){
				g.setColor(Color.red);
				g.setFont(new Font("Bradley Hand ITC", Font.BOLD, 30));

				g.fillRect(0, 0, Game.dimension, Game.dimension);
				g.setColor(Color.BLACK);
				g.drawString("You're a failure, press space to exit and rest", 100, 100);
			}else{
				g.setColor(Color.green);
				g.setFont(new Font("Bradley Hand ITC", Font.BOLD, 30));

				g.fillRect(0, 0, Game.dimension, Game.dimension);
				g.setColor(Color.BLACK);
				g.drawString("You've completed this course, press space to exit", 100, 100);
				c.complete(true);
			}
		}else
			toggle2 = true;

	}


	@Override
	public void keyPressed(int k) {


	}

	@Override
	public void keyReleased(int k) {
		if(Game.subState == state){
			if(k ==  KeyEvent.VK_A){
				if(!decoyAnswers[index.get(i)][0].equals("")){
					player.setHp(player.getHp() - 10);
					incorrect = true;
					correct = false;
				}
				else{
					player.setExp(player.getExp() + 2);
					correct = true;
					incorrect = false;
				}
				i++;

			}else if(k == KeyEvent.VK_B){
				if(!decoyAnswers[index.get(i)][1].equals("")){
					player.setHp(player.getHp() - 10);
					incorrect = true;
					correct = false;
				}
				else{
					player.setExp(player.getExp() + 2);
					correct = true;
					incorrect = false;
				}
				i++;

			}else if(k == KeyEvent.VK_C){
				if(!decoyAnswers[index.get(i)][2].equals("")){
					player.setHp(player.getHp() - 10);
					incorrect = true;
					correct = false;
				}
				else{
					player.setExp(player.getExp() + 5);
					correct = true;
					incorrect = false;
				}
				i++;

			}else if(k == KeyEvent.VK_D){
				if(!decoyAnswers[index.get(i)][3].equals("")){
					player.setHp(player.getHp() - 10);
					incorrect = true;
					correct = false;
				}
				else{
					player.setExp(player.getExp() + 2);
					correct = true;
					incorrect = false;
				}	
				i++;
			}
			if(k == KeyEvent.VK_SPACE){
				Game.subState = stateClass;
			}
		}
	}

}
