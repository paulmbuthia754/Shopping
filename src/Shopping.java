import java.util.List;

public class Shopping {
    private List<Item> items;
    
    private double amountPaid;
    private String paymentMethod;

    private String receitptNo;

    public void addItem(Item it) {
        this.items.add(it);
    }

    public void removeItem(Item it) {
        this.items.remove(it);
    }
    public void makePayment(Double amount, String receiptNo, String method) {
        this.amountPaid = amount;
        this.paymentMethod = method;
        this.receitptNo = receiptNo;

    }
    public double getTotal() {
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
        System.out.println(this.getTotal());
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

class AppC {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        
        Item chair = new Item("chair", 2000.00);

    }
}
