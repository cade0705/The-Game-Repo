import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public abstract class WindowManager extends JFrame implements ActionListener 
{
    //Class Variables
    private static String userInput;
    private static ArrayList<String> holder = new ArrayList<String>();
    public static JFrame gameWindow;
    public static Container con;
    public static Font titleFont;
    public static Font buttonFont;
    public static Font textFont;
    
    public static JTextField playerNameField;
    
    public static JPanel textPanel;
    public static JLabel textLabel;
    
    public static Timer timer;
    
    public static int counter = 0;
    public static void createWindow()
    {
        gameWindow = new JFrame(); //Creates a window
        con = new Container(); //Creates a container
        titleFont = new Font("Times New Roman", Font.PLAIN, 50);
        buttonFont = new Font("Times New Roman", Font.PLAIN, 25);
        textFont = new Font("Times New Roman", Font.PLAIN, 15);
        
        gameWindow.setSize(800, 600);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.getContentPane().setBackground(Color.black);
        
        /**
         * Assigns gameWindow JFrame as the base for the container
         */
        con = gameWindow.getContentPane(); 
        
        /**
         * Create the panel that the text will go on and the text itself (panel and label)
         */
        
        textPanel = new JPanel();
        textPanel.setBounds(10, 100, 800, 500); //(x, y, width, height) //Note that (0,0) is at top left of window
        textPanel.setBackground(Color.black); //Won't appear because same color
        
        textLabel = new JLabel("This is some text, woo!"); //JLabel used for text
        textLabel.setForeground(Color.white);
        textLabel.setFont(titleFont);
        
        textPanel.add(textLabel); //Adds the text to the panel
        con.add(textPanel); //Adds the panel to the container and the window

        /**
         * Create a panel for a start button
         */
        JPanel startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);
        
        /**
         * Create the actual button
         */
        JButton startButton = new JButton("Start");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(buttonFont);
        startButtonPanel.add(startButton);
        
        
        con.add(startButtonPanel);
        
        //Version Text
        JPanel versionPanel = new JPanel(); //Create a panel to put text onto
        versionPanel.setBounds(55, 500, 150, 100); //(x, y, width, height) //Note that (0,0) is at top left of window
        versionPanel.setBackground(Color.black); //Won't appear because same color
        
        JLabel versionLabel = new JLabel("Dev Build Version 1.3.2"); //JLabel used for text
        versionLabel.setForeground(Color.white);
        
        versionPanel.add(versionLabel); //Adds the text to the panel
        con.add(versionPanel); //Adds the panel to the container and the window
            
        playerNameField = new JTextField(10);
        con.add(playerNameField, BorderLayout.SOUTH);
        playerNameField.setVisible(false);
        
        //Makes the button actually do something
        startButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent event) 
            {
                startButton.setVisible(false);
                gameWindow.getContentPane().setBackground(Color.white);
                versionLabel.setForeground(Color.black);
                versionPanel.setBackground(Color.white);
                startButtonPanel.setBackground(Color.white);
                textPanel.setBackground(Color.white);
                textLabel.setForeground(Color.black);
                
                textLabel.setFont(textFont);
                Intro.start();
                gameWindow.setVisible(true);
            }

        });
        
        playerNameField.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
               playerNameField.setVisible(false);
               synchronized (holder) 
               {
                    holder.add(playerNameField.getText());
                    holder.notify();
               }
               
               holderMethod();
               Intro.playerName = userInput;
               textLabel.setVisible(true);
            }
        });
        gameWindow.setVisible(true);
    }
    
    public static void holderMethod()
    {
        synchronized (holder) 
        {
            // wait for input from field
            while (holder.isEmpty())
            {
                try
                {
                    holder.wait();
                }
                catch(InterruptedException e)
                {
                    
                }
            }
            userInput = holder.remove(0);
        }
    }
   
    public static void changeText(String newText)
    {    
    	textLabel.setText(newText);
        gameWindow.setVisible(true);        
    }
    
    public static void clearText()
    {
        textLabel.setText("");
    }
}