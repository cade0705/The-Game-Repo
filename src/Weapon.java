public class Weapon extends Item
{
    // instance variables 
    private int attackPower;
    public static int publicAttackPower;
    

    //Zero Arg Constructor
    public Weapon()
    {
        super("???", "???");
        attackPower = 9999;
    }
    
    //Multi Arg Constructor
    public Weapon(String name, String type, int attackPower)
    {
        super(name, type);
        this.attackPower = attackPower;
        publicAttackPower = attackPower;
    }
    
    public  int getATK()
    {
        return attackPower;
    }
    
    //toString()
    public String toString()
    {
        String output = super.toString() + "ATK Power: " + attackPower;
        return output;
    }
}
