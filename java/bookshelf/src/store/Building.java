package store;

public class Building {

    private String address;
    private int sqft;
    private String landlord;
    private String landlordPhoneNumber;

    public Building(String address, int sqft, String landlord, String landlordPhoneNumber) {
        this.address = address;
        this.sqft = sqft;
        this.landlord = landlord;
        this.landlordPhoneNumber = landlordPhoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSqft() {
        return sqft;
    }

    public void setSqft(int sqft) {
        this.sqft = sqft;
    }

    public String getLandlord() {
        return landlord;
    }

    public void setLandlord(String landlord) {
        this.landlord = landlord;
    }

    public String getLandlordPhoneNumber() {
        return landlordPhoneNumber;
    }

    public void setLandlordPhoneNumber(String landlordPhoneNumber) {
        this.landlordPhoneNumber = landlordPhoneNumber;
    }
}
