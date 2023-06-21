import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Game {

	JFrame frame;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choicePanel, playerPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
	JTextArea mainTextArea;
	JButton startButton, choice1, choice2, choice3, choice4;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	int playerHP;
	String weapon, position;
	
	public static void main(String[] args) {
		new Game();

	}

	public Game() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.black);
		frame.setSize(800,600);
		frame.setLayout(null);
		con = frame.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100,100,600,150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("Adventure");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300,400,200,100);
		startButtonPanel.setBackground(Color.black);
		startButton = new JButton("Start");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.setFocusable(false);
		startButton.addActionListener(tsHandler);
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		
		con.add(startButtonPanel);
		con.add(titleNamePanel);
		
		frame.setVisible(true);
	}
	
	public void createGameScreen() {
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBackground(Color.black);
		mainTextPanel.setBounds(100,100,600,250);
		
		mainTextArea = new JTextArea("This is where the main text is. This game is going to be great. I'm sure of it.");
		mainTextArea.setBounds(100,100,600,250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
		choicePanel = new JPanel();
		choicePanel.setBounds(250,350,300,100);
		choicePanel.setBackground(Color.red);
		choicePanel.setLayout(new GridLayout(4,1));
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusable(false);
		choice1.setActionCommand("c1");
		choice1.addActionListener(choiceHandler);
		
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusable(false);
		choice2.setActionCommand("c2");
		choice2.addActionListener(choiceHandler);
		
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusable(false);
		choice3.setActionCommand("c3");
		choice3.addActionListener(choiceHandler);
		
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusable(false);
		choice4.setActionCommand("c4");
		choice4.addActionListener(choiceHandler);
		
		choicePanel.add(choice1);
		choicePanel.add(choice2);
		choicePanel.add(choice3);
		choicePanel.add(choice4);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(100,15,600,50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1,4));
		
		hpLabel = new JLabel("HP: ");
		hpLabel.setForeground(Color.white);
		hpLabel.setFont(normalFont);
		hpLabelNumber = new JLabel();
		hpLabelNumber.setForeground(Color.white);
		hpLabelNumber.setFont(normalFont);
		weaponLabel = new JLabel("Weapon: ");
		weaponLabel.setForeground(Color.white);
		weaponLabel.setFont(normalFont);
		weaponLabelName = new JLabel();
		weaponLabelName.setForeground(Color.white);
		weaponLabelName.setFont(normalFont);
		
		playerPanel.add(hpLabel);
		playerPanel.add(hpLabelNumber);
		playerPanel.add(weaponLabel);
		playerPanel.add(weaponLabelName);
		
		con.add(playerPanel);
		con.add(mainTextPanel);
		con.add(choicePanel);
		
		playerSetup();
	}
	
	public void playerSetup() {
		playerHP = 15;
		weapon = "Knife";
		hpLabelNumber.setText(String.valueOf(playerHP));
		weaponLabelName.setText(weapon);
		
		townGate();
	}
	
	public void townGate() {
		position = "townGate";
		mainTextArea.setText("You are at the gate of the town. \nA guard is standing in front of you. "
				+ "\nWhat do you do?");
		
		choice1.setText("Talk to the guard");
		choice2.setText("Attack the guard");
		choice3.setText("Leave");
		choice4.setText("");
	}
	
	public void talkGuard() {
		position = "talkGuard";
		mainTextArea.setText("Guard: Hello stranger. I have never seen your face. "
				+ "\nI'm sorry but I cannot let a stranger enter our town");
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public class TitleScreenHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			createGameScreen();
			
		}
	}
	
	public class ChoiceHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String yourChoice = e.getActionCommand();
			
			switch(position) {
			case "townGate":
				switch(yourChoice) {
				case "c1": talkGuard(); break;
				case "c2": break;
				case "c3": break;
				}
				break;
			case "talkGuard":
				switch(yourChoice) {
				case "c1": townGate(); break;
				}
				break;
				
			}
			
		}
		
	}

}
