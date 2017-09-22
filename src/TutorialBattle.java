import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class TutorialBattle
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
        
        boolean wantTutorial = true;
        String nextInput = "";
        int battleLoop = 0;
        int turn = 0;
        int randomATK = 0;
        String choosenItem = "";
        
       
        text = ("When you enter a battle, you will be taken to the item selection screen");
        charText = text.toCharArray(); print(charText); delay(700);
        text = ("It looks like this");
        charText = text.toCharArray(); print(charText); delay(700);
        System.out.println(Inventory.print());
        text = ("Because I'm nice, I went ahead and gave you a few items");
        charText = text.toCharArray(); print(charText); delay(700);
        text = ("However, before you jump into battle, there are a few things that I need to explain first");
        charText = text.toCharArray(); print(charText); delay(700);
        text = ("There are three types of items; weapons, armor, and food");
        charText = text.toCharArray(); print(charText); delay(700);
        text = ("A weapon does damage to an enemy based on its attack power and your attack power combined");
        charText = text.toCharArray(); print(charText); delay(700);
        text = ("However, the enemy's defense points also subtract from the combined attack power");
        charText = text.toCharArray(); print(charText); delay(700);
        text = ("I know what your thinking; \"but all wise narrator, what if the combined attack power is less than the enemy's DEF?\"");
        charText = text.toCharArray(); print(charText); delay(700);
        text = ("Not to worry! If for some reason this is the case, then you will deal a measly 1 damage");
        charText = text.toCharArray(); print(charText); delay(700);
        text = ("Press ENTER to contine");
        charText = text.toCharArray(); print(charText); delay(700);
        nextInput = userInput.nextLine();
        text = ("");
        charText = text.toCharArray(); print(charText); delay(700);
        text = ("");
        charText = text.toCharArray(); print(charText); delay(700);
        text = ("Next is armor. When you equp armor, it adds its total defense points (DEF) to yours");
        charText = text.toCharArray(); print(charText); delay(700);
        text = ("Furthermore, when an enemy attacks you, it will deal damage to you like you deal damage to it");
        charText = text.toCharArray(); print(charText); delay(700);
        text = ("by doing damage to you based off of its ATK minus your DEF");
        charText = text.toCharArray(); print(charText); delay(700);
        text = ("Press ENTER to continue");
        charText = text.toCharArray(); print(charText); delay(700);
        nextInput = userInput.nextLine();
        text = ("");
        charText = text.toCharArray(); print(charText); delay(700);
        text = ("");
        charText = text.toCharArray(); print(charText); delay(700);
        text = ("Next, we have food");
        charText = text.toCharArray(); print(charText); delay(700);
        text = ("Food can be eaten to regain HP during battle");
        charText = text.toCharArray(); print(charText); delay(700);
        text = ("However, unlike weapons and armor, food will be consumed and dissapear after a single use");
        charText = text.toCharArray(); print(charText); delay(700);
        text = ("Press ENTER to continue");
        text = ("");
        charText = text.toCharArray(); print(charText); delay(700);
        text = ("");
        charText = text.toCharArray(); print(charText); delay(700);
        nextInput = userInput.nextLine();
        charText = text.toCharArray(); print(charText); delay(700);
        text = ("Finally, sometimes you or the enemy will land a critical hit or miss");
        charText = text.toCharArray(); print(charText); delay(700);
        text = ("The odds of these happening are randomized and, in the case of a critical hit, the damage done is also random");
        charText = text.toCharArray(); print(charText); delay(700);
            

        text = ("It's time to battle");
        charText = text.toCharArray(); print(charText); delay(700);
        text = ("Good luck");
        charText = text.toCharArray(); print(charText); delay(700);
        
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
                   
                   text = ("Suddenly, you awake to the narrator's voice");
                   charText = text.toCharArray(); print(charText); delay(700);
                   
                   text = ("Did that really just happen?");
                   charText = text.toCharArray(); print(charText); delay(700);
                   
                   text = ("You died on the tutorial battle");
                   charText = text.toCharArray(); print(charText); delay(700);
                   
                   text = ("Nobody has ever done that, so that means that you must be the most idiotic person in the world");
                   charText = text.toCharArray(); print(charText); delay(700);
                   
                   text = ("Here, i'll Reset it for you");
                   charText = text.toCharArray(); print(charText); delay(700);
                   
                   TutorialBattle.Start(enemy, player);
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
        text = ("Every time you defeat an enemy, you earn XP!");
        charText = text.toCharArray(); print(charText); delay(700);  
        text = ("The more powerful an enemy is, the more XP you earn");
        charText = text.toCharArray(); print(charText); delay(700);  
        text = ("The more XP you earn, the higher LVL you are");
        charText = text.toCharArray(); print(charText); delay(700); 
        text = ("The higher LVL you are, the more powerful you become!");
        charText = text.toCharArray(); print(charText); delay(700);  
        text = ("It looks like you earned 10 XP, which is enough to level up to LVL 1!");
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