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
   public static String playerName;
   public static int counter;
   public static Player thePlayer;
   
   public static void start() 
   {
       intro();
       //tutorial();
   }
   
   public static void intro() 
   {
       counter = 0;
       boolean correctPlayerInfo = false;
       playerName = "";
     
     
       /*correctPlayerInfo = false;
       
       while(correctPlayerInfo == false) //Keeps asking user for info if they keep saying it's incorrect
       {          
           gameDriver.changeText("What is your name?");
           
           playerName = JOptionPane.showInputDialog(gameDriver.gameWindow, "What is your name");
           
           //Link easter egg
           if(playerName.equals(""))
           {
               playerName = "Link";
               gameDriver.changeText("Looks like we have a case of silent protagonist over here");
              
               gameDriver.changeText ("I'll give you a more appropriate name since you can't provide one yourself");
           }
            
           gameDriver.changeText("Is " + playerName + " really the name that you want?");
            
           String isCorrect = JOptionPane.showInputDialog(gameDriver.gameWindow, "Is this the name that you really want?");
           if(isCorrect.toLowerCase().equals("yes"))
           {
               correctPlayerInfo = true;
           }
           else 
           {
               gameDriver.changeText("I bet you would like to change your name then?");
               gameDriver.changeText("Well too bad!");
               gameDriver.changeText("I can tell that you are a difficult person and will keep saying no just to waste my time");
               gameDriver.changeText("To prevent this, I will simply name you \"Moron\"");
               gameDriver.changeText("Don't think that you can simply go through the game without this name coming up again because it will");
               gameDriver.changeText("over");
               gameDriver.changeText("and over");
               gameDriver.changeText("and over again");
               gameDriver.changeText("until you reset the game out of pure humiliation for yourself or to skip this unnecesarily long rant");
               gameDriver.changeText("I suppose that's enough bieckering from my part");
               gameDriver.changeText("You may proceed, Moron");
               
               playerName = "Moron";
               correctPlayerInfo = true;
               
           }
           thePlayer = new Player(playerName);
       }*/
   }
   
   public static void tutorial()
   {
       /*gameDriver.changeText = ("If by some chance you are a time traveler and have already done the tutorial or you think that you know everything and don't need it, you may skip it");
       
       gameDriver.changeText = ("Skip tutorial?");
       
       boolean correctTutorialResponse = false;
       String skipTutorial = (userInput.nextLine().toLowerCase());
       
       while(correctTutorialResponse == false)
       {
           if(skipTutorial.equals("n") || skipTutorial.equals("no"))
           {
               correctTutorialResponse = true;
               
               gameDriver.changeText = ("Before you go running off on your adventure, there are still a few things you need to know");
               
               gameDriver.changeText = ("First of all, this land is inhabited by magical creatures called");
               
               gameDriver.changeText = ("Wait, that's the wrong game");
               
               gameDriver.changeText = ("Anayways, along your adventure you will explore new lands and encounter dangerous enemies");
               
               gameDriver.changeText = ("Of course, the best way to teach these sort of things is from a hands on experience!");
               
               gameDriver.changeText = ("Let's see, which enemy should I summon?");
               
               gameDriver.changeText = ("AHA! That one will do. It's very weak like yourself");
               
               gameDriver.changeText = ("LET THE BATTLE BEGIN!!!");
               
               
               Enemy tutorialEnemy = new Enemy("Tutorial Enemy", 25, 3, 3, 10);
               
               Weapon tutorialWeapon = new Weapon("Sword", "Weapon", 4);
               Armor tutorialArmor = new Armor("Helmet", "Armor", 3);
               Food tutorialFood = new Food("Apple", "Food", 5);
               
               Inventory.addItem(tutorialWeapon);
               Inventory.addItem(tutorialArmor);
               Inventory.addItem(tutorialFood);
               
               TutorialBattle.Start(tutorialEnemy, thePlayer);
               
               gameDriver.changeText = ("Congratulations, you have completed the tutorial!");
               
               gameDriver.changeText = ("Achievement Unlocked: \"Training Wheels\"");
               
               
               thePlayer.addAchievement("Training Wheels| You completed an easy task; have a gold star!"); //Achievement

               gameDriver.changeText = ("I beleive that you are ready to go on your adventure, " + playerName);
               
               gameDriver.changeText = ("Unfortunately, those items were only for you to borrow and I must take them away");
               
               gameDriver.changeText = ("However, it's dangerous to go alone, take this!");
               
               gameDriver.changeText = ("You recieved a Rusty Sword!");
               
               
               Weapon rustySword = new Weapon("Rusty Sword", "Weapon", 2);
               Inventory.addItem(rustySword);
               
               Inventory.removeItem(tutorialWeapon);
               Inventory.removeItem(tutorialArmor);
               Inventory.removeItem(tutorialFood);
           }
           
           else if(skipTutorial.equals("y") || skipTutorial.equals("yes"))
           {
               correctTutorialResponse = true;
               gameDriver.changeText = ("Achievement Unlocked: \"Time Traveler\"");
               
               
               thePlayer.addAchievement("Time Traveler| Use your powers of space and time to skip the tutorial. In other words, answer \"yes\" to skipping it");
               
               gameDriver.changeText = ("You deserve some XP for that marvelous achievement");
               
               thePlayer.addXP(10);
           }
       }*/
   }
   
   public static void ChoosePath()
   {
       boolean choosePath;
       
       
       /*
       choosePath = false;
       while(choosePath == false) //Loops until the user chooses a valid path
       {
           gameDriver.changeText = ("rainforest, island, or pirate");
           
           unchangedPlayerPath = userInput.nextLine();
           playerPath = unchangedPlayerPath.toLowerCase();
           if(playerPath.equals("rainforest"))
           {
               choosePath = true;
               ForestPath.start();
           }
           else if(playerPath.equals("island"))
           {
               gameDriver.changeText = ("Cade was too lazy to add anything to this opiton");
               
               //Call to a method with an island adventure
               choosePath = true;
           }
           else if(playerPath.equals("pirate"))
           {
               gameDriver.changeText = ("Cade was too lazy to add anything to this option");
               
               //Call to a method with a pirate adventure
               choosePath = true;
           }
           else if(counter == 2) //takes ""messup" value from Intro() and scolds the user if they mess up again.
           {
               gameDriver.changeText = ("You've got to be kidding me! First you mess up on your basic information and then you can't answer " +
               "these simple questions either");
               
               gameDriver.changeText = ("You really are a " + playerName + " as your name suggests");
               
               counter++;
           }
           else
           {
               gameDriver.changeText = ("I'll ask again");
               
           }
           gameDriver.changeText = ("");
           
           gameDriver.changeText = ("");
           
       }*/
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