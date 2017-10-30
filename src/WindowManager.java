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

public class WindowManager extends JFrame {

	private JPanel contentPane;
	private JButton creditsButton;
	private JButton startButton;
	private JLabel titleLabel;
	private JLabel cadeCreditLabel;
	private JLabel specialThanksLabel;
	private JButton backToTitleButton;

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
					WindowManager frame = new WindowManager();
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
	public WindowManager() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(WindowManager.class.getResource("/WindowBuilder/Resources/El Gato.png")));
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
		
		creditsButton = new JButton("Credits");
		
		creditsButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		cadeCreditLabel = new JLabel("Programming / Design / Story: Cade Culbertson");
		cadeCreditLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cadeCreditLabel.setVisible(false);
		
		specialThanksLabel = new JLabel("Special Thanks: David Detweiler, Austin Stead, Stackoverflow.com");
		specialThanksLabel.setHorizontalAlignment(SwingConstants.CENTER);
		specialThanksLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		specialThanksLabel.setVisible(false);
		
		backToTitleButton = new JButton("Back To Title Screen");
		backToTitleButton.setVisible(false);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(99)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(50)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(creditsButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
								.addComponent(startButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))
							.addGap(268))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(specialThanksLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(cadeCreditLabel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 592, Short.MAX_VALUE))
							.addGap(186))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(160)
					.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 427, Short.MAX_VALUE)
					.addGap(290))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(backToTitleButton, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(609, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(titleLabel)
					.addGap(11)
					.addComponent(cadeCreditLabel)
					.addGap(2)
					.addComponent(specialThanksLabel)
					.addGap(26)
					.addComponent(startButton, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(creditsButton, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
					.addComponent(backToTitleButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
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
				backToTitleButton.setVisible(true);
			}
		});//end creditsButton Action Listener
		
		backToTitleButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				backToTitleButton.setVisible(false);
				cadeCreditLabel.setVisible(false);
				specialThanksLabel.setVisible(false);
				titleLabel.setVisible(true);
				startButton.setVisible(true);
				creditsButton.setVisible(true);
			}
		});//end backToTitleButton Action Listener
	} //end createEvents()
}
