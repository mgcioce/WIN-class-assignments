package library.persons;

public class Contributor {

    private Long contributorId;
    private String firstName;
    private String lastName;
    private String profession;

    public Contributor(Long contributorId, String firstName, String lastName, String profession) {
        this.contributorId = contributorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profession = profession;
    }

    public Long getContributorId() {
        return contributorId;
    }

    public void setContributorId(Long contributorId) {
        this.contributorId = contributorId;
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

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
