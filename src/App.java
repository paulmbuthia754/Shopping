import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        
        Item item1 = new Item("chair", 2000.00);        
        Item item2 = new Item("chair", 2000.00);


        Shopping shopping = new Shopping();
        shopping.addItem(item1);        
        // shopping.addItem(item2);

        // System.out.println(shopping.getNormalPrice());

    }
}
