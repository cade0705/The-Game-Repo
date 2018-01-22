import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import javax.swing.JToggleButton;
import javax.swing.JPasswordField;
import javax.swing.JTree;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window_Manager extends JFrame {
	private JButton creditsButton;
	private JButton startButton;
	public static JButton nextButton;
	public static JLabel titleLabel;
	private JLabel cadeCreditLabel;
	private JLabel specialThanksLabel;
	private JButton titleButton;
	public static JTextField textField = new JTextField();
	public static JTextField userInputField = new JTextField();
	private JPanel contentPane;
	private String inputCounter;

	/**
	 * Launch the application.
	 */
	public static void createWindow() 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Window_Manager frame = new Window_Manager();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Window_Manager() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(Window_Manager.class.getResource("/WindowBuilder/Resources/El Gato.png")));
		initComponents();
		createEvents();
	}

	//////////////////////////////////////////////////////////
	//This method is used to initialize all of the components
	//////////////////////////////////////////////////////////
	public void initComponents()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		titleLabel = new JLabel("The Game");
		titleLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

		startButton = new JButton("Start");
		startButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		startButton.setFocusPainted(false);

		creditsButton = new JButton("Credits");

		creditsButton.setFont(new Font("Tahoma", Font.PLAIN, 25));

		cadeCreditLabel = new JLabel("Programming / Design / Story: Cade Culbertson");
		cadeCreditLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cadeCreditLabel.setVisible(false);

		specialThanksLabel = new JLabel("Special Thanks: David Detweiler, Austin Stead, Stackoverflow.com");
		specialThanksLabel.setHorizontalAlignment(SwingConstants.CENTER);
		specialThanksLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		specialThanksLabel.setVisible(false);

		titleButton = new JButton("Back To Title Screen");
		titleButton.setVisible(false);
		titleButton.setFocusPainted(false);

		JLabel versionLabel = new JLabel("Dev Build 1.3.2");

		textField.setColumns(10);
		textField.setVisible(false);

		userInputField.setColumns(10);
		userInputField.setVisible(false);

		nextButton = new JButton("Next");
		nextButton.setVisible(false);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(99)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(specialThanksLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
												.addComponent(cadeCreditLabel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 619, Short.MAX_VALUE))
										.addGap(186))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(50)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(creditsButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
												.addComponent(startButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE))
										.addGap(268))))
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(versionLabel)
						.addGap(114)
						.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 427, Short.MAX_VALUE)
						.addGap(290))
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(226)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(349, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(310)
										.addComponent(titleButton, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(nextButton, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(233)
										.addComponent(userInputField, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(288, Short.MAX_VALUE))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(titleLabel)
										.addGap(11)
										.addComponent(cadeCreditLabel)
										.addGap(2)
										.addComponent(specialThanksLabel)
										.addGap(26)
										.addComponent(startButton, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(61))
								.addComponent(versionLabel))
						.addComponent(creditsButton, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(userInputField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(31)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE, false)
								.addComponent(titleButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
								.addComponent(nextButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
				);
		contentPane.setLayout(gl_contentPane);

		setTitle("The Game");
	}

	//////////////////////////////////////////////////////////
	//This method handles all of the events
	//////////////////////////////////////////////////////////
	public void createEvents()
	{
		creditsButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				creditsButton.setVisible(false);
				startButton.setVisible(false);
				titleLabel.setVisible(false);
				cadeCreditLabel.setVisible(true);
				specialThanksLabel.setVisible(true);
				titleButton.setVisible(true);
			}
		});//end creditsButton Action Listener

		titleButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				titleButton.setVisible(false);
				cadeCreditLabel.setVisible(false);
				specialThanksLabel.setVisible(false);
				titleLabel.setVisible(true);
				startButton.setVisible(true);
				creditsButton.setVisible(true);
			}
		});//end backToTitleButton Action Listener

		startButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				startButton.setVisible(false);
				creditsButton.setVisible(false);
				titleLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
				Intro.start();
			}
		});//end startButton Action Listener

		textField.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Intro.playerName = textField.getText();
				Intro.thePlayer = new Player(Intro.playerName);
				//System.out.println(Intro.playerName);

				textField.setVisible(false);
				titleLabel.setText("So your name is " + Intro.playerName + "?");
				userInputField.setVisible(true);
			}

		});//end textField Action Listener

		inputCounter = "firstClick";
		userInputField.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(inputCounter.equals("firstClick"))
				{
					String nameConfirmation = userInputField.getText();
					if(nameConfirmation.toLowerCase().equals("yes"))
					{
						userInputField.setVisible(false);
					}

					else
					{
						userInputField.setVisible(false);
						titleLabel.setText("<html>Well too bad. Game narrators have tight schedules and I don't have time for you to misspell your name again.</html>");
					}
					inputCounter = "tutorialClick";
					System.out.println("input coutner is now at: " + inputCounter);
					nextButton.setVisible(true);
				}//end firstClick

				else if(inputCounter.equals("tutorialClick"))
				{
					String wantTutorial = userInputField.getText();
					if(wantTutorial.toLowerCase().equals("yes"))
					{
						inputCounter = "tutorialClickTwo";
						userInputField.setVisible(false);
						titleLabel.setText("<html>Before you begin your Journey in this simulated world, there are a few things that you must know</html>");
						nextButton.setVisible(true);
					}
				}
			}//end tutorialClick

		});//end userInputField Action Listener

		nextButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(inputCounter.equals("tutorialClick"))
				{
					nextButton.setVisible(false);
					userInputField.setVisible(true);
					userInputField.setText("");
					titleLabel.setText("<html>Would you like to take the tutorial?</html>");
				}//end tutorialClick
				
				else if(inputCounter.equals("tutorialClickTwo"))
				{
					System.out.println(inputCounter);
					titleLabel.setText("<html>This game is just like any other RPG out there, but without any fancy graphics. And like other games of the same genre, dear player, there is a battle system!</html>");
					inputCounter = "tutorialClickThree";
				}
				
				else if(inputCounter.equals("tutorialClickThree"))
				{
					System.out.println(inputCounter);
					titleLabel.setText("<html>Now, let me think. What's an enemy that I should spawn that can't kill you instantly? Ah, yes! This will do the trick!</html>");
					inputCounter = "tutorialClickFour";
				}
				
				else if(inputCounter.equals("tutorialClickFour"))
				{
					System.out.println(inputCounter);
					setVisible(false);
				}
				
			}

		});//end nextButton Action Listener

	} //end createEvents()
}
