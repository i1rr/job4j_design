package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ReportFinance implements Report {

    private final Store store;

    public ReportFinance(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Hourly rate;");
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary() / 72).append(";");
        }
        return text.toString();
    }
}
