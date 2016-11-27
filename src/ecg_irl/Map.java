package ecg_irl;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Map {
	int x, y, xMove, yMove, mapHeight, mapWidth;
	Player player;
	private ImageIcon map;

	
	public Map(Player player){
		this.player = player;
		x = 0;
		y = 0;
	}
	public void drawMap(Graphics g, JPanel game){
		map = new ImageIcon("mapXL.png");
		mapWidth = map.getIconWidth();
		mapHeight = map.getIconHeight();
		map.paintIcon(game, g, x, y);
	}
	public void moveUp(){
		yMove = player.getSpeed();
	}
	public void moveDown(){
		yMove = -player.getSpeed();
	}
	public void stopY(){
		yMove = 0;
	}
	public void moveRight(){
		xMove = player.getSpeed();
	}
	public void moveLeft(){
		xMove = -player.getSpeed();
	}
	public void stopX(){
		xMove = 0;
	}
	public void move(){
		x += xMove;
		y += yMove;
		xMove = 0;
		yMove = 0;
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
	public int getMapHeight() {
		return mapHeight;
	}
	public int getMapWidth() {
		return mapWidth;
	}
}
