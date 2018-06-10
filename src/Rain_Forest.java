import java.util.Scanner;

public class Rain_Forest 
{
	public static String text;
	   public static char[] charText;
	   public static String playerName = Intro.playerName;
	   public static Scanner userInput;
	   public static int counter;
	   public static Player thePlayer = Intro.thePlayer;
	   
	public static void start() throws InterruptedException
	{
		userInput = new Scanner(System.in);
		text = "You are traveling through the dangerous rainforests of Australia";
		charText = text.toCharArray(); print(charText); delay(700);
		text = "While you were on your phone, you lose track of your guide and try to find your way back to civilization";
		charText = text.toCharArray(); print(charText); delay(700);
		text = "You come to a fork in the road after a few minutes of walking";
		charText = text.toCharArray(); print(charText); delay(700);
		
		boolean validChoice = false;
		
		while(validChoice == false)
		{
			text = "Which direction will you go? North, South, East, or West?";
			charText = text.toCharArray(); print(charText); delay(700);
			String firstChoice = (userInput.nextLine().toLowerCase());
			
			//FC North
			if(firstChoice.equals("north") || firstChoice.equals("n"))
			{
				text = "You chose North!";
				charText = text.toCharArray(); print(charText); delay(700);
				validChoice = true;
			}
			//FC South
			else if(firstChoice.equals("south") || firstChoice.equals("s"))
			{
				System.out.println("SOUTH");
				validChoice = true;
			}
			//FC East
			else if(firstChoice.equals("east") || firstChoice.equals("e"))
			{
				System.out.println("EAST");
				validChoice = true;

			}
			// FC West
			else if(firstChoice.toLowerCase().equals("west") || firstChoice.toLowerCase().equals("w"))
			{
				System.out.println("WEST");
				validChoice = true;
			}
			else
			{
				text = "That's not a correct choice";
				charText = text.toCharArray(); print(charText); delay(700);
			}
		}
	}
	
	public static void print(char[] chars) throws InterruptedException
	   {
	       for(int i = 0; i < chars.length; i++)
	       {
	           System.out.print(chars[i]);
	           Thread.sleep(65);
	       }
	       System.out.println();
	   }
	   
	   public static void delay(int millis)
	   {
	       try
	       {
	           Thread.sleep(millis);
	       }
	       catch(InterruptedException exp)
	       {
	           System.out.println("DEADBEEF");
	       }
	   }
}
