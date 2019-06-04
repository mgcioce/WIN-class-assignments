import store.Employee;

import java.util.UUID;

public class Driver {

    public static void main(String[] args) {
        Employee e = new Employee(UUID.randomUUID(),"Bob Doody","11/03/1988",
                "Manager",18.50);
        System.out.println(String.format("id: %s\nname: %s\nDOB: %s\nPosition: %s\nHourly Rate: $%.2f",
                e.getEmployeeID(),e.getName(),e.getDOB(),e.getPosition(),e.getHourlyRate()));
    }
}
