package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "device")
@XmlAccessorType(XmlAccessType.FIELD)
public class Device {

    @XmlAttribute
    private boolean inStock;
    private int quantity;
    private String type;
    private Laptop laptop;
    private String[] tag;

    public Device() {
    }

    public Device(boolean inStock, int quantity, String type, Laptop laptop, String... tag) {
        this.inStock = inStock;
        this.quantity = quantity;
        this.type = type;
        this.laptop = laptop;
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Device{"
                + "inStock=" + inStock
                + ", quantity=" + quantity
                + ", type='" + type + '\''
                + ", laptop=" + laptop
                + ", tag=" + Arrays.toString(tag)
                + '}';
    }

    public static void main(String[] args) {
    }
}
