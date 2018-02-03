import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class BattleScreen extends JFrame {

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
					BattleScreen frame = new BattleScreen();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BattleScreen() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(BattleScreen.class.getResource("/WindowBuilder/Resources/El Gato.png")));
		setResizable(false);
		initComponents();
	}
	
	public void initComponents()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnemyHp = new JLabel("Enemy HP:");
		lblEnemyHp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnemyHp.setBounds(10, 11, 119, 37);
		contentPane.add(lblEnemyHp);
		
		JLabel enemyHPNumber = new JLabel("");
		enemyHPNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		enemyHPNumber.setBounds(103, 22, 66, 14);
		contentPane.add(enemyHPNumber);
		
		JLabel lblYourHp = new JLabel("Your HP:");
		lblYourHp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblYourHp.setBounds(10, 49, 119, 37);
		contentPane.add(lblYourHp);
		
		JLabel label_1 = new JLabel("");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(103, 59, 66, 20);
		contentPane.add(label_1);
	}
}
