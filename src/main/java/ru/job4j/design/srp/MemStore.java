package ru.job4j.design.srp;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class MemStore implements Store {

    @XmlElement(name = "employee")
    private List<Employee> employees = new ArrayList<>();

    public MemStore(List<Employee> employees) {
        this.employees = employees;
    }

    public MemStore() {
    }

    public void add(Employee em) {
        employees.add(em);
    }

    @Override
    public List<Employee> findBy(Predicate<Employee> filter) {
        return employees.stream().filter(filter).collect(Collectors.toList());
    }
}