package library.persons;

public class Publisher {

    private Long publisherId;
    private String name;
    private String address;

    public Publisher(Long publisherId, String name, String address) {
        this.publisherId = publisherId;
        this.name = name;
        this.address = address;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
