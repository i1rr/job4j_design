package ru.job4j.design.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Calendar;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void developDepartment() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportDeveloper(store);
        StringBuilder expect = new StringBuilder()
                .append("<!DOCTYPE HTML>")
                .append("<html><head><title>Report</title></head><body><table>")
                .append("<tr>")
                .append("<th>Name</th>")
                .append("<th>Hired</th>")
                .append("<th>Fired</th>")
                .append("<th>Salary</th>")
                .append("</tr>")
                .append("<tr><td>").append(worker.getName()).append("</tr><td>")
                .append("<tr><td>").append(worker.getHired()).append("</tr><td>")
                .append("<tr><td>").append(worker.getFired()).append("</tr><td>")
                .append("<tr><td>").append(worker.getSalary()).append("</tr><td>")
                .append("</table></body></html>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void financeDepartment() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report repFinance = new ReportFinance(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Hourly rate;")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary() / 72).append(";");
        assertThat(repFinance.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void hrDepartment() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee ivan = new Employee("Ivan", now, now, 100);
        Employee anton = new Employee("Anton", now, now, 45);
        Employee fedor = new Employee("Fedja", now, now, 85);
        store.add(ivan);
        store.add(anton);
        store.add(fedor);
        Report repHR = new ReportHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(ivan.getName()).append(";")
                .append(ivan.getSalary() / 72).append(";")
                .append(System.lineSeparator())

                .append(fedor.getName()).append(";")
                .append(fedor.getSalary() / 72).append(";")
                .append(System.lineSeparator())

                .append(anton.getName()).append(";")
                .append(anton.getSalary() / 72).append(";");

        assertThat(repHR.generate(em -> true), is(expect.toString()));
    }
}