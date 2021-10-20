package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ReportDeveloper implements Report {

    private Store store;

    public ReportDeveloper(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<!DOCTYPE HTML>")
                .append("<html><head><title>Report</title></head><body><table>")
                .append("<tr>")
                .append("<th>Name</th>")
                .append("<th>Hired</th>")
                .append("<th>Fired</th>")
                .append("<th>Salary</th>")
                .append("</tr>");
        for (Employee employee : store.findBy(filter)) {
            text.append("<tr><td>").append(employee.getName()).append("</tr><td>")
                    .append("<tr><td>").append(employee.getHired()).append("</tr><td>")
                    .append("<tr><td>").append(employee.getFired()).append("</tr><td>")
                    .append("<tr><td>").append(employee.getSalary()).append("</tr><td>");
        }
        text.append("</table></body></html>");
        return text.toString();
    }
}
