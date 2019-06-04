package store;

import java.util.UUID;

public class Employee {

    private UUID employeeID;
    private String name;
    private String DOB;
    private String position;
    private double hourlyRate;

    public Employee(String employeeID,String name, String DOB, String position, double hourlyRate) {
        parseEmployeeIdDecimal(employeeID);
        this.employeeID = ;
        this.name = name;
        this.DOB = DOB;
        this.position = position;
        this.hourlyRate = hourlyRate;
    }

    public String getEmployeeID() {
        return employeeID.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public String[] parseEmployeeIdDecimal(String employeeID) {

    }
}
