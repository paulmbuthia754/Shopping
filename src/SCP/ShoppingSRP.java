package SCP;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingSRP {
    private List<Item> items = new ArrayList<Item>();

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
    private ShoppingSRP cart;
    private String paymentMethod;

    public Payment(ShoppingSRP cart) {
        this.cart = cart;
    }

    public double getTotalPrice() {
        var total = 0;
        for (Item item : cart.getItems()) {
            total += item.getPrice();
        }
        return total;
    }

    public double getNormalPrice() {
        var total = 0;
        for (Item item : cart.getItems()) {
            total += item.getPrice();
        }
        return total;
    }

    public double getDiscountPrice(double discountRate) {

        var total = 0;
        for (Item item : cart.getItems()) {
            total += item.getPrice() * (1 - discountRate);
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

class AppSRP {
    public static void main(String[] args) throws Exception {
        Item item = new Item("chair", 2000.00);        
        Item item1 = new Item("table", 4000.00);

        ShoppingSRP shopping = new ShoppingSRP();
        shopping.addItem(item);        
        shopping.addItem(item1);

        System.out.println("------------------START------------------");    

        System.out.println("--ITEMS--"); 
        for(Item i: shopping.getItems()){
            System.out.println(i.getName() + " <-------> " + i.getPrice());
        }     

        System.out.println("--NORMAL PRICES--");
        Payment payment = new Payment(shopping);
        System.out.println(payment.getNormalPrice());
        System.out.println("--END NORMAL PRICES--");         
        
        System.out.println("--DISCOUNT PRICES--");   
        System.out.println(payment.getDiscountPrice(.1));     
        System.out.println("--END DISCOUNT PRICES--"); 



        System.out.println("------------------END------------------");

    }
}
