package OCP;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingOCP {
    private List<Item> items  = new ArrayList<Item>();
    

    public void addItem(Item it) {
        this.items.add(it);
    }

    public void removeItem(Item it) {
        this.items.remove(it);
    }

    public List<Item> getItems() {
        return items.stream().collect(Collectors.toList());
    }
    

}

class Payment {
    private ShoppingOCP cart;
    private PricingStrategy pricingStrategy;
    private String paymentMethod;
    
    public Payment(ShoppingOCP cart, PricingStrategy ps) {
        this.cart = cart;
        this.pricingStrategy = ps;
    }

    public double getTotalPrice() {
        var total = 0;
        for (Item item : cart.getItems()) {
            total += pricingStrategy.calculatePrice(item);
        }
        return total;
    }

    public void makePayment(String method) {
        this.paymentMethod = method;
    }
    
    public void printReceipt() {
        System.out.println("List of Items");
        System.out.println();
    
        for (Item item : cart.getItems()) {
           System.out.println(item.getName() + " " + item.getPrice()); 
        }
        System.out.println(this.getTotalPrice());
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
}
}

class Item {
    private String name;
    private double price;

    Item(String name_, double price_) {
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

class AppOCP {
    public static void main(String[] args) throws Exception {
        Item item = new Item("chair", 2000.00);        
        Item item1 = new Item("table", 4000.00);

        ShoppingOCP shopping = new ShoppingOCP();
        shopping.addItem(item);        
        shopping.addItem(item1);

        System.out.println("------------------START------------------");    

        System.out.println("--ITEMS--"); 
        for(Item i: shopping.getItems()){
            System.out.println(i.getName() + " <-------> " + i.getPrice());
        }     

        System.out.println("--NORMAL PRICES--");
        NormalPricingStrategy np = new NormalPricingStrategy();
        Payment payment = new Payment(shopping, np);
        System.out.println(payment.getTotalPrice());
        System.out.println("--END NORMAL PRICES--");         
        
        System.out.println("--DISCOUNT PRICES--");   
        DiscountPricingStrategy dp = new DiscountPricingStrategy(.1);
        Payment payment1 = new Payment(shopping, dp);
        System.out.println(payment1.getTotalPrice());     
        System.out.println("--END DISCOUNT PRICES--"); 



        System.out.println("------------------END------------------");

    }
}


