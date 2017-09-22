public class Armor extends Item
{
    // instance variables
    private int defPoints;
    public static int publicDefPoints;
    private boolean isEquipped;

    //Zero Arg Constructor
    public Armor()
    {
        super();
        defPoints = 9999;
    }
    
    //Multi Arg Constructor
    public Armor(String name, String type, int defPoints)
    {
        super(name, type);
        this.defPoints = defPoints;
        this.isEquipped = false;
        publicDefPoints = defPoints;
    }
    
    public int getDEF()
    {
        return defPoints;
    }
    
    //ToString()
    public String toString()
    {
        String output = super.toString() + "DEF: " + defPoints;
        return output;
    }
}
