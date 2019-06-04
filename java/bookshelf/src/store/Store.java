package store;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Store {

    private HashMap<String,Employee> employees;
    private Building building;
    private HashMap<String, ArrayList<Item> > inventory;
    private String businessName;
    private BusinessHours hoursOfOperation;

    public Store(String businessName) {
        this.employees = new HashMap<String,Employee>();
        this.building = null;
        this.inventory = new HashMap<String, ArrayList<Item>>();
        this.businessName = businessName;
        this.hoursOfOperation = null;
    }

    public String getEmployees() {
        String returnString = "";
        for (Map.Entry<String,Employee> e: this.employees.entrySet()) {
           Employee next = e.getValue();
           returnString += next.getName() + ": " + next.getPosition() + "\n";
        }
        return returnString;
    }

    public boolean addEmployee(String name, String DOB, String position, double hourlyRate) {
        Employee newEmployee = new Employee(UUID.randomUUID(),name,DOB,position,hourlyRate);
        if (this.employees.containsKey(newEmployee.getEmployeeID())) {
            return false;
        }
        this.employees.put(newEmployee.getEmployeeID(),newEmployee);
        return true;
    }

    public void setEmployees(HashMap<String, Employee> employees) {
        this.employees = employees;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public String getInventory() {
        String returnString = "";
        for (Map.Entry<String,ArrayList<Item>> itemSet: this.inventory.entrySet()) {
            ArrayList<Item> next = itemSet.getValue();
            for (Item i : next) {
                returnString += i.getItemId() + ", " + i.getName() + ", " + i.getPrice() + "\n";
            }
        }
        return returnString;
    }

    public void setInventory(HashMap<String, ArrayList<Item>> inventory) {
        this.inventory = inventory;
    }

    public boolean addToInventory(String id, String name, double price) {
        UUID itemID = UUID.fromString(id);
        Item newItem = new Item(itemID,name,price);
        if (this.inventory.containsKey(newItem.getItemId())) {
            ArrayList<Item> list = this.inventory.get(newItem.getItemId());
            list.add(newItem);
            return true;
        } else {
            ArrayList<Item> list = new ArrayList<>();
            list.add(newItem);
            this.inventory.put(newItem.getItemId(),list);
            return false;
        }
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getHoursOfOperation() {
        return this.hoursOfOperation.getBusinessHours();
    }

    public void setHoursOfOperation(String day, LocalTime open, LocalTime close) {
        this.hoursOfOperation.setBusinessHours(day, open, close);
    }

    public void setHolidayHours(String holiday, LocalTime open, LocalTime close) {
        this.hoursOfOperation.setHolidayHours(holiday, open, close);
    }

    public boolean isOpen(String holiday) {
        return this.hoursOfOperation.isOpen(holiday);
    }
}
