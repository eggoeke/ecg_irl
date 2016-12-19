package ecg_irl;
 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
 
import javax.sound.sampled.FloatControl;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.*;
 
/**Help panel panel. Creates JTextAreas with directions on game, controls.**/

public class HelpPanel extends JPanel {
 
    public JTextArea help;
   
    public HelpPanel() {
    super();
    setBackground(Color.BLACK);
    setPreferredSize(new Dimension(552, 437));
   
    help = new JTextArea("GAME");
    help.setBounds(10, 0, 109, 110);
   
    help.setOpaque(false);
    help.setRows(5);
    //help.setColumns(30);
    Font font = new Font("GulimChe", Font.BOLD, 20);
    help.setFont(font);
    help.setForeground(Color.WHITE);
    help.setWrapStyleWord(true);
    help.setVisible(true);
    setLayout(null);
    add(help);
   
        JTextArea txtrYouAreAn = new JTextArea();
        txtrYouAreAn.setLineWrap(true);
        txtrYouAreAn.setText("You are an ECG student in their last semester in their senior year.  You are on a quest to raise your Intelligence    (ATTK) and Motivation (HP). Why? To defeat the final boss  of course... Why else would you friggin' play an RPG?");
        txtrYouAreAn.setFont(new Font("GulimChe", Font.PLAIN, 18));
        txtrYouAreAn.setBackground(Color.BLACK);
        txtrYouAreAn.setForeground(Color.WHITE);
        txtrYouAreAn.setBounds(10, 24, 532, 95);
        add(txtrYouAreAn);
       
        JTextArea txtrControls = new JTextArea();
        txtrControls.setFont(new Font("GulimChe", Font.BOLD, 20));
        txtrControls.setBackground(Color.BLACK);
        txtrControls.setForeground(Color.WHITE);
        txtrControls.setText("CONTROLS");
        txtrControls.setBounds(10, 117, 127, 28);
        add(txtrControls);
       
        JTextArea txtrMovementwasdSprint = new JTextArea();
        txtrMovementwasdSprint.setLineWrap(true);
        txtrMovementwasdSprint.setFont(new Font("GulimChe", Font.BOLD, 18));
        txtrMovementwasdSprint.setText("Movement: \"WASD\"\r\nSprint: \"Space_Bar\"\r\nCharacter Menu: \"M\"\r\nScrolling Through Menu: \"UP,DOWN\"\r\nSelecting Menu: \"Enter_Key\"\r\nExiting Stats Menu: \"Escape_Key\"\r\nEntering Buildings: \"R\"\r\nLeaving Buildings: \"R\"\r\nAttack: \"Enter_Key\"\r\nQuiz Answer Selections: \"ABCD\"\r\nExiting Quiz: \"Space_Bar\"\r\n");
        txtrMovementwasdSprint.setBackground(Color.BLACK);
        txtrMovementwasdSprint.setForeground(Color.WHITE);
        txtrMovementwasdSprint.setBounds(10, 142, 370, 261);
        add(txtrMovementwasdSprint);
       
       
   
 
    }
}