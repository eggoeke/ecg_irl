package ecg_irl;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class Battle {

	private JFrame frame;
	private ButtonListener nextPage;
	private JButton btnA, btnB, btnC, btnD;
	private int dimension;
	private boolean correct = false;
	private JTextArea questionArea, answerChoices;
	private String[] question = new String[6];
	private String[] answer = new String [6];
	private int i = 1, x = 1;
	private JLabel lblQuestionNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Battle window = new Battle();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Battle() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) screenSize.getHeight();
		int width = (int) screenSize.getWidth();
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for(int i = 0; (height-100) > i; i+=50)
			dimension = i;
		frame.setSize(497, 488);
		frame.setLocation(width/2 - dimension/2, height/2 - dimension/2);
		frame.getContentPane().setLayout(null);
		
		JLabel lblProgrammingTrivia = new JLabel("Programming Trivia");
		lblProgrammingTrivia.setFont(new Font("AR DESTINE", Font.PLAIN, 20));
		lblProgrammingTrivia.setBounds(141, 48, 204, 35);
		frame.getContentPane().add(lblProgrammingTrivia);
		
		nextPage = new ButtonListener();
		
		 btnA = new JButton("A");
		btnA.setBounds(22, 332, 89, 23);
		frame.getContentPane().add(btnA);
		btnA.addActionListener(nextPage);
		

		 btnB = new JButton("B");
		btnB.setBounds(121, 332, 89, 23);
		frame.getContentPane().add(btnB);
		btnB.addActionListener(nextPage);
		
		 btnC = new JButton("C");
		btnC.setBounds(270, 332, 89, 23);
		frame.getContentPane().add(btnC);
		btnC.addActionListener(nextPage);
		
		 btnD = new JButton("D");
		btnD.setBounds(374, 332, 89, 23);
		frame.getContentPane().add(btnD);
		btnD.addActionListener(nextPage);
		
		answerChoices = new JTextArea();
		answerChoices.setText("Answers 1");
		answerChoices.setBounds(59, 195, 374, 56);
		answerChoices.setEditable(false);
		answerChoices.setBackground(null);
		frame.getContentPane().add(answerChoices);
		
		
		questionArea = new JTextArea();
		questionArea.setText("Question 1");
		questionArea.setBounds(59, 127, 374, 22);
		questionArea.setEditable(false);
		questionArea.setBackground(null);
		frame.getContentPane().add(questionArea);
		
		lblQuestionNumber = new JLabel("Question #1");
		lblQuestionNumber.setBounds(22, 22, 89, 23);
		frame.getContentPane().add(lblQuestionNumber);
		

		//Write questions here
			question[2] = "Question 2";
			question[3] = "Question 3";
			question[4] = "Question 4";
			question[5] = "Question 5";
			
		//Write answers here	
			answer[2] = "Answers 2";
			answer[3] = "Answers 3";
			answer[4] = "Answers 4";
			answer[5] = "Answers 5";
			
			
			
			
		
	}
	private class ButtonListener implements ActionListener {
		
		
		//This system is a little weird. Put the correct answer by matching the question number with the button 
		//choice. For example, if the right answer to #1 is A, I would put a 1 on the second line of the if statement
		//"if (i==1){
		
		//Put some consequence for the player with the lines that have the SYSTEM OUT WRONG.
		
		public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource() == btnA  && i<=5){	
					if (i == 3 || i == 1){
						correct = true;
						if (correct = true){
							i++;
							x++;
							questionArea.setText(question[i]);
							answerChoices.setText(answer[i]);
							lblQuestionNumber.setText("Question #" + (i+2));
							correct = false;
						}
					}
					else System.out.println("WRONG");
				}	

				if(arg0.getSource() == btnB  && i<=4){	
					if (i == 2 ){
						correct = true;
						if (correct = true){
							i++;
							x++;
							questionArea.setText(question[i]);
							answerChoices.setText(answer[i]);
							lblQuestionNumber.setText("Question #" + (i+2));
							correct = false;
						}
					}
					else System.out.println("WRONG");
				}	
			
			
				if(arg0.getSource() == btnC  && i<=4){	
					if (i == 4){
						correct = true;
						if (correct = true){
							i++;
							x++;
							questionArea.setText(question[i]);
							answerChoices.setText(answer[i]);
							lblQuestionNumber.setText("Question #" + (i+2));
							correct = false;
						}
					}
					else System.out.println("WRONG");
				}	
				if(arg0.getSource() == btnD  && i<=4){	
					if (i == 5){
						correct = true;
						if (correct = true){
							i++;
							questionArea.setText(question[i]);
							answerChoices.setText(answer[i]);
							lblQuestionNumber.setText("Question #" + (i+2));
							correct = false;
						}
					}
					else System.out.println("WRONG");
				}	
			if (i>5) {
				System.out.println("Close the window");
				//Get rid of the battle here!
		
				}
				}
			}
	//Call these methods to change the questions and answers		
	public void setAnswers(String[] g){
		this.question = g;
	}
	public void setQuestions(String[] g){
		this.answer = g;
	}
}
		