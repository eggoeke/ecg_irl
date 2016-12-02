package ecg_irl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StatsBar {
	int hp, maxHP, exp, maxEXP, intelligence, level, width;
	JFrame frame;
	
	
	public StatsBar(Player player, JFrame frame, JPanel panel){
		hp = player.getHp();
		maxHP = player.getmaxHP();
		exp = player.getExp();
		maxEXP = player.getmaxEXP();
		intelligence = player.getIntelligence();
		level = player.getLevel();
		this.frame = frame;
		width = frame.getWidth();
	}
	public void drawStats(Graphics g){

		drawExpBar(g);
		drawHpBar(g);
	}
	public void drawLevel(java.awt.Graphics2D g2, JPanel panel){
		g2.setColor(Color.ORANGE);
		g2.fill(new Ellipse2D.Double(0,0,width/6,width/6));
		g2.setColor(Color.white);
		g2.setFont(new Font("Courier", Font.BOLD, 60));
		g2.drawString(Integer.toString(level), 0, 0);
	}
	public void drawExpBar(Graphics g){
		
	}
	public void drawHpBar(Graphics g){
		
	}

}
