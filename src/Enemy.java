import java.util.ArrayList;
public class Enemy
{
    //Add an attack class and make an attack array or  array list
    // instance variables 
    private String name;
    private int HP;
    private int ATK;
    private int DEF;
    private int XP;
        
    //Zero Arg Constructor
    public Enemy()
    {
        name = "El Gato";
        HP = 9999;
        ATK = 9999;
        DEF = 9999;
        XP = 999;
    }
    
    //Multi Arg Constructor
    public Enemy(String name, int HP, int ATK, int DEF, int XP)
    {
        this.name = name;
        this.HP = HP;
        this.ATK = ATK;
        this.DEF = DEF;
        this.XP = XP;
    }

    
    //Getters n' Setters
    public String getName()
    {
        return name;
    }
    
    public int getHP()
    {
        return HP;
    }
    
    public int getATKPower()
    {
        return ATK;
    }   
    
    public int getDEFPower()
    {
        return DEF;
    }
    
    public int getXP()
    {
        return XP;
    }
    
    //toString()
    public String toString()
    {
        String output = name + "\tHP: " + HP + "\tATK: " + ATK + "\tDEF: " + DEF;
        return output;
    }
}