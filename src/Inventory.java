import java.util.ArrayList;
public class Inventory
{
    // use the checkItem() method to make sure an item is in the player's inventory so I don't have to make bools for all of them
    
    
    private static ArrayList<Item> inventoryList = new ArrayList<Item>();
    
    //Method to add an item to the player's inventory
    public static void addItem(Item item)
    {
        inventoryList.add(item);
    }
      
    //Method to delete an item from the player's inventory
    public static void removeItem(Item oldItem)
    {
        inventoryList.remove(oldItem);
    }

    //Check to make sure that the item is in the inventory
    public static boolean checkItem(String itemToCheck)
    {
        boolean output = false;
        for(int i = 0; i < inventoryList.size(); i++)
        {
            if(inventoryList.get(i).getName().equals(itemToCheck))
            {
                output = true;
            }
        }
        return output;
    }
    
    //Returns the type of the item
    public static String getItemType(String itemName)
    {
        String output = "";
        for(int i = 0; i < inventoryList.size(); i++)
        {
            if(inventoryList.get(i).getName().equals(itemName))
            {
                output = inventoryList.get(i).getType();
            }
        }
        return output;
    }
    
    public static int getItemATK(String itemName)
    {
        int output = 0;
        for(int i = 0; i < inventoryList.size(); i++)
        {
            if(inventoryList.get(i).getName().equals(itemName))
            {
                output = inventoryList.get(i).getATK();
            }
        }
        return output;
    }
    
    public static int getItemDEF(String itemName)
    {
        int output = 0;
        for(int i = 0; i < inventoryList.size(); i++)
        {
            if(inventoryList.get(i).getName().equals(itemName))
            {
                output = inventoryList.get(i).getDEF();
            }
        }
        return output;
    }
    
     public static int getItemHP(String itemName)
    {
        int output = 0;
        for(int i = 0; i < inventoryList.size(); i++)
        {
            if(inventoryList.get(i).getName().equals(itemName))
            {
                output = inventoryList.get(i).getHP();
                removeItem(inventoryList.get(i));
            }
        }
        return output;
    }
    
    //Method to print the player's inventory
    public static String print()
    {
        String output = "";
        for(Item I: inventoryList)
        {
            output += I + "\n";
        } 
        return output;
    }
}
