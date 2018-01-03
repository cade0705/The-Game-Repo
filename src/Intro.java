import javax.swing.*;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.*;
import java.util.Timer;
public class Intro
{
	//Class Variables
	public static JLabel textLabel = Window_Manager.titleLabel;
	public static JTextField playerResponseField = Window_Manager.textField;
	public static String playerName;
	public static Player thePlayer;

	public static void start() 
	{
		getInfo();
		//tutorial();
	}//end start()

	public static void getInfo() 
	{
		playerName = "";
		textLabel.setText("<html>Let's see. Ah, Here we go. Welcome valued player to The Game! I am so very excited to get started. Please enter your name in the text box below and hit \"ENTER\"</html>");
		playerResponseField.setVisible(true); 
	}//end getInfo()

	public static void tutorial()
	{
		Window_Manager.inputCounter = "tutorialClickTwo";
		textLabel.setText("<html>Before you begin your Journey in this simulated world, there are a few things that you must know</html>");
		
	}

	public static void choosePath()
	{

	}//end choosePath()
}//end class Intro