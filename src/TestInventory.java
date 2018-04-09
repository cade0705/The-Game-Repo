public class TestInventory
{
    public static void test()
    {
        //Create objects (Items)
        Weapon MasterSword = new Weapon("Master Sword", "Weapon", 4);
        Armor Helmet = new Armor("Iron Helmet", "Armor", 3); 
        Food IceCream = new Food ("Ice Cream", "Food", 25);
        
        //Add Items to list
        Inventory.addItem(MasterSword); //Use to add item
        Inventory.addItem(Helmet);
        Inventory.addItem(IceCream); 
        
        //Print the Player's inventory
        System.out.println(Inventory.print()); 
        
        System.out.println();
        
        System.out.println("After deleting an item\n");
        Inventory.removeItem(Helmet); //Use to delete an item
        
        System.out.println(Inventory.print());
    }
}
