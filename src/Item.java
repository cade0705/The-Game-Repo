public abstract class Item
{
    // instance variables
    private String name;
    private String type;
    private int ATK;

    //Zero Arg Constructor
    public Item()
    {
        name = "???";
        type = "???";
    }
    
    //Multi Arg Constructor
    public Item(String name, String type)
    {
        this.name = name;
        this.type = type;
    }
    
    //Getters
    public String getName()
    {
        return name;
    }
    
    public int getATK()
    {
        return Weapon.publicAttackPower;
    }
    
    public String getType()
    {
        return type;
    }
    
    public int getHP()
    {
        return Food.publicHP_Restore;
    }
    
    public int getDEF()
    {
        return Armor.publicDefPoints;
    }
    
    //toString()
    public String toString()
    {
        String output = name + "\t" + type + "\t\t";
        return output;
    }
}
