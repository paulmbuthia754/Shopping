public interface PricingStrategy {

    double calculatePrice(Item item);
}

class NormalPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(Item item) {
        return item.getPrice();
    }
}

class DiscountPricingStrategy implements PricingStrategy {
    private double discountRate;

    public DiscountPricingStrategy(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public double calculatePrice(Item item) {
        return item.getPrice() * (1 - discountRate);
    }
}