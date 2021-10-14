package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) throws Exception {

        Device mbPro = new Device(true,
                21,
                "MAC",
                new Laptop("MacBook Pro", "2020", 8839295),
                "Mac", "Book", "Apple");
        JAXBContext context = JAXBContext.newInstance(Device.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(mbPro, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Device rsl = (Device) unmarshaller.unmarshal(reader);
            System.out.println(rsl);
        }

    }
}