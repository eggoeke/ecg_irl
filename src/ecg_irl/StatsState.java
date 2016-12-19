package ecg_irl;
 
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
 /**The state for the stat menu**/
public class StatsState extends GameState{
   
 
    private int hp, maxHP, exp, maxEXP, intelligence, level, width, damage, experience;
    private BufferedImage sprite = null;
    private Player player;
   
   
    public StatsState(GameStateManager gsm, Player player, Map map, JPanel panel, JFrame frame) {
        super(gsm, player, map, panel, frame);
       
        //player.setHp();
        //player.setExp();
       this.player = player;
    }
 
    @Override
    public void init() {
 
 
    }
 
    @Override
    public void tick() {
        exp = player.getExp();
        maxEXP = player.getmaxEXP();
 
        hp = player.getHp();
        maxHP = player.getmaxHP();
 
        intelligence = player.getIntelligence();
       
        level = player.getLevel();

 
    }
 
    @Override
    public void keyPressed(int k) {
 
 
    }
 
    @Override
    public void keyReleased(int k) {
 
 
    }
   
////    public void drawStats(Graphics g) {
////        if(Game.subState == Game.SUBSTATE.STATSCREEN){
////           
////   
////       
////        }
//
//
//  }
    public void drawExpBar(Graphics g) {
       
        g.setColor(Color.GREEN);
        g.setFont(new Font("Courier", Font.BOLD, 60));
        g.drawString("EXP: " + Integer.toString(exp) + "/" + Integer.toString(maxEXP), Game.dimension/3-250, 470);
       
    }
    public void drawHpBar(Graphics g) {
       
        g.setColor(Color.RED);
        g.setFont(new Font("Courier", Font.BOLD, 60));
        g.drawString("HP:  " + Integer.toString(hp) + "/" + Integer.toString(maxHP), Game.dimension/3-250, 400);
 
    }
   
    public void drawIntBar(Graphics g) {
       
        g.setColor(Color.BLACK);
        g.setFont(new Font("Courier", Font.BOLD, 60));
        g.drawString("Int (Attk): " + Integer.toString(intelligence), Game.dimension/3, 200);
       
    }
    public void drawLevel (Graphics g){
        g.setColor(Color.BLUE);
        g.setFont(new Font("Courier", Font.BOLD, 60));
        g.drawString("Level:      " + Integer.toString(level), Game.dimension/3, 150);
    }
    public void drawSprite(Graphics g){
        try
        {
            sprite = ImageIO.read(new File("front.png")); // eventually C:\\ImageTest\\pic2.jpg
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        g.drawImage(sprite,175, 100, null);
    }
    public void drawBars(Graphics g){
        
    	g.setColor(Color.BLACK);
        g.drawRect(480, 350, 400, 50); //health
        g.setColor(Color.RED);
        g.fillRect(481, 351, 400*hp/maxHP, 49); //health fill
        
        g.setColor(Color.BLACK);
        g.drawRect(480, 420, 400, 50); //exp
        g.setColor(Color.GREEN);
        g.fillRect(481, 421, 400*exp/maxEXP, 49); //exp fill
        
        g.setColor(Color.BLACK);
        g.drawRect(150, 85, 125, 150); //portrait box
       
        
        g.setFont(new Font("ARIAL", Font.BOLD, 30));
        g.drawRect(55, 500, 825, 400);
        g.drawString("Attributes:", 60, 530); 
        g.setFont(new Font("ARIAL", Font.ITALIC, 30));
        g.drawString("- ''Stereotypical ECG Kid'' set effect", 60, 565);
        g.drawString("- Smart @$$es", 60, 600);
        g.drawString("- Really Loud", 60, 635);
        
        g.setFont(new Font("ARIAL", Font.BOLD, 30));
        g.drawString("Weaknesses:", 60 , 680);
        g.setFont(new Font("ARIAL", Font.ITALIC, 30));
        g.drawString("- Chafic Bou-Saba's greatness", 60, 715);
        g.drawString("- Social Lives", 60, 750);
        g.drawString("- Lack of Coffee", 60, 785);
        g.drawString("- B+'s (Critical Weakness)", 60, 820);
        
        g.setFont(new Font("ARIAL", Font.BOLD, 30));
        g.drawString("Strengths:", 60, 860);
        
        g.setFont(new Font("ARIAL", Font.ITALIC, 20));
        g.setColor(Color.RED);
        g.drawString("Fatal Error: StrengthsNotFoundException ", 60, 885);
    }
 
    @Override
    public void draw(Graphics g) {
        if(Game.subState == Game.SUBSTATE.STATSCREEN){
            //g.fillRect(0, 0, Game.dimension, Game.dimension);
            drawExpBar(g);
            drawHpBar(g);
            drawIntBar(g);
            drawLevel(g);
            drawSprite(g);
            drawBars(g);
        }
 
    }
 
 
}