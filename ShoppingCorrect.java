import java.util.List;

public class ShoppingCorrect {
    private List<Item> items;
    

    public void addItem(Item it) {
        this.items.add(it);
    }

    public void removeItem(Item it) {
        this.items.remove(it);
    }

    public float getTotal() {
        var total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }
    public List<Item> getItems() {
        return items;
    }
    

}

class Payment {
    private float amountPaid;
    private String paymentMethod;

    private String receitptNo;
    private ShoppingCorrect cart;
    
    public Payment(Float amount, String receiptNo, String method, ShoppingCorrect cart) {
        this.amountPaid = amount;
        this.paymentMethod = method;
        this.receitptNo = receiptNo;
        this.cart = cart;
    }
    public void printReceipt() {
        System.out.println("List of Items");
        System.out.println();
    
        for (Item item : cart.getItems) {
           System.out.println(item.getName() + " " + item.getPrice()); 
        }
        System.out.println(this.getTotal());
    }
}

public class Item {
    private String name;
    private float price;

    Item(String name_, Float price_) {
        this.price = price_;
        this.name = name_;
    }

    public String getName() {
        return name;
    }
    public float getPrice() {
        return price;
    }
}
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        
        Item chair = new Item("chair", 2000.00);

    }
}

