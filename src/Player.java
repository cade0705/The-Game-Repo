import java.util.ArrayList;
public class Player
{
    // instance variables
    private String name;
    private int HP;
    private int DEF;
    private int DEF_WithArmor;
    private int ATK;
    private int XP;
    private int LVL;
    private int voiceCounter;
    
    //Class variables
    public static String text;
    public static char[] charText;
    public static ArrayList<String>achievements;

    //Zero arg constructor
    public Player()
    {
        name = "Test";
        HP = 9999;
        XP = 0;
        LVL = 99;
        DEF = 999;
        ATK = 999;
    }
    
    public Player(String name)
    {
        this.name = name;
        HP = 10;
        XP = 0;
        LVL = 0;
        DEF = 1;
        ATK = 1;
        voiceCounter = 0;
        achievements = new ArrayList<String>();
    }
    
    public void equipArmor(int armorDEF)
    {
        DEF_WithArmor = DEF + armorDEF;
    }
    
    //Getters N' Setters
    
    //Getters
    public int getVoiceCounter()
    {
        return voiceCounter;
    }
    
    public int getDEF()
    {
        return DEF;
    }
    
    public int getDEF_WithArmor()
    {
        return DEF_WithArmor;
    }
    
    public int getATK()
    {
        return ATK;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getHP()
    {
        return HP;
    }
    
    public int getXP()
    {
        return XP;
    }
    
    public int getLVL()
    {
        return LVL;
    }
    
    public String getAchievements()
    {
        String output = "";
        for(int i = 0; i < achievements.size(); i++)
        {
            output += achievements.get(i) + "\n";
        }
        return output;
    }
    
    //Setters
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setHP(int HP)
    {
        this.HP = HP;
    }
    
    public void setXP(int XP)
    {
        this.XP = XP;
    }
    
    public void setLVL(int LVL)
    {
        this.LVL = LVL;
    }
    
    public void incrementVoiceCounter()
    {
        voiceCounter++;
    }    
    
    public void addAchievement(String incomingAchievement)
    {
        achievements.add(incomingAchievement);
    }
    
    
    //Achievements and stats
    public String displayEndStats()
    {
        String output = "";
        output += "\tFinal Player Stats \n";
        output+= "Player Name: " + this.getName() + "\n";
        output+= "LVL: " + this.getLVL() + "\n";
        output+= "Total XP: " + this.getXP() + "\n\n"; 
        output+= "-----------------------------------Achievements-----------------------------------\n";
        output+= getAchievements();
        return output;
    }
    
    public void addXP(int XPAdded) throws InterruptedException
    {
        text = ("You gained " + XPAdded + " XP"); 
        charText = text.toCharArray(); print(charText); delay(700);
        XP+= XPAdded;
        
        //XP needs to be determined for each level
        if(LVL == 0 && XP >= 10)
        {
            levelUp();
        }
        
        else if(LVL == 1 && XP >= 60)
        {
            levelUp();
        }
        else if(LVL == 2 && XP >= 60)
        {
            levelUp();
        }
        else if(LVL == 3 && XP >= 60)
        {
            levelUp();
        }
        else if(LVL == 4 && XP >= 60)
        {
            levelUp();
        }
        else if(LVL == 5 && XP >= 60)
        {
            levelUp();
        }
    }
    
     public void levelUp() throws InterruptedException
    {
        LVL++;
        
        text = ("Your level increased to " + LVL); 
        charText = text.toCharArray(); print(charText); delay(700);
        
        HP += 5;
        ATK += 1;
        DEF += 1;
        text = ("New HP: " + HP);
        charText = text.toCharArray(); print(charText); delay(700);
        
        text = ("New ATK: " + ATK);
        charText = text.toCharArray(); print(charText); delay(700);
        
        text = ("New DEF: " + DEF);
        charText = text.toCharArray(); print(charText); delay(700);
    }
    
    public String toString()
    {
       String output = "Name: " + name + "\nHP: " + HP + "\nXP: " + XP + "\nLVL: " + LVL;
       return output;
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