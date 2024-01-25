// Abstract class 
abstract class Product {
    String itemName;
    double price;

    // Constructor
    public Product(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

    // Abstract method to calculate total sales
    abstract double calculateTotalSales();
}

// Interface representing products that can be sold in quantities
interface Quantifiable {
    int getQuantitySold();
}

// Concrete class 
class Phone extends Product implements Quantifiable {
    int quantitySold;

    // Constructor
    public Phone(String itemName, double price, int quantitySold) {
        super(itemName, price);
        this.quantitySold = quantitySold;
    }

    // Implementing abstract method to calculate total sales for phones
    @Override
    double calculateTotalSales() {
        return price * quantitySold;
    }

    // Implementing interface method to get quantity sold
    @Override
    public int getQuantitySold() {
        return quantitySold;
    }
}

// Concrete class representing repair services
class RepairService extends Product {
    double pricePerHour;
    int numberOfHours;

    // Constructor
    public RepairService(String itemName, double pricePerHour, int numberOfHours) {
        super(itemName, 0); // Price for services is calculated differently, so set to 0 initially
        this.pricePerHour = pricePerHour;
        this.numberOfHours = numberOfHours;
    }

    // Implementing abstract method to calculate total sales for repair services
    @Override
    double calculateTotalSales() {
        return pricePerHour * numberOfHours;
    }
}

// Main class to test the program
public class SalesCalculator {
    public static void main(String[] args) {
        
        Phone phone = new Phone("Phone", 500.0, 10);
        RepairService repairService = new RepairService("Repair", 50.0, 5);

        // Calculate and display total sales for each product
        System.out.println("Total sales for " + phone.itemName + ": ₱" + phone.calculateTotalSales());
        System.out.println("Total sales for " + repairService.itemName + ": ₱" + repairService.calculateTotalSales());
    }
}