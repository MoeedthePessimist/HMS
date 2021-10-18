package Object;

import java.io.Serializable;
import java.util.Random;

public class Hardware implements Serializable {

    private double id;
    private String name;
    private double price;
    private String category;
    private String manufacturer;
    private String description;
    private double quantity;


    public Hardware() {
        this.id = 0;
        this.name = "";
        this.price = 0;
        this.category = "";
        this.manufacturer = "";
        this.description = "";
    }

    public Hardware(String name, String category, String manufacturer, String description, double price, double quantity) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.manufacturer = manufacturer;
        this.description = description;
        this.quantity = quantity;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getQuantity() { return quantity; }

    public void setQuantity(double quantity) { this.quantity = quantity; }

    public void displayHardwareInfo() {
        System.out.println("----------------------------------------");
            System.out.printf("ID: %d\nNAME: %s\nPRICE: $%.2f\nCATEGORY: %s\nMANUFACTURER: %s\nDESCRIPTION: %s\nQUANTITY: %d\n",
                    (int) this.getId(),
                    this.getName(),
                    this.getPrice(),
                    this.getCategory(),
                    this.getManufacturer(),
                    this.getDescription(),
                    (int) this.getQuantity());
    }

    public void reset() {
        this.id = 0;
        this.name = "";
        this.price = 0;
        this.category = "";
        this.manufacturer = "";
        this.description = "";
    }
}
