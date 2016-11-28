package ecg_irl;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Player {
	int intelligence, exp, maxEXP, hp, maxHP, xMove, yMove, x, y, time, speed, count, level;
	boolean dead;
	private BufferedImage spriteSheet = null;

	public Player(){
		count = 0;
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
	public void stopY(){
		yMove = 0;
	}

	public void moveRight(){
		xMove = speed;
	}
	public void moveLeft(){
		xMove = -speed;
	}
	public void stopX(){
		xMove = 0;
	}
	public void move(){
		x += xMove;
		y += yMove;
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
		try{
			spriteSheet = ImageIO.read(new File("spritesheet.PNG"));
		}catch (IOException e){

		}
		if(yMove > 0){
			if(count < 30)
				g.drawImage(spriteSheet.getSubimage(0, 104, 72, 104), (int) frame.getWidth()/2 - 72/2, (int) frame.getHeight()/2 - 104/2, 72, 104, null);
			else if(count < 60 && count >= 30)
				g.drawImage(spriteSheet.getSubimage(72, 104, 72, 104), (int) frame.getWidth()/2 - 72/2, (int) frame.getHeight()/2 - 104/2, 72, 104, null);
			else if(count >= 60)
				g.drawImage(spriteSheet.getSubimage(144, 104, 72, 104), (int) frame.getWidth()/2 - 72/2, (int) frame.getHeight()/2 - 104/2, 72, 104, null);	
		}else if(yMove < 0){
			if(count < 30)
				g.drawImage(spriteSheet.getSubimage(0, 0, 72, 104), (int) frame.getWidth()/2 - 72/2, (int) frame.getHeight()/2 - 104/2, 72, 104, null);
			else if(count < 60 && count >= 30)
				g.drawImage(spriteSheet.getSubimage(72, 0, 72, 104), (int) frame.getWidth()/2 - 72/2, (int) frame.getHeight()/2 - 104/2, 72, 104, null);
			else if(count >= 60)
				g.drawImage(spriteSheet.getSubimage(144, 0, 72, 104), (int) frame.getWidth()/2 - 72/2, (int) frame.getHeight()/2 - 104/2, 72, 104, null);	
		}else if(xMove > 0){
			if(count < 30)
				g.drawImage(spriteSheet.getSubimage(0, 208, 72, 104), (int) frame.getWidth()/2 - 72/2, (int) frame.getHeight()/2 - 104/2, 72, 104, null);
			else if(count < 60 && count >= 30)
				g.drawImage(spriteSheet.getSubimage(72, 208, 72, 104), (int) frame.getWidth()/2 - 72/2, (int) frame.getHeight()/2 - 104/2, 72, 104, null);
			else if(count >= 60)
				g.drawImage(spriteSheet.getSubimage(144, 208, 72, 104), (int) frame.getWidth()/2 - 72/2, (int) frame.getHeight()/2 - 104/2, 72, 104, null);	
		}else if(xMove < 0){
			if(count < 30)
				g.drawImage(spriteSheet.getSubimage(0, 312, 72, 104), (int) frame.getWidth()/2 - 72/2, (int) frame.getHeight()/2 - 104/2, 72, 104, null);
			else if(count < 60 && count >= 30)
				g.drawImage(spriteSheet.getSubimage(72, 312, 72, 104), (int) frame.getWidth()/2 - 72/2, (int) frame.getHeight()/2 - 104/2, 72, 104, null);
			else if(count >= 60)
				g.drawImage(spriteSheet.getSubimage(144, 312, 72, 104), (int) frame.getWidth()/2 - 72/2, (int) frame.getHeight()/2 - 104/2, 72, 104, null);	
		}else{
			g.drawImage(spriteSheet.getSubimage(72, 0, 72, 104), (int) frame.getWidth()/2 - 72/2, (int) frame.getHeight()/2 - 104/2, 72, 104, null);
		}
		if(count < 90)
			count += speed;
		else count = 0;

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
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

}
