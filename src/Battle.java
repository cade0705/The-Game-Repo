import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class Battle
{
    public static String text;
    public static char[] charText;

    //Enemy Variables
    public static String enemyName;
    public static int enemyBaseHP;
    public static int enemyHP;
    public static int enemyATK;
    public static int enemyDEF;
    public static int enemyXP;
    
    //Player Variables
    public static String playerName;
    public static int playerBaseHP;
    public static int playerHP;
    public static int playerATK;
    public static int playerDEF;
    
    public static int turnCounter;
    
    public static void Start(Enemy enemy, Player player) throws InterruptedException
    {
        turnCounter = 1;
        Scanner userInput = new Scanner(System.in);
        
        //Initalize enemy variables
        enemyName = enemy.getName();
        enemyBaseHP = enemy.getHP();
        enemyHP = enemy.getHP();
        enemyATK = enemy.getATKPower();
        enemyDEF = enemy.getDEFPower();
        enemyXP = enemy.getXP();
        
        //Initalize player variables
        playerName = player.getName();
        playerBaseHP = player.getHP();
        playerHP = player.getHP();
        playerATK = player.getATK();
        playerDEF = player.getDEF();
        
        text = ("A wild " + enemyName + " appeared!");
        charText = text.toCharArray(); print(charText); delay(700);
        
        int battleLoop = 0;
        int turn = 0;
        int randomATK = 0;
        String choosenItem = "";
        
        while(battleLoop == 0)
        {
            while(turn == 0) //Player's turn
            {
                System.out.println("Turn " + turnCounter);
                text = ("Which item will you use?");
                charText = text.toCharArray(); print(charText); delay(700);
                
                System.out.println(Inventory.print());
                 
                String chosenItem = userInput.nextLine();
                
                //make sure the item exists in the player's inventory
                if(Inventory.checkItem(chosenItem) == true)
                {
                    //Deal damage to enemy if item is a weapon
                    if(Inventory.getItemType(chosenItem).equals("Weapon")) 
                    {
                        attackEnemy(player, Inventory.getItemATK(chosenItem));
                        if(checkEnemyDead() == true)
                        {
                            turn = 2; //Escape both while loops for player and enemy turns
                            battleLoop = 1; //End the battle loop
                            endBattle(player);
                        }
                        else
                        {
                            turn = 1;
                            turnCounter++;
                        }
                    }
                    
                    //Equip Armor
                    if(Inventory.getItemType(chosenItem).equals("Armor"))
                    {
                        int oldDEF = playerDEF;
                        player.equipArmor(Inventory.getItemDEF(chosenItem));
                        playerDEF = player.getDEF_WithArmor();
                        text = ("You equiped the " + chosenItem + ", changing your DEF from " + oldDEF + " to " + playerDEF);
                        charText = text.toCharArray(); print(charText); delay(700);
                        turn = 1;
                        turnCounter++;
                    }
                    
                    //Heal
                    if(Inventory.getItemType(chosenItem).equals("Food") && playerHP != playerBaseHP)
                    {
                        playerHP += Inventory.getItemHP(chosenItem);
                        if(playerHP > playerBaseHP)
                        {
                            playerHP = playerBaseHP;
                        }
                        text = ("Your HP is now " + playerHP + "/" + playerBaseHP);
                        charText = text.toCharArray(); print(charText); delay(700);
                        turn = 1;
                        turnCounter++;
                    }
                    
                    else if(Inventory.getItemType(chosenItem).equals("Food") && playerHP == playerBaseHP)
                    {
                        text = ("Your HP is full, it won't have any effect!");
                        charText = text.toCharArray(); print(charText); delay(700);
                    }
                }  
            
                else if(Inventory.checkItem(chosenItem) == false)
                {
                    text = "This item isn't in your inventory!";
                    charText = text.toCharArray(); print(charText); delay(700);
                }  
            }
        
            while(turn == 1)//Enemy's turn
            {
               randomATK = enemyATK; /*Implement random with range here*/
               if(randomATK == 0)
               {
                   text = (enemyName + "'s attack missed!");
                   charText = text.toCharArray(); print(charText); delay(700);
               }
               
               else
               {
                   attackPlayer(randomATK);
               }
               
               if(checkPlayerDead() == true)
               {
                   text = (enemyName + " defeated you!");
                   charText = text.toCharArray(); print(charText); delay(700);
                   
                   text = ("You begin to lose consciousness and slip into the darkness");
                   charText = text.toCharArray(); print(charText); delay(700);
                   
                   if(player.getVoiceCounter() == 0)
                   {
                       text = ("You hear a faint and unfamiliar voice");
                       charText = text.toCharArray(); print(charText); delay(700);
                       player.incrementVoiceCounter();
                   }
                   
                   else
                   {
                       text = ("A somehow familiar voice can be heard");
                       charText = text.toCharArray(); print(charText); delay(700);
                   }
                   
                   text = ("\"Will you accept my gift of another chance?\" The voice says");
                   charText = text.toCharArray(); print(charText); delay(700);
                   
                   String restart = (userInput.nextLine()).toLowerCase();
                   
                   if(restart.equals("yes"))
                   {
                       text = ("The battle is restarted");
                       charText = text.toCharArray(); print(charText); delay(700);
                       Battle.Start(enemy, player);
                   }
                   
                   else
                   {
                       text = ("\"I see that you don't have confidence in yourself.... Perhaps you can grow stronger by starting over\"");
                       charText = text.toCharArray(); print(charText); delay(700);
                       
                       text = ("The voice starts to fade out. \"I hope to see you again someday\"");
                       charText = text.toCharArray(); print(charText); delay(700);
                       
                       text = ("Game Over");
                       charText = text.toCharArray(); print(charText); delay(700);
                       text = (player.displayEndStats());
                       charText = text.toCharArray(); print(charText); delay(700);
                       return;//Why did I put this here?
                   }
               }
               
               else
               {
                   displayStats();
                   turn = 0;
                   System.out.println("\n\n\n");
               }
            }
        }
    }
    
    public static void attackPlayer(int enemyATK) throws InterruptedException
    {
        boolean missed = false;
        boolean crit = false;
        
        int damageDone = enemyATK - playerDEF; //enemyATK is the attack power
        
        if((Math.random()*41) <= 5)
        {
            missed = true;
        }
        else if((Math.random()*25) <= 5)
        {
            crit = true;
        }
        
        
        //Do Damage to the player
        if((enemyATK > playerDEF) && (missed == false) && (crit == false))
        {
            playerHP -= damageDone;
        }
        
        else if(missed == true)
        {
            text = (enemyName + "'s attack missed!");
            charText = text.toCharArray(); print(charText); delay(700);
        }
        
        else if(crit == true)
        {
            text = (enemyName + " landed a critical hit!");
            charText = text.toCharArray(); print(charText); delay(700);
            damageDone += (Math.random() * (enemyATK) + 1);
            playerHP -= damageDone;
        }
        
        else
        {
            damageDone = 1;
            playerHP -= damageDone;
            text = (enemyName + " is weak and could only do little damage to you");
            charText = text.toCharArray(); print(charText); delay(700);
        }
        
        if(missed == false)
        {
            text = (enemyName + " dealt " + damageDone + " damage to you!");
            charText = text.toCharArray(); print(charText); delay(700);
        }
    }
    
    public static void attackEnemy(Player player, int weaponAttackPower) throws InterruptedException
    {
        int attackPower = weaponAttackPower + playerATK;
        int damageDone = attackPower - enemyDEF;
        boolean missed = false;
        boolean crit = false;
        
        if((Math.random()*41) <= 5)
        {
            missed = true;
        }
        else if((Math.random()*25) <= 5)
        {
            crit = true;
        }
        
        if((attackPower > enemyDEF) && (missed == false) && (crit == false))
        {
            enemyHP -= damageDone;
        }
        else if(missed == true)
        {
            text = ("Your attack missed!");
            charText = text.toCharArray(); print(charText); delay(700);
        }
        else if(crit == true)
        {
            text = ("You landed a critical hit!");
            charText = text.toCharArray(); print(charText); delay(700);
            damageDone += (Math.random()*(playerATK) + 1);
            enemyHP -= damageDone;
        }
        else
        {
            damageDone = 1;
            enemyHP -= damageDone;
            text = ("Your attack power was too weak to do much damage");
            charText = text.toCharArray(); print(charText); delay(700);
        }
        
        if(missed == false)
        {
            text = ("You dealt " + damageDone + " damage to " + enemyName + "!");
            charText = text.toCharArray(); print(charText); delay(700);
        }
    }
    
    public static boolean checkEnemyDead() //Check if the enemy has died
    {
        boolean isDead = false;
        if(enemyHP <= 0)
        {
            isDead = true;
        }
        return isDead;
    }
    
    public static boolean checkPlayerDead()
    {
        boolean isDead = false;
        if(playerHP <= 0)
        {
            isDead = true;
        }
        return isDead;
    }
    
    public static void endBattle(Player player) throws InterruptedException //End the battle if the enemy or player is dead
    {
        text = (enemyName + " was defeated!");
        charText = text.toCharArray(); print(charText); delay(700);  
        player.addXP(enemyXP);
    }
        
    public static void displayStats() throws InterruptedException
    {
        text = ("Enemy HP: " + enemyHP + "/" + enemyBaseHP);
        charText = text.toCharArray(); print(charText); delay(700);
        
        text = ("Your HP: " +  playerHP + "/" + playerBaseHP);
        charText = text.toCharArray(); print(charText); delay(700);
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
           System.out.println("Something went wrong");
       }
    }
}