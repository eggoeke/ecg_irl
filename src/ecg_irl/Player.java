package ecg_irl;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Player {
	int intelligence, exp, maxEXP, hp, maxHP, xMove, yMove, x, y, time, speed;
	boolean dead;
	private ImageIcon player;


	public Player(){
		x = 0;
		y = 0;
		hp = 50;
		maxHP = 50;
		exp = 0;
		maxEXP = 100;
		time = 80;
		speed = 5;
	}
	public void moveUp(){
		yMove = speed;
	}
	public void moveDown(){
		yMove = -speed;
	}

	public void moveRight(){
		xMove = speed;
	}
	public void moveLeft(){
		xMove = -speed;
	}
	public void move(){
		x += xMove;
		y += yMove;
		xMove = 0;
		yMove = 0;
	}
	public void rest(){
		hp = maxHP;
		time -= 1;
	}
	public void killed(){
		hp = maxHP;
		time -= 5;
	}
	public void attacked(int damage){
		hp = hp - damage;
		if(hp <= 0)
			killed();
	}
	public void drawPlayer(Graphics g, JPanel game, JFrame frame){
		player = new ImageIcon("sprite.png");
		player.paintIcon(game, g,frame.getWidth()/2 - player.getIconWidth()/2, frame.getHeight()/2 - player.getIconHeight()/2);
	}
	
	public int getxMove() {
		return xMove;
	}
	public int getyMove() {
		return yMove;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getmaxEXP() {
		return maxEXP;
	}
	public void setmaxEXP(int maxEXP) {
		this.maxEXP = maxEXP;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}

	public int getmaxHP() {
		return maxHP;
	}

	public void setmaxHP(int maxHP) {
		this.maxHP = maxHP;
	}

}
