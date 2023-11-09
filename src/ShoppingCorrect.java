import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ShoppingCorrect {
    private List<Item> items;
    

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
    private double amountPaid;
    private String paymentMethod;
    private String receitptNo;
    private ShoppingCorrect cart;
    private PricingStrategy pricingStrategy;
    
    public Payment(double amount, String receiptNo, String method, ShoppingCorrect cart, PricingStrategy ps) {
        this.amountPaid = amount;
        this.paymentMethod = method;
        this.receitptNo = receiptNo;
        this.cart = cart;
        this.pricingStrategy = ps;
    }
    public double getTotal() {
        var total = 0;
        for (Item item : cart.getItems()) {
            total += pricingStrategy.calculatePrice(item);
        }
        return total;
    }
    
    public void printReceipt() {
        System.out.println("List of Items");
        System.out.println();
    
        for (Item item : cart.getItems()) {
           System.out.println(item.getName() + " " + item.getPrice()); 
        }
        System.out.println(this.getTotal());
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
class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        
        Item chair = new Item("chair", 2000.00);

    }
}

