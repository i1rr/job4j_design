package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "laptop")
public class Laptop {

    @XmlAttribute
    private String name;
    private String model;
    private float serial;

    public Laptop() {
    }

    public Laptop(String name, String model, float serial) {
        this.name = name;
        this.model = model;
        this.serial = serial;
    }

    @Override
    public String toString() {
        return "Laptop{"
                + "name='" + name + '\''
                + ", model='" + model + '\''
                + ", serial=" + serial
                + '}';
    }
}
