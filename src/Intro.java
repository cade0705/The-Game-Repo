import java.util.Scanner;
/*Easter Eggs
*Find an abandonded hotel in the forest and if the player's name is "Trivago" then say that they could use their name to get a great price for a room if it was still open.

*Additional Notes
*Hint at Trivago name - if this is their name ask how the hell they managed to possibly know this was a thing
*Narrator is the final boss - each path has key words that form sentence to defeat his final while loop attack
*Add something to every path that hints at a response to give in a different path
*If their name is moron at the end of the game, they can't win anyways (from counter variable)
*Make a room of easter eggs so that the player can discover all of them
*/
public class Intro
{
   //Class Variables
   public static String text;
   public static char[] charText;
   public static String playerName;
   public static Scanner userInput;
   public static int counter;
   public static Player thePlayer;
   
   public static void start() throws InterruptedException
   {
       System.out.println("Please note that this is only a Dev build of the game (1.3.1) and does not reflect the final version");
       intro();
       tutorial();
       choosePath();
       charText = text.toCharArray(); print(charText); delay(700);
       //ChoosePath();
   }
   
   public static void intro() throws InterruptedException
   {
       userInput = new Scanner(System.in);
       
       String skipIntro = "";
       counter = 0;
       boolean correctPlayerInfo = false;
       playerName = "";
       
       text = ("Would you like to skip the intro?");
       charText = text.toCharArray(); print(charText); delay(700);
       
       skipIntro = (userInput.nextLine().toLowerCase());
       
       if(skipIntro.equals("n"))
       {
           text = ("Aproaching the mountain of mild doom, you draw your sword and continue forward; sweat dripping down your face...");
           charText = text.toCharArray(); print(charText); delay(500);
            
           text = ("Wait, that's a bit too cliché....");
           charText = text.toCharArray(); print(charText); delay(700);
            
           text = ("I know, i'll ask them instead");
           charText = text.toCharArray(); print(charText); delay(700);
            
           text = ("");
           charText = text.toCharArray(); print(charText); delay(700);
            
           text = ("");
           charText = text.toCharArray(); print(charText); delay(700);
            
           text = ("Hello there valued player!");
           charText = text.toCharArray(); print(charText); delay(700);
       }
        
       while(correctPlayerInfo == false) //Keeps asking user for info if they keep saying it's incorrect
       {
           text = ("What is your name?");
           charText = text.toCharArray(); print(charText); delay(700);
           playerName = userInput.nextLine();
           
           //Link easter egg
           if(playerName.equals(""))
           {
               playerName = "Link";
               text = ("Looks like we have a case of silent protagonist over here");
               charText = text.toCharArray(); print(charText); delay(700); 
               text = ("I'll give you a more appropriate name since you can't provide one yourself");
               charText = text.toCharArray(); print(charText); delay(700);
           }
            
           text = ("Is " + playerName + " really the name that you want?");
           charText = text.toCharArray(); print(charText); delay(700);
            
           String isCorrect = (userInput.nextLine().toLowerCase());
           System.out.println(isCorrect);
          
           if(isCorrect.equals("y"))
           {
               correctPlayerInfo = true;
           }
           else if(isCorrect.equals("n"))
           {
               text = ("I bet you would like to change your name then?");
               charText = text.toCharArray(); print(charText); delay(700);
               text = ("Well too bad!");
               charText = text.toCharArray(); print(charText); delay(700);
               text = ("I can tell that you are a difficult person and will keep saying no just to waste my time");
               charText = text.toCharArray(); print(charText); delay(700);
               text = ("To prevent this, I will simply name you \"Moron\"");
               charText = text.toCharArray(); print(charText); delay(700);
               text = ("Don't think that you can simply go through the game without this name coming up again because it will");
               charText = text.toCharArray(); print(charText); delay(700);
               text = ("over");
               charText = text.toCharArray(); print(charText); delay(700);
               text = ("and over");
               charText = text.toCharArray(); print(charText); delay(700);
               text = ("and over again");
               charText = text.toCharArray(); print(charText); delay(700);
               text = ("until you reset the game out of pure humiliation for yourself or to skip this unnecesarily long rant");
               charText = text.toCharArray(); print(charText); delay(700);
               text = ("I suppose that's enough bieckering from my part");
               charText = text.toCharArray(); print(charText); delay(700);
               text = ("You may proceed, Moron");
               charText = text.toCharArray(); print(charText); delay(700);
               playerName = "Moron";
               correctPlayerInfo = true;
           }
           thePlayer = new Player(playerName);
       }
   }
   
   public static void tutorial() throws InterruptedException
   {
       text = ("If by some chance you are a time traveler and have already done the tutorial or you think that you know everything and don't need it, you may skip it");
       charText = text.toCharArray(); print(charText); delay(700);
       text = ("Skip tutorial?");
       charText = text.toCharArray(); print(charText); delay(700);
       boolean correctTutorialResponse = false;
       String skipTutorial = (userInput.nextLine().toLowerCase());
       
       while(correctTutorialResponse == false)
       {
           if(skipTutorial.equals("n") || skipTutorial.equals("no"))
           {
               correctTutorialResponse = true;
               
               text = ("Before you go running off on your adventure, there are still a few things you need to know");
               charText = text.toCharArray(); print(charText); delay(700);
               text = ("First of all, this land is inhabited by magical creatures called");
               charText = text.toCharArray(); print(charText); delay(700);
               text = ("Wait, that's the wrong game");
               charText = text.toCharArray(); print(charText); delay(700);
               text = ("Anayways, along your adventure you will explore new lands and encounter dangerous enemies");
               charText = text.toCharArray(); print(charText); delay(700);
               text = ("Of course, the best way to teach these sort of things is from a hands on experience!");
               charText = text.toCharArray(); print(charText); delay(700);
               text = ("Let's see, which enemy should I summon?");
               charText = text.toCharArray(); print(charText); delay(700);
               text = ("AHA! That one will do. It's very weak like yourself");
               charText = text.toCharArray(); print(charText); delay(700);
               text = ("LET THE BATTLE BEGIN!!!");
               charText = text.toCharArray(); print(charText); delay(700);
               
               Enemy tutorialEnemy = new Enemy("Tutorial Enemy", 25, 3, 3, 10);
               
               Weapon tutorialWeapon = new Weapon("Sword", "Weapon", 4);
               Armor tutorialArmor = new Armor("Helmet", "Armor", 3);
               Food tutorialFood = new Food("Apple", "Food", 5);
               
               Inventory.addItem(tutorialWeapon);
               Inventory.addItem(tutorialArmor);
               Inventory.addItem(tutorialFood);
               
               TutorialBattle.Start(tutorialEnemy, thePlayer);
               
               text = ("Congratulations, you have completed the tutorial!");
               charText = text.toCharArray(); print(charText); delay(700);
               text = ("Achievement Unlocked: \"Training Wheels\"");
               charText = text.toCharArray(); print(charText); delay(700);
               
               thePlayer.addAchievement("Training Wheels| You completed an easy task; have a gold star!"); //Achievement

               text = ("I beleive that you are ready to go on your adventure, " + playerName);
               charText = text.toCharArray(); print(charText); delay(700);
               text = ("Unfortunately, those items were only for you to borrow and I must take them away");
               charText = text.toCharArray(); print(charText); delay(700);
               text = ("However, it's dangerous to go alone, take this!");
               charText = text.toCharArray(); print(charText); delay(700);
               text = ("You recieved a Rusty Sword!");
               charText = text.toCharArray(); print(charText); delay(700);
               
               Weapon rustySword = new Weapon("Rusty Sword", "Weapon", 2);
               Inventory.addItem(rustySword);
               
               Inventory.removeItem(tutorialWeapon);
               Inventory.removeItem(tutorialArmor);
               Inventory.removeItem(tutorialFood);
           }
           
           else if(skipTutorial.equals("y") || skipTutorial.equals("yes"))
           {
               correctTutorialResponse = true;
               text = ("Achievement Unlocked: \"Time Traveler\"");
               charText = text.toCharArray(); print(charText); delay(700);
               
               thePlayer.addAchievement("Time Traveler| Use your powers of space and time to skip the tutorial. In other words, answer \"yes\" to skipping it");
               
               text = ("You deserve some XP for that marvelous achievement");
               charText = text.toCharArray(); print(charText); delay(700);
               thePlayer.addXP(10);
           }
       }
   }
   
   public static void choosePath()throws InterruptedException
   {
       boolean choosePath;
       String unchangedPlayerPath = "";
       String playerPath = "";
       
       text = ("So " + playerName + ", " + " where would you like to go?");
       charText = text.toCharArray(); print(charText); delay(700);
       
       choosePath = false;
       while(choosePath == false) //Loops until the user chooses a valid path
       {
           text = ("rainforest, island, or pirate");
           charText = text.toCharArray(); print(charText); delay(700);
           unchangedPlayerPath = userInput.nextLine();
           playerPath = unchangedPlayerPath.toLowerCase();
           if(playerPath.equals("rainforest"))
           {
               choosePath = true;
               //ForestPath.start();
           }
           else if(playerPath.equals("island"))
           {
               text = ("Cade was too lazy to add anything to this opiton");
               charText = text.toCharArray(); print(charText); delay(700);
               //Call to a method with an island adventure
               choosePath = true;
           }
           else if(playerPath.equals("pirate"))
           {
               text = ("Cade was too lazy to add anything to this option");
               charText = text.toCharArray(); print(charText); delay(700);
               //Call to a method with a pirate adventure
               choosePath = true;
           }
           else if(counter == 2) //takes ""messup" value from Intro() and scolds the user if they mess up again.
           {
               text = ("You've got to be kidding me! First you mess up on your basic information and then you can't answer " +
               "these simple questions either");
               charText = text.toCharArray(); print(charText); delay(700);
               text = ("You really are a " + playerName + " as your name suggests");
               charText = text.toCharArray(); print(charText); delay(700);
               counter++;
           }
           else
           {
               text = ("I'll ask again");
               charText = text.toCharArray(); print(charText); delay(700);
           }
           text = ("");
           charText = text.toCharArray(); print(charText); delay(700);
           text = ("");
           charText = text.toCharArray(); print(charText); delay(700);
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