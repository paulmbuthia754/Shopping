import java.util.ArrayList;
import java.util.List;
public class Shopping {
    private List<Item> items = new ArrayList<Item>();
    
    private String paymentMethod;

    public void addItem(Item it) {
        this.items.add(it);
    }

    public void removeItem(Item it) {
        this.items.remove(it);
    }

    public List<Item> getItems() {
        return this.items;
    }
    
    public void makePayment(String method) {
        this.paymentMethod = method;
    }

    public double getTotalPrice() {
        var total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public double getNormalPrice() {
        var total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }
    public double getDiscountPrice(double discountRate) {

        var total = 0;
        for (Item item : items) {
            total += item.getPrice() * (1 - discountRate);
        }
        return total;
    }

    public void printReceipt() {
        System.out.println("List of Items");
        System.out.println();
    
        for (Item item : items) {
           System.out.println(item.getName() + " " + item.getPrice()); 
        }
        System.out.println(this.getTotalPrice());
    }
}

class Item {
    private String name;
    private double price;

    Item(String name_, Double price_) {
        this.price = price_;
        this.name = name_;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
}

class App1 {
    public static void main(String[] args) {
        
        Item item = new Item("chair", 2000.00);        
        Item item1 = new Item("table", 4000.00);

        Shopping shopping = new Shopping();
        shopping.addItem(item);        
        shopping.addItem(item1);

        System.out.println("------------------START------------------");    

        System.out.println("--ITEMS--"); 
        for(Item i: shopping.getItems()){
            System.out.println(i.getName() + " <-------> " + i.getPrice());
        }     

        System.out.println("--NORMAL PRICES--");
        var np = shopping.getNormalPrice();
        System.out.println(np);
        System.out.println("--END NORMAL PRICES--");         
        
        System.out.println("--DISCOUNT PRICES--");   
        var dp = shopping.getDiscountPrice(.1);
        System.out.println(dp);     
        System.out.println("--END DISCOUNT PRICES--"); 



        System.out.println("------------------END------------------");

    }
}
