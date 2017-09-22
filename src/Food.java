public class Food extends Item
{
    // instance variables
    private int HP_Restore;
    public static int publicHP_Restore;
    
    //Zero Arg Constructor
    public Food()
    {
        super();
        HP_Restore = 9999;
        publicHP_Restore = HP_Restore;
    }

    //Multi Arg Constructor
    public Food(String name, String type, int HP_Restore)
    {
        super(name, type);
        this.HP_Restore = HP_Restore;
        publicHP_Restore = HP_Restore;
    }
    
    //ToString()
    public String toString()
    {
        String output = super.toString() + "Restores " + HP_Restore + " HP";
        return output;
    }
}
