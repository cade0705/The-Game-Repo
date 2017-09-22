import java.util.ArrayList;
public class TestBattle
{
    public static void test(String[] args) throws InterruptedException
    {       
        Weapon Sword1 = new Weapon("Sword1", "Weapon", 4);
        Weapon Sword2 = new Weapon("Sword2", "Weapon", 8);
        Armor Armor1 = new Armor("Armor1", "Armor", 30);
        Armor Armor2 = new Armor("Armor2", "Armor", 3);
        Food Food1 = new Food("Food1", "Food", 5);
        Food Food2 = new Food("Food2", "Food", 7);
        
        Inventory.addItem(Sword1);
        Inventory.addItem(Sword2);
        Inventory.addItem(Armor1);
        Inventory.addItem(Armor2);
        Inventory.addItem(Food1);
        Inventory.addItem(Food2);
        
        Player testPlayer = new Player("DEBUG");
        Enemy testEnemy = new Enemy("Test Enemy", 10, 10, 2, 20);
        
        Battle.Start(testEnemy, testPlayer);
    }
}