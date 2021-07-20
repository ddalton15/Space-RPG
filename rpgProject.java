

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class rpgProject {
	
	JFrame gameWindow;
	Container contain;
	JPanel introScreenPanel, gameStartPanel, mainTextPanel, choiceButtons, shipPanel;
	JLabel spaceNameLabel, shipHealth, shipHealthNumber, weaponLabel, weaponLabelName;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
	int playerHp, pirateHp, alienOrb;
	String weapon, position;
	
	TitleScreenHandle tsHandle = new TitleScreenHandle();
	ChoiceHandler choiceHandle = new ChoiceHandler();
	
	
	public static void main(String[] args) {
		
		new rpgProject();
		
	}
	
	public rpgProject() {
		
		// creates the window to display the game
		gameWindow = new JFrame();
		gameWindow.setSize(800, 600);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.getContentPane().setBackground(Color.black);
		gameWindow.setLayout(null);
		contain = gameWindow.getContentPane();
		
		//creates title screen text
		introScreenPanel = new JPanel();
		introScreenPanel.setBounds(100, 100, 600, 150);
		introScreenPanel.setBackground(Color.black);
		spaceNameLabel = new JLabel("SPACEFLIGHT");
		spaceNameLabel.setForeground(Color.white);
		spaceNameLabel.setFont(titleFont);
		
		gameStartPanel = new JPanel();
		gameStartPanel.setBounds(300, 400, 200, 100);
		gameStartPanel.setBackground(Color.black);
		
		startButton = new JButton("START!");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.black);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandle);
		startButton.setFocusPainted(false);

		
		introScreenPanel.add(spaceNameLabel);
		gameStartPanel.add(startButton);
		
		contain.add(introScreenPanel);
		contain.add(gameStartPanel);
		
		gameWindow.setVisible(true);
	}
	
	public void createGame() {
		//the issue is somewhere in here
		contain.remove(introScreenPanel);
		startButton.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		contain.add(mainTextPanel);
		
		mainTextArea = new JTextArea("This game will be awesome");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true);
		mainTextArea.setEditable(false);
		
		mainTextPanel.add(mainTextArea);
		
		choiceButtons = new JPanel();
		choiceButtons.setBounds(250, 350, 300, 150);
		choiceButtons.setBackground(Color.black);
		choiceButtons.setLayout(new GridLayout(4,1));
		contain.add(choiceButtons);
		
		choice1 = new JButton("Attack the ship");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.black);
		choice1.setFont(normalFont);
		choiceButtons.add(choice1);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandle);
		choice1.setActionCommand("c1");
		
		choice2 = new JButton("Hail the tower");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.black);
		choice2.setFont(normalFont);
		choiceButtons.add(choice2);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandle);
		choice2.setActionCommand("c2");
		
		choice3 = new JButton("Sneak inside");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.black);
		choice3.setFont(normalFont);
		choiceButtons.add(choice3);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandle);
		choice3.setActionCommand("c3");
		
		choice4 = new JButton("Leave");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.black);
		choice4.setFont(normalFont);
		choiceButtons.add(choice4);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandle);
		choice4.setActionCommand("c4");
		
		shipPanel = new JPanel();
		shipPanel.setBounds(100, 15, 600, 50);
		shipPanel.setBackground(Color.black);
		shipPanel.setLayout(new GridLayout(1, 4));
		contain.add(shipPanel);
		
		shipHealth = new JLabel("HEALTH: ");
		shipHealth.setFont(normalFont);
		shipHealth.setForeground(Color.white);
		shipPanel.add(shipHealth);
		
		shipHealthNumber = new JLabel();
		shipHealthNumber.setFont(normalFont);
		shipHealthNumber.setForeground(Color.white);
		shipPanel.add(shipHealthNumber);
		
		weaponLabel = new JLabel("Weapon: ");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		shipPanel.add(weaponLabel);
		
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		shipPanel.add(weaponLabelName);
		
		playerSetup();
		
		
	}
	
	public void playerSetup() {
		playerHp = 100;
		pirateHp = 110;
		weapon = "Lasers";
		weaponLabelName.setText(weapon);
		shipHealthNumber.setText("" + playerHp);
		
		spacePortDock();
		 
	}
	
	public void spacePortDock() {
		position = "portEntrance";
		mainTextArea.setText("You are at the entrance of the station. \nA guard ship is in front of you. \n\nWhat do you do?");
		choice1.setText("Hail the ship");
		choice2.setText("Attack the ship");
		choice3.setText("Leave");
		choice4.setText("");
		
		
	}
	
	public void hailShip() {
		position = "talkShip";
		mainTextArea.setText("Ship: Hello Commander. You do not show up on the manifest. I cannot grant you access to the station");
		choice1.setText("Go back");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void attackShip() {
		position = "attackShip";
		mainTextArea.setText("Ship: Watch Yourself! \nDischarging your weapons will not be tolerated!\n\nYour lasers bounced off of the ships shields.\n(You recieve 30 damage)");
		playerHp = playerHp - 30;
		shipHealthNumber.setText("" + playerHp);
		choice1.setText("Go back");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void orbit() {
		position = "orbit";
		mainTextArea.setText("You are in orbit above a planet \n If you go down, you will be back at the station.");
		choice1.setText("Go up");
		choice2.setText("Go port");
		choice3.setText("Go down");
		choice4.setText("Go starboard");
		
	}
	
	public void up() {
		position = "up";
		mainTextArea.setText("There is a repair ship. \nYou dock and your ship health is recovered by 20");
		playerHp = playerHp + 20;
		shipHealthNumber.setText(""+playerHp);
		choice1.setText("Go down");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	
	public void port() {
		position = "port";
		mainTextArea.setText("You go into an asteroid field and find ship debris. Inside the debris is a new Missle Launcher!\n\n (You obtained a Missle Launcher)");
		weapon = "Missles";
		weaponLabelName.setText(weapon);
		choice1.setText("Go starboard");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	
	public void starboard() {
		position = "starboard";
		mainTextArea.setText("You encounter a space pirate!");
		choice1.setText("Fight");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
		
	}
	public void fight() {
		position = "fight";
		mainTextArea.setText("Pirate Hp: " + pirateHp + "\n\nwhat do you do?");
		choice1.setText("Attack");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
	}
	public void playerAttack() {
		position = "playerAttack";
		
		int playerDamage = 0;
		
		if (weapon.equals("Lasers")) {
			playerDamage = new java.util.Random().nextInt(90);
		}
		else if (weapon.equals("Missles")) {
			playerDamage = new java.util.Random().nextInt(120);
		}
		
		mainTextArea.setText("You attacked the pirate and gave " + playerDamage + " damage!");
		
		pirateHp = pirateHp - playerDamage;
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void pirateAttack() {
		position = "pirateAttack";
		
		int pirateDamage = 0;
		
		pirateDamage = new java.util.Random().nextInt(30);
		
		mainTextArea.setText("The pirate shot at you and gave you " + pirateDamage + " damage!");
		
		playerHp = playerHp - pirateDamage;
		shipHealthNumber.setText("" + playerHp);
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void win() {
		position = "win";
		
		mainTextArea.setText("You blew up the pirate!\n The pirate dropped an orb\n\n(You obtained a rare alien artifact)");
		alienOrb = 1;
		
		choice1.setText("Go port");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void lose() {
		position = "lose";
		
		mainTextArea.setText("You have been swallowed by the void\n\nGAME OVER");
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void ending() {
		position = "ending";
		
		mainTextArea.setText("Station Guard: you're the one that killed that pirate\n\n you have earned your access into the station!\n\nTHE END");
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
		
	
	public class TitleScreenHandle implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			
			createGame();
			
			
		}
		
	}
	public class ChoiceHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			 String yourChoice = event.getActionCommand();
			 
			 switch(position) {
			 case "portEntrance":
				 switch(yourChoice) {
				 case "c1": 
					 if(alienOrb ==1) {
						 ending();
					 }
					 else {
						 hailShip(); 
					 }
					break;
				 case "c2": attackShip();break;
				 case "c3": orbit();break; 
				 }
				 break;
			 case "talkShip":
				 switch(yourChoice) {
				 case "c1": spacePortDock(); break;
				 }
				 break;
			 case "attackShip":
				 switch(yourChoice) {
				 case "c1": spacePortDock(); break;
				 }
				 break;
			 case "orbit":
				 switch(yourChoice) {
				 case "c1": up(); break;
				 case "c2": port(); break;
				 case "c3": spacePortDock(); break;
				 case "c4": starboard(); break;
				 }
				 break;
			 case "up":
				 switch(yourChoice) {
				 case "c1": orbit(); break;
				 }
				 break;
			 case "port":
				 switch(yourChoice) {
				 case "c1": orbit(); break;
				 }
				 break;
			 case "starboard":
				 switch(yourChoice) {
				 case "c1": fight(); break;
				 case "c2": orbit(); break;
				 }
			 case "fight":
				 switch(yourChoice) {
				 case "c1": playerAttack(); break;
				 case "c2": orbit(); break;
				 }
				 break;
			 case "playerAttack":
				 switch(yourChoice) {
				 case "c1": 
					 if (pirateHp < 1) {
						 win();
					 }
					 else {
						 pirateAttack();
					 }
					 break;
				 }
				 break;
			 case "pirateAttack":
				 switch(yourChoice) {
				 case "c1": 
					 if (playerHp < 1) {
						 lose();
					 }
					 else {
						 fight();
						 
					 }
					  break;
				 }
				 break;
			 case "win": 
				 switch(yourChoice) {
				 case "c1": orbit();
				 }
				 break;
			 }
		}
	}

}

