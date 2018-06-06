import java.util.Scanner;

public class Rain_Forest 
{
	public static String text;
	   public static char[] charText;
	   public static String playerName = Intro.playerName;
	   public static Scanner userInput;
	   public static int counter;
	   public static Player thePlayer = Intro.thePlayer;
	   
	public static void start()
	{
		System.out.println("check");
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
