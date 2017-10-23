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

public class WindowManager extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblTheGame = new JLabel("The Game");
		lblTheGame.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		contentPane.add(lblTheGame, BorderLayout.NORTH);
		
		setTitle("The Game");
	}
	
	//////////////////////////////////////////////////////////
	//This method handles all of the events
	//////////////////////////////////////////////////////////
	public void createEvents()
	{
		
	}
	

}
