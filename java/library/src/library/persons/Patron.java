package library.persons;

import java.time.LocalDate;

public class Patron {

    private Long patronId;
    private String firstName;
    private String lastName;
    private LocalDate DOB;
    private String address;
    private String phoneNumber;
    private String driversLicense;

    public Patron(Long patronId, String firstName, String lastName, LocalDate DOB,
                  String address, String phoneNumber, String driversLicense) {

        this.patronId = patronId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.driversLicense = driversLicense;
    }

    public Long getPatronId() {
        return patronId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDriversLicense() {
        return driversLicense;
    }

    public void setDriversLicense(String driversLicense) {
        this.driversLicense = driversLicense;
    }
}
