package ecg_irl;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/** Chafic floating head class. The image of Chaific's head follows the user **/
public class Chafic {
	int xMove;
	int yMove;
	int x;
	int y;
	JPanel panel;
	int width, height;
	
	public Chafic(JPanel panel){
		x = 0;
		y = 0;
		xMove = 0;
		yMove = 0;
		this.panel = panel;
		ImageIcon chafic = new ImageIcon("chafic.png");
		width = chafic.getIconWidth();
		height = chafic.getIconHeight();
	}
	public void drawChafic(Graphics g, JPanel game, JFrame frame){
		ImageIcon chafic = new ImageIcon("chafic.png");
		chafic.paintIcon(panel, g, x, y);
	}
	
	public void tick(){
		x = x+xMove;
		y = y+yMove;
	}
	public int getxMove() {
		return xMove;
	}
	public void setxMove(int xMove) {
		this.xMove = xMove;
	}
	public int getyMove() {
		return yMove;
	}
	public void setyMove(int yMove) {
		this.yMove = yMove;
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
	


}
