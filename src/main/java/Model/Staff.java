package Model;

public class Staff {
    private String firstName;
    private String lastName;
    private String email;
    private int StaffID;

    public Staff(String firstName, String lastName, String email,int StaffID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.StaffID = StaffID;
    }

    public Staff() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }
    public int getStaffID() {
        return StaffID;
    }
    public void setStaffID(int staffID) {
        this.StaffID = staffID;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", StaffID=" + StaffID +
                '}';
    }
}
