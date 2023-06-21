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
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	int playerHP;
	String weapon;
	
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
		
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusable(false);
		
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusable(false);
		
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusable(false);
		
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
	}
	
	public class TitleScreenHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			createGameScreen();
			
		}
		
	}

}
